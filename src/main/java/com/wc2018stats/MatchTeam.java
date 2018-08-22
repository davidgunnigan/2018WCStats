package com.wc2018stats;

import java.util.List;
import java.util.Objects;

public class MatchTeam {
    private String country;
    private String code;
    private String flagUnicode;
    private int goals;
    private int penalties;

    public void setFlagUnicode(String flagUnicode) {
        this.flagUnicode = flagUnicode;
    }

    public String getFlagUnicode() {
        return flagUnicode;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getGoals() {
        return goals;
    }

    public int getPenalties() {
        return penalties;
    }


    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code + " - " + flagUnicode;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MatchTeam) {
            MatchTeam otherTeam = (MatchTeam) other;
            return this.code.equals(otherTeam.getCode());
        } else {
                return false;
        }
    }
}