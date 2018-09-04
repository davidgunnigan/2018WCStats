package com.wc2018stats;

import java.util.ArrayList;
import java.util.List;

public class PartitionToList1  {

    private static final String KAZAN = "Kazan";




    public static List<Match> filterByVenueKazan(List<Match> matches) {
        List<Match> filteredList = new ArrayList<>();

        for (Match match : matches) {
            if (KAZAN.equalsIgnoreCase(match.getVenue())) {
                filteredList.add(match);
            }
        } return filteredList;
    }

//    public static List<Team> teamList (List<Match> matches) {
//        List<Team> awayTeamList = new ArrayList<>();
//        for (Match match : matches) {
//           Team away = match.getAwayTeam();
//           awayTeamList.add(away);
//        }
//        return awayTeamList;
//    }
//
//    public static void main(String[] args) throws IOException {
//        DataRetriever dataRetriever = new DataRetriever();
//        String matches = dataRetriever.getAllMatches();
//        List<Match>matchesInKazan = dataRetriever.parseMatches(matches);
//        //filterByVenueKazan(matchesInKazan);
//        System.out.println(filterByVenueKazan(matchesInKazan));
//    }
}
