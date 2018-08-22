package com.wc2018stats;

import java.util.Map;

public class TeamFlagProvider {

    private Map<String, String> teamFlags;

    public TeamFlagProvider(Map<String, String> teamFlags) {
        this.teamFlags = teamFlags;
    }

    public String getFlagForTeam(String teamFifaCode) {
        return teamFlags.get(teamFifaCode);
    }
}
