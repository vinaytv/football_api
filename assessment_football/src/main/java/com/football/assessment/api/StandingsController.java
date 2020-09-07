package com.football.assessment.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.football.assessment.exception.ClientErrorException;
import com.football.assessment.model.Standings;
import com.football.assessment.service.StandingsService;
import com.football.assessment.utility.CommonUtility;

@RestController
@RequestMapping("v1")
public class StandingsController {

	Logger logger = LoggerFactory.getLogger(StandingsController.class);

	@Autowired
	CommonUtility commonUtility;

	@Autowired
	StandingsService standingsService;

	/**
	 * API to fetch standing based on Team, Country and League names.
	 * 
	 * @param teamName
	 * @param leagueName
	 * @param countyrName
	 * @return
	 */
	@GetMapping("standings")
	public ResponseEntity<Standings> getStandings(@RequestParam String teamName, @RequestParam String leagueName,
			@RequestParam String countryName) {

		String trackingId = commonUtility.generateTracingId();

		if (null == teamName || null == countryName || null == leagueName)
			throw new ClientErrorException(HttpStatus.BAD_REQUEST, "Missing parameters",
					"All input parameters are mandatory", trackingId);
		logger.info(
				String.format("Fetching standings for trackingid=%1$s,teamName=%2$s,countryName=%3$s, leagueName=%4$s ",
						trackingId, teamName, countryName, leagueName));
		return standingsService.getStandings(teamName, leagueName, countryName, trackingId);
	}
}
