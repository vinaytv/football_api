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
import com.football.assessment.model.competitions.Competitions;
import com.football.assessment.utility.CommonUtility;

@Service
public class CompetitionsService {

	Logger logger = LoggerFactory.getLogger(CompetitionsService.class);
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CommonUtility commonUtility;

	@Value("${football.competitions.url}")
	private String competitionsUrl;

	/**
	 * Method to fetch the competitions for country
	 * 
	 * @param trackingId
	 * @param countryId
	 * @return
	 */
	public List<Competitions> getCompetitions(String trackingId, String countryId) {
		logger.info(String.format("Fetching Competitions for trackingid=%1$s started", trackingId));
		Collection<Competitions> responseValues = null;
		List<Competitions> competitions = null;
		ResponseEntity<String> response = null;
		try {

			response = restTemplate.getForEntity(
					commonUtility.getUri(competitionsUrl).toUriString().toString() + "&country_id=" + countryId,
					String.class);
			responseValues = new ObjectMapper().readValue(response.getBody(),
					new TypeReference<Collection<Competitions>>() {
					});
			competitions = new ArrayList<>(responseValues);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			logger.info(String.format("Fetching Competitions for trackingid=%1$s failed , errorMessage=%2$s",
					trackingId, e.getMessage()));

			throw new RemoteServerException(e.getStatusCode(), "Fetching Competitions failed",
					e.getResponseBodyAsString(), trackingId);
		} catch (Exception e) {
			logger.info(String.format("Fetching Competitions for trackingid=%1$s failed , errorMessage=%2$s",
					trackingId, e.getMessage()));
			throw new GenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching Competitions failed", e.getMessage(),
					trackingId);

		}

		return competitions;
	}

	/**
	 * Method to get league id
	 * 
	 * @param competitions
	 * @param trackingId
	 * @param countryId
	 * @return
	 */
	public String getLeagueId(List<Competitions> competitions, String trackingId, String countryId) {
		AtomicReference<String> atomicString = new AtomicReference<String>();
		logger.info(String.format("Fetching league id  for trackingid=%1$s ", trackingId));

		if (null != competitions) {
			competitions.forEach(league -> {
				if (countryId.equals(league.getCountry_id()))
					atomicString.set(league.getLeague_id());
			});
		}
		if (null == atomicString.get()) {
			logger.info(
					String.format("Fetching league id  for trackingid=%1$s failed , invalid country name", trackingId));
			throw new ClientErrorException(HttpStatus.BAD_REQUEST, "Invalid League name",
					"League name passed is invalid or not supported", trackingId);

		}

		logger.info(String.format("Fetching league id  for trackingid=%1$s completed ", trackingId));

		return atomicString.get();
	}

}
