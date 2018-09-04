package com.wc2018stats;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class TeamEvent {
    public int id;
    public String typeOfEvent;
    public String player;
    public String time;


    public int getId() {
        return id;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public String getPlayer() {
        return player;
    }

    public String getTime() {
        return time;
    }
}
