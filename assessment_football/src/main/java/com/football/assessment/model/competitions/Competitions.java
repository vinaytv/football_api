package com.football.assessment.model.competitions;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country_id", "country_name", "league_id", "league_name" })
public class Competitions {

	@JsonProperty("country_id")
	private String country_id;
	@JsonProperty("country_name")
	private String country_name;
	@JsonProperty("league_id")
	private String league_id;
	@JsonProperty("league_name")
	private String league_name;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("country_id")
	public String getCountry_id() {
		return country_id;
	}

	@JsonProperty("country_id")
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	@JsonProperty("country_name")
	public String getCountry_name() {
		return country_name;
	}

	@JsonProperty("country_name")
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@JsonProperty("league_id")
	public String getLeague_id() {
		return league_id;
	}

	@JsonProperty("league_id")
	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}

	@JsonProperty("league_name")
	public String getLeague_name() {
		return league_name;
	}

	@JsonProperty("league_name")
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}