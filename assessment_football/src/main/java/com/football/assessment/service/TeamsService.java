package com.football.assessment.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
import com.football.assessment.exception.ClientErrorException;
import com.football.assessment.exception.GenericException;
import com.football.assessment.exception.RemoteServerException;
import com.football.assessment.model.teams.Team;
import com.football.assessment.utility.CommonUtility;

@Service
public class TeamsService {
	Logger logger = LoggerFactory.getLogger(TeamsService.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CommonUtility commonUtility;

	@Value("${football.teams.url}")
	private String teamsUrl;

	/**
	 * API to fetch the teams
	 * 
	 * @param trackingId
	 * @return
	 */
	public List<Team> getTeams(String trackingId,String leagueId) {
		logger.info(String.format("Fetching teams for trackingid=%1$s started", trackingId));
		Collection<Team> responseValues = null;
		List<Team> teams = null;
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(commonUtility.getUri(teamsUrl).toUriString().toString()+"&league_id="+leagueId, String.class);
			responseValues = new ObjectMapper().readValue(response.getBody(), new TypeReference<Collection<Team>>() {
			});

			teams = new ArrayList<>(responseValues);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			logger.info(String.format("Fetching teams for trackingid=%1$s failed , errorMessage=%2$s", trackingId,
					e.getMessage()));

			throw new RemoteServerException(e.getStatusCode(), "Fetching teams failed", e.getResponseBodyAsString(),
					trackingId);
		} catch (Exception e) {
			logger.info(String.format("Fetching teams for trackingid=%1$s failed , errorMessage=%2$s", trackingId,
					e.getMessage()));
			throw new GenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching teams failed", e.getMessage(),
					trackingId);

		}

		return teams;
	}

	/**
	 * Method to get country id from country name
	 * 
	 * @param countries
	 * @param countryName
	 * @return
	 */
	public String getTeamId(List<Team> teams, String teamName, String trackingId) {
		AtomicReference<String> atomicString = new AtomicReference<String>();
		logger.info(String.format("Fetching team id  for trackingid=%1$s ", trackingId));

		if (null != teams) {
			teams.forEach(team -> {
				if (teamName.equals(team.getTeam_name()))
					atomicString.set(team.getTeam_key());
			});
		}
		if (null == atomicString.get()) {
			logger.info(String.format("Fetching team id  for trackingid=%1$s failed , invalid team name",
					trackingId));
			throw new ClientErrorException(HttpStatus.BAD_REQUEST, "Invalid team name",
					"Team name passed is invalid or not supported", trackingId);

		}
		return atomicString.get();
	}

}
