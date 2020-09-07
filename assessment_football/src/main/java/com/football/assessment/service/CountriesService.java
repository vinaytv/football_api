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
import com.football.assessment.model.countries.Countries;
import com.football.assessment.utility.CommonUtility;

@Service
public class CountriesService {
	Logger logger = LoggerFactory.getLogger(CountriesService.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CommonUtility commonUtility;

	@Value("${football.countries.url}")
	private String countriesUrl;

	/**
	 * API to fetch the countries
	 * 
	 * @param trackingId
	 * @return
	 */
	public List<Countries> getCountries(String trackingId) {
		logger.info(String.format("Fetching countries for trackingid=%1$s started", trackingId));
		Collection<Countries> responseValues = null;
		List<Countries> countries = null;
		ResponseEntity<String> response = null;
		try {

			response = restTemplate.getForEntity(commonUtility.getUri(countriesUrl).toUriString().toString(),
					String.class);
			responseValues = new ObjectMapper().readValue(response.getBody(),
					new TypeReference<Collection<Countries>>() {
					});
			countries = new ArrayList<>(responseValues);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			logger.info(String.format("Fetching countries for trackingid=%1$s failed , errorMessage=%2$s", trackingId,
					e.getMessage()));

			throw new RemoteServerException(e.getStatusCode(), "Fetching countries failed", e.getResponseBodyAsString(),
					trackingId);
		} catch (Exception e) {
			logger.info(String.format("Fetching countries for trackingid=%1$s failed , errorMessage=%2$s", trackingId,
					e.getMessage()));
			throw new GenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching countries failed", e.getMessage(),
					trackingId);

		}

		return countries;
	}

	/**
	 * Method to get country id from country name
	 * 
	 * @param countries
	 * @param countryName
	 * @return
	 */
	public String getCountryId(List<Countries> countries, String countryName, String trackingId) {
		AtomicReference<String> atomicString = new AtomicReference<String>();
		logger.info(String.format("Fetching country id  for trackingid=%1$s ", trackingId));

		if (null != countries) {
			countries.forEach(country -> {
				if (countryName.equals(country.getCountry_name()))
					atomicString.set(country.getCountry_id());
			});
		}
		if (null == atomicString.get()) {
			logger.info(String.format("Fetching country id  for trackingid=%1$s failed , invalid country name",
					trackingId));
			throw new ClientErrorException(HttpStatus.BAD_REQUEST, "Invalid country name",
					"Country name passed is invalid or not supported", trackingId);

		}
		return atomicString.get();
	}
}
