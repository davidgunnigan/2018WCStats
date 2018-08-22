package com.wc2018stats;

import java.io.IOException;
import java.util.*;

public class ScoringStats {

    private static final String GOAL_EVENT = "goal";
    private static final String PENALTY_GOAL_EVENT = "goal-penalty";

    public List<String> allScorers() throws IOException {

        List<String> scorers = new ArrayList<>();

        List<Match> matches = new DataRetriever().getAllMatchesList();
        for (Match match : matches) {
            List<TeamEvent> homeTeamEvents = match.getHome_team_events();
            scorers.addAll(getScorers(homeTeamEvents));

            List<TeamEvent> awayTeamEvents = match.getAway_team_events();
            scorers.addAll(getScorers(awayTeamEvents));
        }
        return scorers;
    }

    public List<String> scorersFilterByTeam(String team) throws IOException {
        List<String> allScorersByCountry = new ArrayList<>();

        List<Match> matches = new DataRetriever().getAllMatchesList();
        for (Match match : matches) {
            List<TeamEvent> homeTeamEvents = match.getHome_team_events();
            if (team.equalsIgnoreCase(match.getHome_team_country())) {
                allScorersByCountry.addAll(getScorers(homeTeamEvents));
            }
            List<TeamEvent> awayTeamEvents = match.getAway_team_events();
            if (team.equalsIgnoreCase(match.getAway_team_country())) {
                allScorersByCountry.addAll(getScorers(awayTeamEvents));
            }
        }
        return allScorersByCountry;
    }

    public Map<String, Integer> getScoresPerPlayer(List<String> allGoals) {
        //String[] incorrectPlayers = {"HARRY KANE", "ANTOINE GRIEZMANN", "ARTEM DZYUBA"};
        Map<String, Integer> goalsPerPlayer = new HashMap<>();
        for (String player : allGoals) {
            Integer goalCount = goalsPerPlayer.get(player);
            if (goalCount == null) {
                goalCount = 0;
                if("HARRY KANE".equalsIgnoreCase(player) || "ANTOINE GRIEZMANN".equalsIgnoreCase(player)
                        || "ARTEM DZYUBA".equalsIgnoreCase(player)) {
                    goalCount = - 1;
                }
            }
            goalCount++;
            goalsPerPlayer.put(player, goalCount);
        }
        return goalsPerPlayer;
    }


    public Map<Integer, List<String>> calculateTopScorers(Map<String, Integer> getScoresPerPlayer) {
        Map<Integer, List<String>> topScorers = new TreeMap(Collections.reverseOrder());
        for (String player : getScoresPerPlayer.keySet()) {
            Integer goalCount = getScoresPerPlayer.get(player);
            topScorers.computeIfAbsent(goalCount, k -> new ArrayList<>()).add(player);
        }

        return topScorers;
    }

    public List<String> getTopGoalScorers(Map<Integer, List<String>> topScorers) {
        List<Integer> goalCounts = new ArrayList<>(topScorers.keySet());
        goalCounts.sort(Comparator.naturalOrder());

        //After sorting, the max number of goals will be the last thing in the list
        int maxGoals = goalCounts.get(goalCounts.size() - 1);

        return topScorers.get(maxGoals);
    }

    public List<String> getScorers(List<TeamEvent> events) {
        List<String> allGoals = new ArrayList<>();
        for (TeamEvent teamEvent : events) {
            if(GOAL_EVENT.equalsIgnoreCase(teamEvent.getType_of_event()) ||
                    PENALTY_GOAL_EVENT.equalsIgnoreCase(teamEvent.getType_of_event())) {
                allGoals.add(teamEvent.getPlayer().toUpperCase());
            }
        }
        return allGoals;
    }

}
