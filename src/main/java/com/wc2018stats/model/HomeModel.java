package com.wc2018stats.model;

import com.wc2018stats.MatchTeam;

import java.util.Objects;

public class HomeModel {
    private String code;
    private String flagUnicode;

    public String getCode() {
        return code;
    }

    public String getFlagUnicode() {
        return flagUnicode;
    }

    public void setFlagUnicode(String flagUnicode) {
        this.flagUnicode = flagUnicode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return  code + " - " + flagUnicode;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof HomeModel) {
            HomeModel otherTeam = (HomeModel) other;
            return this.code.equals(otherTeam.getCode());
        } else {
            return false;
        }
    }
}
