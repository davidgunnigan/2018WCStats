package com.wc2018stats;

import java.io.IOException;
import java.util.*;

public class Teams {
    public Set<MatchTeam> allTeams() throws IOException {
        DataRetriever dataRetriever = new DataRetriever();
        TeamFlagProvider teamFlagProvider = dataRetriever.getFlagProvider();
        String matchesJson = dataRetriever.getAllMatches();

        List<Match> matches = dataRetriever.parseMatches(matchesJson);
        Set<MatchTeam> allTeamsInWorldCup = new HashSet<>();
        for (Match match : matches) {
            MatchTeam homeTeam = match.getHomeTeam();
            homeTeam.setFlagUnicode(teamFlagProvider.getFlagForTeam(homeTeam.getCode()));
            allTeamsInWorldCup.add(homeTeam);

            MatchTeam awayTeam = match.getAwayTeam();
            awayTeam.setFlagUnicode(teamFlagProvider.getFlagForTeam(awayTeam.getCode()));
            allTeamsInWorldCup.add(awayTeam);

        }
        return allTeamsInWorldCup;
    }

    public List<Team> getAllTeams() throws IOException {
        DataRetriever dataRetriever = new DataRetriever();
        String teamsJson = dataRetriever.getTeams();
        List<Team> teams = dataRetriever.parseTeams(teamsJson);

        TeamFlagProvider teamFlagProvider = dataRetriever.getFlagProvider();
        for (Team t : teams) {
            t.setFlagUnicode(teamFlagProvider.getFlagForTeam(t.getFifaCode()));
        }

        return teams;
    }

    public Map<String, List<Team>> getTeamsByGroup() throws IOException {
        List<Team> teams = getAllTeams();
        Map<String, List<Team>> perGroupTeams = new HashMap<>();
        for (Team t : teams) {
            perGroupTeams.computeIfAbsent(t.getGroupLetter(), k -> new ArrayList<>()).add(t);
        }
        return perGroupTeams;
    }

    public static void main(String[] args) throws IOException {
        Teams teams = new Teams();
        System.out.println(teams.getTeamsByGroup());
    }
}
