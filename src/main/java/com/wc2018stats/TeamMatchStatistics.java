package com.wc2018stats;

import java.util.List;

public class TeamMatchStatistics {

    private Object country;
    private int attempts_on_goal, on_target, off_target, blocked, woodwork, corners, offsides, ball_possession;
    private int pass_accuaracy, num_passes, passes_completed, distance_covered, balls_recovered, tackles, clearances;
    private int yellow_cards, red_cards, fouls_commited;
    private Object tactics;
    private List<Player> starting_eleven;

    public TeamMatchStatistics(String country, int attempts_on_goal, int on_target, int off_target, int blocked,
                               int woodwork, int corners, int offsides, int ball_possession, int pass_accuaracy,
                               int num_passes, int passes_completed, int distance_covered, int balls_recovered,
                               int tackles, int clearances, int yellow_cards, int red_cards, int fouls_commited,
                               Object tactics, List<Player> starting_eleven) {
        this.country = country;
        this.attempts_on_goal = attempts_on_goal;
        this.on_target = on_target;
        this.off_target = off_target;
        this.blocked = blocked;
        this.woodwork = woodwork;
        this.corners = corners;
        this.offsides = offsides;
        this.ball_possession = ball_possession;
        this.pass_accuaracy = pass_accuaracy;
        this.num_passes = num_passes;
        this.passes_completed = passes_completed;
        this.distance_covered = distance_covered;
        this.balls_recovered = balls_recovered;
        this.tackles = tackles;
        this.clearances = clearances;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.fouls_commited = fouls_commited;
        this.tactics = tactics;
        this.starting_eleven = starting_eleven;
    }

    public Object getCountry() {
        return country;
    }

    public int getAttempts_on_goal() {
        return attempts_on_goal;
    }

    public int getOn_target() {
        return on_target;
    }

    public int getOff_target() {
        return off_target;
    }

    public int getBlocked() {
        return blocked;
    }

    public int getWoodwork() {
        return woodwork;
    }

    public int getCorners() {
        return corners;
    }

    public int getOffsides() {
        return offsides;
    }

    public int getBall_possession() {
        return ball_possession;
    }

    public int getPass_accuaracy() {
        return pass_accuaracy;
    }

    public int getNum_passes() {
        return num_passes;
    }

    public int getPasses_completed() {
        return passes_completed;
    }

    public int getDistance_covered() {
        return distance_covered;
    }

    public int getBalls_recovered() {
        return balls_recovered;
    }

    public int getTackles() {
        return tackles;
    }

    public int getClearances() {
        return clearances;
    }

    public int getYellow_cards() {
        return yellow_cards;
    }

    public int getRed_cards() {
        return red_cards;
    }

    public int getFouls_commited() {
        return fouls_commited;
    }

    public Object getTactics() {
        return tactics;
    }

    public List<Player> getStarting_eleven() {
        return starting_eleven;
    }
}
