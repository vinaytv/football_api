package com.football.assessment.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.football.assessment.model.Standings;

@Service
public interface StandingsService {

	/**
	 * Method to get standing of the team based on the input parameters.
	 * 
	 * @param teamName
	 * @param leagueName
	 * @param countryName
	 * @return
	 */
	ResponseEntity<Standings> getStandings(String teamName, String leagueName, String countryName, String trackingId);
}
