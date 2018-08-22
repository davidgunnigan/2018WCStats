package com.wc2018stats;

import java.util.List;
import java.util.Objects;

public class Match {

    private String venue;
    private String location;
    private String status;
    private String time;
    private List<String> officials;
    private String stage_name;
    private MatchTeam home_team;
    private MatchTeam away_team;
    private String home_team_country;
    private String away_team_country;
    private List<TeamEvent> home_team_events;
    private List<TeamEvent> away_team_events;
    private Weather weather;
    private TeamMatchStatistics home_team_statistics;
    private TeamMatchStatistics away_team_statistics;
    private String fifa_id;
    private String attendance;

    public String getVenue() {
        return venue;
    }

    public String getLocation() {
        return location;
    }


    public MatchTeam getHome_team() {
        return home_team;
    }

    public MatchTeam getAway_team() {
        return away_team;
    }

    public String getHome_team_country() {
        return home_team_country;
    }

    public String getAway_team_country() {
        return away_team_country;
    }

    public List<TeamEvent> getHome_team_events() {
        return home_team_events;
    }

    public List<TeamEvent> getAway_team_events() {
        return away_team_events;
    }

    public TeamMatchStatistics getHome_team_statistics() {
        return home_team_statistics;
    }

    public TeamMatchStatistics getAway_team_statistics() {
        return away_team_statistics;
    }

    public String getFifa_id() {
        return fifa_id;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public List<String> getOfficials() {
        return officials;
    }

    public String getStage_name() {
        return stage_name;
    }

    public Weather getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Match{" +
                "fifa_id=" + fifa_id +
                ", attendance=" + attendance +
                ", venue='" + venue + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", officials=" + officials +
                ", stage_name='" + stage_name + '\'' +
                ", home_team='" + home_team + '\'' +
                ", away_team='" + away_team + '\'' +
                ", home_team_events=" + home_team_events +
                ", away_team_events=" + away_team_events +
                ", weather=" + weather +
                ", home_team_statistics=" + home_team_statistics +
                ", away_team_statistics=" + away_team_statistics +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fifa_id);
    }
}
