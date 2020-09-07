
package com.football.assessment.model.teams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "team_key",
    "team_name",
    "team_badge",
    "players",
    "coaches"
})
public class Team {

    @JsonProperty("team_key")
    private String team_key;
    @JsonProperty("team_name")
    private String team_name;
    @JsonProperty("team_badge")
    private String team_badge;
    @JsonProperty("players")
    private List<Player> players = null;
    @JsonProperty("coaches")
    private List<Coach> coaches = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("team_key")
    public String getTeam_key() {
        return team_key;
    }

    @JsonProperty("team_key")
    public void setTeam_key(String team_key) {
        this.team_key = team_key;
    }

    @JsonProperty("team_name")
    public String getTeam_name() {
        return team_name;
    }

    @JsonProperty("team_name")
    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    @JsonProperty("team_badge")
    public String getTeam_badge() {
        return team_badge;
    }

    @JsonProperty("team_badge")
    public void setTeam_badge(String team_badge) {
        this.team_badge = team_badge;
    }

    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @JsonProperty("coaches")
    public List<Coach> getCoaches() {
        return coaches;
    }

    @JsonProperty("coaches")
    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Team [team_key=" + team_key + ", team_name=" + team_name + ", team_badge=" + team_badge + ", players="
				+ players + ", coaches=" + coaches + ", additionalProperties=" + additionalProperties + "]";
	}

}
