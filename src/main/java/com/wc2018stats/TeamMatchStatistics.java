package com.wc2018stats;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class TeamMatchStatistics {

    private Object country;
    private int attemptsOnGoal, onTarget, offTarget, blocked, woodwork, corners, offsides, ballPossession;
    private int passAccuaracy, numPasses, passesCompleted, distanceCovered, ballsRecovered, tackles, clearances;
    private int yellowCards, red_cards, foulsCommited;
    private Object tactics;
    private List<Player> startingEleven;

    public TeamMatchStatistics(String country, int attemptsOnGoal, int onTarget, int offTarget, int blocked,
                               int woodwork, int corners, int offsides, int ballPossession, int passAccuaracy,
                               int numPasses, int passesCompleted, int distanceCovered, int ballsRecovered,
                               int tackles, int clearances, int yellowCards, int red_cards, int foulsCommited,
                               Object tactics, List<Player> startingEleven) {
        this.country = country;
        this.attemptsOnGoal = attemptsOnGoal;
        this.onTarget = onTarget;
        this.offTarget = offTarget;
        this.blocked = blocked;
        this.woodwork = woodwork;
        this.corners = corners;
        this.offsides = offsides;
        this.ballPossession = ballPossession;
        this.passAccuaracy = passAccuaracy;
        this.numPasses = numPasses;
        this.passesCompleted = passesCompleted;
        this.distanceCovered = distanceCovered;
        this.ballsRecovered = ballsRecovered;
        this.tackles = tackles;
        this.clearances = clearances;
        this.yellowCards = yellowCards;
        this.red_cards = red_cards;
        this.foulsCommited = foulsCommited;
        this.tactics = tactics;
        this.startingEleven = startingEleven;
    }

    public Object getCountry() {
        return country;
    }

    public int getAttemptsOnGoal() {
        return attemptsOnGoal;
    }

    public int getOnTarget() {
        return onTarget;
    }

    public int getOffTarget() {
        return offTarget;
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

    public int getBallPossession() {
        return ballPossession;
    }

    public int getPassAccuaracy() {
        return passAccuaracy;
    }

    public int getNumPasses() {
        return numPasses;
    }

    public int getPassesCompleted() {
        return passesCompleted;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public int getBallsRecovered() {
        return ballsRecovered;
    }

    public int getTackles() {
        return tackles;
    }

    public int getClearances() {
        return clearances;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRed_cards() {
        return red_cards;
    }

    public int getFoulsCommited() {
        return foulsCommited;
    }

    public Object getTactics() {
        return tactics;
    }

    public List<Player> getStartingEleven() {
        return startingEleven;
    }
}
