package com.football.assessment.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.assessment.exception.GenericException;
import com.football.assessment.exception.RemoteServerException;
import com.football.assessment.model.Standings;
import com.football.assessment.model.standings.StandingsResponse;
import com.football.assessment.service.CompetitionsService;
import com.football.assessment.service.CountriesService;
import com.football.assessment.service.StandingsService;
import com.football.assessment.service.TeamsService;
import com.football.assessment.utility.CommonUtility;

@Service
public class StandingsServiceImpl implements StandingsService {

	Logger logger = LoggerFactory.getLogger(StandingsServiceImpl.class);

	@Autowired
	CountriesService countriesService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CommonUtility commonUtility;

	@Autowired
	CompetitionsService competitionsService;

	@Autowired
	TeamsService teamsService;

	@Value("${football.standings.url}")
	private String standingsUrl;

	@Override
	public ResponseEntity<Standings> getStandings(String teamName, String leagueName, String countryName,
			String trackingId) {
		Standings standings = new Standings();
		logger.info(
				String.format("Fetching standings for trackingid=%1$s,teamName=%2$s,countryName=%3$s, leagueName=%4$s ",
						trackingId, teamName, countryName, leagueName));

		String countryId = countriesService.getCountryId(countriesService.getCountries(trackingId), countryName,
				trackingId);
		String leagueId = competitionsService.getLeagueId(competitionsService.getCompetitions(trackingId, countryId),
				trackingId, countryId);
		standings.setCountryId(countryId);
		standings.setCountryName(countryName);
		standings.setLeagueId(leagueId);
		standings.setLeagueName(leagueName);
		String teamId = teamsService.getTeamId(teamsService.getTeams(trackingId, leagueId), teamName, trackingId);
		standings.setTeamId(teamId);
		standings.setTeamName(teamName);
		Collection<StandingsResponse> responseValues = null;
		List<StandingsResponse> standingsList = null;
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.getForEntity(commonUtility.getUri(standingsUrl).toUriString().toString()+"&league_id="+leagueId, String.class);

			responseValues = new ObjectMapper().readValue(response.getBody(), new TypeReference<Collection<StandingsResponse>>() {
			});
			standingsList = new ArrayList<>(responseValues);
			standingsList.forEach(standingsResponse->{
				if(countryName.equals(standingsResponse.getCountry_name()) &&  teamName.equals(standingsResponse.getTeam_name()) && leagueName.equals(standingsResponse.getLeague_name()))
						standings.setPosition(standingsResponse.getOverall_league_position());		
			});
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			logger.info(String.format("Fetching standings for trackingid=%1$s failed , errorMessage=%2$s", trackingId,
					e.getMessage()));

			throw new RemoteServerException(e.getStatusCode(), "Fetching standings failed", e.getResponseBodyAsString(),
					trackingId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(String.format("Fetching standings for trackingid=%1$s failed , errorMessage=%2$s", trackingId,
					e.getMessage()));
			throw new GenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching standings failed", e.getMessage(),
					trackingId);

		}

		return new ResponseEntity<Standings>(standings, HttpStatus.OK);
	}

}
