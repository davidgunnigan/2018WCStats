package com.wc2018stats;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Match {

    private String venue;
    private String location;
    private String status;
    private String time;
    private String stageName;
    private MatchTeam homeTeam;
    private MatchTeam awayTeam;
    private String homeTeamCountry;
    private String awayTeamCountry;
    private List<TeamEvent> homeTeamEvents;
    private List<TeamEvent> awayTeamEvents;
    private List<String> officials;
    private Weather weather;
    private TeamMatchStatistics homeTeamStatistics;
    private TeamMatchStatistics awayTeamStatistics;
    private String fifaId;
    private String attendance;

    public String getVenue() {
        return venue;
    }

    public String getLocation() {
        return location;
    }

    public MatchTeam getHomeTeam() {
        return homeTeam;
    }

    public MatchTeam getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeamCountry() {
        return homeTeamCountry;
    }

    public String getAwayTeamCountry() {
        return awayTeamCountry;
    }

    public List<TeamEvent> getHomeTeamEvents() {
        return homeTeamEvents;
    }

    public List<TeamEvent> getAwayTeamEvents() {
        return awayTeamEvents;
    }

    public TeamMatchStatistics getHomeTeamStatistics() {
        return homeTeamStatistics;
    }

    public TeamMatchStatistics getAwayTeamStatistics() {
        return awayTeamStatistics;
    }

    public String getFifaId() {
        return fifaId;
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

    public String getStageName() {
        return stageName;
    }

    public Weather getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Match{" +
                "fifaId=" + fifaId +
                ", attendance=" + attendance +
                ", venue='" + venue + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", officials=" + officials +
                ", stageName='" + stageName + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeTeamEvents=" + homeTeamEvents +
                ", awayTeamEvents=" + awayTeamEvents +
                ", weather=" + weather +
                ", homeTeamStatistics=" + homeTeamStatistics +
                ", awayTeamStatistics=" + awayTeamStatistics +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fifaId);
    }
}
