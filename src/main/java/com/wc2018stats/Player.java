package com.wc2018stats;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Player {
    private String name;
    private boolean captain;
    private String shirtNumber;
    private String position;

    public boolean isCaptain() {
        return captain;
    }

    public String getName() {
        if (!isCaptain()) {
            return name;
        } else {
            return name+ " (c)";
        }
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, shirtNumber);
    }

    @Override
    public String toString() {

        return shirtNumber + " - " + name + " - " +
              //  ", captain=" + captain +

                "   " + position + '\n'
                ;
    }
}
