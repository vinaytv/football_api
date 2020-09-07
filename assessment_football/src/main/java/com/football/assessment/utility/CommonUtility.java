package com.football.assessment.utility;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CommonUtility {

	@Value("${football.services.apikey}")
	private String apiKey;

	/**
	 * Method to generate TrackingId
	 * 
	 * @return
	 */
	public String generateTracingId() {

		UUID uid = UUID.randomUUID();
		return uid.toString();
	}

	/**
	 * Method to get URI
	 * 
	 * @param mapOfParams
	 * @param url
	 * @return
	 */
	public UriComponentsBuilder getUri(String url) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url).queryParam("APIkey", apiKey);
		return uriBuilder;
	}

}
