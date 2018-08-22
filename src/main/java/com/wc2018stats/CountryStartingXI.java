package com.wc2018stats;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryStartingXI {


    public Map<Match,  List<Player>> allStartingXIs(String teamFifaCode) throws IOException {
        Map<Match, List<Player>> allStartingXIsMap = new HashMap<>();
        List<Match> matches = new DataRetriever().getAllMatchesList();
        for (Match match : matches) {
            if (teamFifaCode.equalsIgnoreCase(match.getHome_team().getCode())){
                allStartingXIsMap.put(match, match.getHome_team_statistics().getStarting_eleven());

            } else if (teamFifaCode.equalsIgnoreCase(match.getAway_team().getCode())) {
                allStartingXIsMap.put(match, match.getAway_team_statistics().getStarting_eleven());
            }
        }
        return allStartingXIsMap;
    }
/*

    public static void main(String[] args) throws IOException {
        CountryStartingXI countryStartingXI = new CountryStartingXI();
        Map<Match, List<Player>> allXIsInStages = countryStartingXI.allStartingXIs("BEL");
       // System.out.println(allXIsInStages);
        for (Match match : allXIsInStages.keySet()) {
            List<Player> startingXI = allXIsInStages.get(match);
            System.out.println(match.getStage_name() + " - " + match.getHome_team() + " v " + match.getAway_team());
            System.out.println(startingXI);
            System.out.println("--------------------------------------");
        }
       // Map<String, Map<String, List<Player>>> allXIsInWC = countryStartingXI.allXIs(allXIsInStages);

    }*/
}
