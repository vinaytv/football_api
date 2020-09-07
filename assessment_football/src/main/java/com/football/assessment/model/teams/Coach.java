
package com.football.assessment.model.teams;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coach_name",
    "coach_country",
    "coach_age"
})
public class Coach {

    @JsonProperty("coach_name")
    private String coach_name;
    @JsonProperty("coach_country")
    private String coach_country;
    @JsonProperty("coach_age")
    private String coach_age;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coach_name")
    public String getCoach_name() {
        return coach_name;
    }

    @JsonProperty("coach_name")
    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    @JsonProperty("coach_country")
    public String getCoach_country() {
        return coach_country;
    }

    @JsonProperty("coach_country")
    public void setCoach_country(String coach_country) {
        this.coach_country = coach_country;
    }

    @JsonProperty("coach_age")
    public String getCoach_age() {
        return coach_age;
    }

    @JsonProperty("coach_age")
    public void setCoach_age(String coach_age) {
        this.coach_age = coach_age;
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
