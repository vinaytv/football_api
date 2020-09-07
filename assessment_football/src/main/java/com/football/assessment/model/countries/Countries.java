package com.football.assessment.model.countries;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country_id", "country_name" })
public class Countries {

	@JsonProperty("country_id")
	private String country_id;
	@JsonProperty("country_name")
	private String country_name;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}