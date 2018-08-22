package com.wc2018stats;

import java.io.IOException;
import java.util.*;

public class TeamScoringStats {
    DataRetriever dataRetriever = new DataRetriever();
    public List<Team> teamsList() throws IOException {

        String teams = dataRetriever.getTeams();
        List<Team> allTeams = dataRetriever.parseTeams(teams);
        return allTeams;
    }

    public Map<String, Integer> getGoalsScoredMap(List<Team> allTeams) {
        Map<String, Integer> goalsPerTeam = new TreeMap<>();
        for (Team team : allTeams) {
            goalsPerTeam.put(team.getCountry(), team.getGoalsFor());
        }
        return goalsPerTeam;
    }

    public Map<String, Integer> getGoalsCondededMap(List<Team> allTeams) {
        Map<String, Integer> goalsConcededPerTeam = new TreeMap(Collections.reverseOrder());
        for (Team team : allTeams) {
            goalsConcededPerTeam.put(team.getCountry(), team.getGoalsAgainst());
        }
        return goalsConcededPerTeam;
    }

    public Map<String, Integer> getGoalDifferenceMap(List<Team> allTeams) {
        Map<String, Integer> goalsDifferencePerTeam = new TreeMap(Collections.reverseOrder());
        for (Team team : allTeams) {
            goalsDifferencePerTeam.put(team.getCountry(), team.getGoalDifferential() );
        }
        return goalsDifferencePerTeam;
    }

    public Map<Integer, List<String>> goalStatsPerTeam(Map<String, Integer> goalsPerTeam) {
        Map<Integer, List<String>> scoringTeamsMap = new TreeMap(Collections.reverseOrder());
        for (String team : goalsPerTeam.keySet()) {
            Integer goalCount = goalsPerTeam.get(team);
            scoringTeamsMap.computeIfAbsent(goalCount, k -> new ArrayList<>()).add(team);
        }
        return scoringTeamsMap;
    }

/*
    public static void main(String[] args) throws IOException {
        TeamScoringStats teamScoringStats = new TeamScoringStats();
        List<Team> teams = teamScoringStats.teamsList();
        Map<String, Integer> goalsPerTeam = teamScoringStats.getGoalsScoredMap(teams);
        Map<String, Integer> goalsConcededPerTeam = teamScoringStats.getGoalsCondededMap(teams);
        Map<String, Integer> goalsDifferencePerTeam = teamScoringStats.getGoalDifferenceMap(teams);
        Map<Integer, List<String>> topScoringTeamsMap = teamScoringStats.goalStatsPerTeam(goalsPerTeam);
        System.out.println(topScoringTeamsMap + "\n ******************************* \n");
        Map<Integer, List<String>> topConcedingTeamsMap = teamScoringStats.goalStatsPerTeam(goalsConcededPerTeam);
        System.out.println(topConcedingTeamsMap + "\n ******************************* \n");
        Map<Integer, List<String>> GoalDifferenceTeamsMap = teamScoringStats.goalStatsPerTeam(goalsDifferencePerTeam);
        System.out.println(GoalDifferenceTeamsMap);
    }*/
}
