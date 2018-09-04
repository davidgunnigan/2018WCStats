package com.wc2018stats;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class Team {

    private int id;
    private int groupId;
    private String country;
    private String fifaCode;
    private String groupLetter;
    private String flagUnicode;
    private int wins;
    private int losses;
    private int draws;
    private int gamesPlayed;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifferential;
    private int penalties;
    private List<CountryStartingXI> countryStartingXIS;

    //{"id":17,"country":"Brazil","alternate_name":null,"fifa_code":"BRA","group_id":5,"group_letter":"E","wins":3,"draws":1,"losses":1,"games_played":5,"points":10,"goals_for":8,"goals_against":3,"goal_differential":5}



    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getCountry() {
        return country;
    }

    public String getFifaCode() {
        return fifaCode;
    }

    public String getGroupLetter() {
        return groupLetter;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getPenalties() {
        return penalties;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifferential() {
        return goalDifferential;
    }

    public List<CountryStartingXI> getCountryStartingXIS() { return countryStartingXIS; }

    public String getFlagUnicode() {
        return flagUnicode;
    }

    public void setFlagUnicode(String flagUnicode) {
        this.flagUnicode = flagUnicode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fifaCode);
    }

    @Override
    public String toString() {
        return country;
    }
}
