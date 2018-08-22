package com.wc2018stats.controller;

import com.wc2018stats.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ScoringStatsController {
    @RequestMapping(value = "/goalstats", method = RequestMethod.GET)
    public String teamstats(ModelMap modelMap) throws IOException {

        DataRetriever dataRetriever = new DataRetriever();
        String teams = dataRetriever.getTeams();
        List<Team> teamList = dataRetriever.parseTeams(teams);
        TeamScoringStats teamScoringStats = new TeamScoringStats();
        ScoringStats scoringStats = new ScoringStats();

        List<String> allGoals = scoringStats.allScorers();
        Map<String, Integer> allGoalsByPlayer = scoringStats.getScoresPerPlayer(allGoals);
        Map<Integer, List<String>> getTopScorers = scoringStats.calculateTopScorers(allGoalsByPlayer);
        modelMap.addAttribute("getTopScorers", getTopScorers);

        Map<String, Integer> goalsScoredPerTeam = teamScoringStats.getGoalsScoredMap(teamList);
        Map<Integer, List<String>> topScoringTeams = teamScoringStats.goalStatsPerTeam(goalsScoredPerTeam);
        modelMap.addAttribute("topScoringTeams", topScoringTeams);

        Map<String, Integer> goalsConcededPerTeam = teamScoringStats.getGoalsCondededMap(teamList);
        Map<Integer, List<String>> topConcedingTeams = teamScoringStats.goalStatsPerTeam(goalsConcededPerTeam);
        modelMap.addAttribute("topConcedingTeams", topConcedingTeams);

        System.out.println(getTopScorers + "\n ******************************* \n");
        System.out.println("\n ******************************* \n");
        System.out.println(topScoringTeams);
        System.out.println("\n ******************************* \n");
        System.out.println(topConcedingTeams);
        System.out.println("\n ******************************* \n");


        return "goalstats";
    }

}
