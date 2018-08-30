package com.wc2018stats.controller;

import com.wc2018stats.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

@Controller
@ComponentScan()
public class TeamController {

    @RequestMapping(value = "/team/{teamCode}", method = RequestMethod.GET)
    //   @ResponseBody
    public String showTeam(@PathVariable String teamCode, ModelMap modelMap) throws IOException {
        System.out.println("You are asking for Team  " + teamCode);

        DataRetriever dataRetriever = new DataRetriever();
        String teams = dataRetriever.getTeams();
        List<Team> allTeams = dataRetriever.parseTeams(teams);

        Team team = null;
        for (Team t : allTeams) {
            if (t.getFifaCode().equalsIgnoreCase(teamCode)) {
                team = t;
            }
        }

        modelMap.addAttribute("team", team);


        ScoringStats scoringStats = new ScoringStats();
        String teamGoals = team.getCountry();
        List<String> allGoalsByTeam = scoringStats.scorersFilterByTeam(teamGoals);
        Map<String, Integer> goalsPerPlayer = scoringStats.getScoresPerPlayer(allGoalsByTeam);
        Map<Integer, List<String>> topScorers = new TreeMap<>(Collections.reverseOrder());
        topScorers.putAll(scoringStats.calculateTopScorers(goalsPerPlayer));

        System.out.println(topScorers);
        if (topScorers != null) {
            modelMap.addAttribute("topScorers", topScorers);
        } else {
            modelMap.addAttribute("topScorers", new ScoringStats().allScorers());
        }

        CountryStartingXI countryStartingXI = new CountryStartingXI();
        Map<String, List<Player>> allStartingXIs = new TreeMap<>();
        Map<Match, List<Player>> allXIsInStages = countryStartingXI.allStartingXIs(teamCode);
        List<Match> matches = new DataRetriever().getAllMatchesList();
        for (Match match : allXIsInStages.keySet()) {
            List<Player> startingXI = allXIsInStages.get(match);
            String fixture = (match.getStage_name() + " - " + match.getHome_team_country() + " v " + match.getAway_team_country());
            allStartingXIs.put(fixture, startingXI);
        }

        modelMap.addAttribute("allStartingXIs", allStartingXIs);
        System.out.println(allStartingXIs);

        return "team";
    }
}