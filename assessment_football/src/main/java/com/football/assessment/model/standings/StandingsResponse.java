package com.football.assessment.model.standings;


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
"country_name",
"league_id",
"league_name",
"team_id",
"team_name",
"overall_league_position",
"overall_league_payed",
"overall_league_W",
"overall_league_D",
"overall_league_L",
"overall_league_GF",
"overall_league_GA",
"overall_league_PTS",
"home_league_position",
"home_league_payed",
"home_league_W",
"home_league_D",
"home_league_L",
"home_league_GF",
"home_league_GA",
"home_league_PTS",
"away_league_position",
"away_league_payed",
"away_league_W",
"away_league_D",
"away_league_L",
"away_league_GF",
"away_league_GA",
"away_league_PTS"
})
public class StandingsResponse {

@JsonProperty("country_name")
private String country_name;
@JsonProperty("league_id")
private String league_id;
@JsonProperty("league_name")
private String league_name;
@JsonProperty("team_id")
private String team_id;
@JsonProperty("team_name")
private String team_name;
@JsonProperty("overall_league_position")
private String overall_league_position;
@JsonProperty("overall_league_payed")
private String overall_league_payed;
@JsonProperty("overall_league_W")
private String overall_league_W;
@JsonProperty("overall_league_D")
private String overall_league_D;
@JsonProperty("overall_league_L")
private String overall_league_L;
@JsonProperty("overall_league_GF")
private String overall_league_GF;
@JsonProperty("overall_league_GA")
private String overall_league_GA;
@JsonProperty("overall_league_PTS")
private String overall_league_PTS;
@JsonProperty("home_league_position")
private String home_league_position;
@JsonProperty("home_league_payed")
private String home_league_payed;
@JsonProperty("home_league_W")
private String home_league_W;
@JsonProperty("home_league_D")
private String home_league_D;
@JsonProperty("home_league_L")
private String home_league_L;
@JsonProperty("home_league_GF")
private String home_league_GF;
@JsonProperty("home_league_GA")
private String home_league_GA;
@JsonProperty("home_league_PTS")
private String home_league_PTS;
@JsonProperty("away_league_position")
private String away_league_position;
@JsonProperty("away_league_payed")
private String away_league_payed;
@JsonProperty("away_league_W")
private String away_league_W;
@JsonProperty("away_league_D")
private String away_league_D;
@JsonProperty("away_league_L")
private String away_league_L;
@JsonProperty("away_league_GF")
private String away_league_GF;
@JsonProperty("away_league_GA")
private String away_league_GA;
@JsonProperty("away_league_PTS")
private String away_league_PTS;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

@JsonProperty("team_id")
public String getTeam_id() {
return team_id;
}

@JsonProperty("team_id")
public void setTeam_id(String team_id) {
this.team_id = team_id;
}

@JsonProperty("team_name")
public String getTeam_name() {
return team_name;
}

@JsonProperty("team_name")
public void setTeam_name(String team_name) {
this.team_name = team_name;
}

@JsonProperty("overall_league_position")
public String getOverall_league_position() {
return overall_league_position;
}

@JsonProperty("overall_league_position")
public void setOverall_league_position(String overall_league_position) {
this.overall_league_position = overall_league_position;
}

@JsonProperty("overall_league_payed")
public String getOverall_league_payed() {
return overall_league_payed;
}

@JsonProperty("overall_league_payed")
public void setOverall_league_payed(String overall_league_payed) {
this.overall_league_payed = overall_league_payed;
}

@JsonProperty("overall_league_W")
public String getOverall_league_W() {
return overall_league_W;
}

@JsonProperty("overall_league_W")
public void setOverall_league_W(String overall_league_W) {
this.overall_league_W = overall_league_W;
}

@JsonProperty("overall_league_D")
public String getOverall_league_D() {
return overall_league_D;
}

@JsonProperty("overall_league_D")
public void setOverall_league_D(String overall_league_D) {
this.overall_league_D = overall_league_D;
}

@JsonProperty("overall_league_L")
public String getOverall_league_L() {
return overall_league_L;
}

@JsonProperty("overall_league_L")
public void setOverall_league_L(String overall_league_L) {
this.overall_league_L = overall_league_L;
}

@JsonProperty("overall_league_GF")
public String getOverall_league_GF() {
return overall_league_GF;
}

@JsonProperty("overall_league_GF")
public void setOverall_league_GF(String overall_league_GF) {
this.overall_league_GF = overall_league_GF;
}

@JsonProperty("overall_league_GA")
public String getOverall_league_GA() {
return overall_league_GA;
}

@JsonProperty("overall_league_GA")
public void setOverall_league_GA(String overall_league_GA) {
this.overall_league_GA = overall_league_GA;
}

@JsonProperty("overall_league_PTS")
public String getOverall_league_PTS() {
return overall_league_PTS;
}

@JsonProperty("overall_league_PTS")
public void setOverall_league_PTS(String overall_league_PTS) {
this.overall_league_PTS = overall_league_PTS;
}

@JsonProperty("home_league_position")
public String getHome_league_position() {
return home_league_position;
}

@JsonProperty("home_league_position")
public void setHome_league_position(String home_league_position) {
this.home_league_position = home_league_position;
}

@JsonProperty("home_league_payed")
public String getHome_league_payed() {
return home_league_payed;
}

@JsonProperty("home_league_payed")
public void setHome_league_payed(String home_league_payed) {
this.home_league_payed = home_league_payed;
}

@JsonProperty("home_league_W")
public String getHome_league_W() {
return home_league_W;
}

@JsonProperty("home_league_W")
public void setHome_league_W(String home_league_W) {
this.home_league_W = home_league_W;
}

@JsonProperty("home_league_D")
public String getHome_league_D() {
return home_league_D;
}

@JsonProperty("home_league_D")
public void setHome_league_D(String home_league_D) {
this.home_league_D = home_league_D;
}

@JsonProperty("home_league_L")
public String getHome_league_L() {
return home_league_L;
}

@JsonProperty("home_league_L")
public void setHome_league_L(String home_league_L) {
this.home_league_L = home_league_L;
}

@JsonProperty("home_league_GF")
public String getHome_league_GF() {
return home_league_GF;
}

@JsonProperty("home_league_GF")
public void setHome_league_GF(String home_league_GF) {
this.home_league_GF = home_league_GF;
}

@JsonProperty("home_league_GA")
public String getHome_league_GA() {
return home_league_GA;
}

@JsonProperty("home_league_GA")
public void setHome_league_GA(String home_league_GA) {
this.home_league_GA = home_league_GA;
}

@JsonProperty("home_league_PTS")
public String getHome_league_PTS() {
return home_league_PTS;
}

@JsonProperty("home_league_PTS")
public void setHome_league_PTS(String home_league_PTS) {
this.home_league_PTS = home_league_PTS;
}

@JsonProperty("away_league_position")
public String getAway_league_position() {
return away_league_position;
}

@JsonProperty("away_league_position")
public void setAway_league_position(String away_league_position) {
this.away_league_position = away_league_position;
}

@JsonProperty("away_league_payed")
public String getAway_league_payed() {
return away_league_payed;
}

@JsonProperty("away_league_payed")
public void setAway_league_payed(String away_league_payed) {
this.away_league_payed = away_league_payed;
}

@JsonProperty("away_league_W")
public String getAway_league_W() {
return away_league_W;
}

@JsonProperty("away_league_W")
public void setAway_league_W(String away_league_W) {
this.away_league_W = away_league_W;
}

@JsonProperty("away_league_D")
public String getAway_league_D() {
return away_league_D;
}

@JsonProperty("away_league_D")
public void setAway_league_D(String away_league_D) {
this.away_league_D = away_league_D;
}

@JsonProperty("away_league_L")
public String getAway_league_L() {
return away_league_L;
}

@JsonProperty("away_league_L")
public void setAway_league_L(String away_league_L) {
this.away_league_L = away_league_L;
}

@JsonProperty("away_league_GF")
public String getAway_league_GF() {
return away_league_GF;
}

@JsonProperty("away_league_GF")
public void setAway_league_GF(String away_league_GF) {
this.away_league_GF = away_league_GF;
}

@JsonProperty("away_league_GA")
public String getAway_league_GA() {
return away_league_GA;
}

@JsonProperty("away_league_GA")
public void setAway_league_GA(String away_league_GA) {
this.away_league_GA = away_league_GA;
}

@JsonProperty("away_league_PTS")
public String getAway_league_PTS() {
return away_league_PTS;
}

@JsonProperty("away_league_PTS")
public void setAway_league_PTS(String away_league_PTS) {
this.away_league_PTS = away_league_PTS;
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