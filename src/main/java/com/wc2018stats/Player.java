package com.wc2018stats;

import java.util.Objects;

public class Player {
    private String name;
    private boolean captain;
    private String shirt_number;
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

    public String getShirt_number() {
        return shirt_number;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, shirt_number);
    }

    @Override
    public String toString() {

        return shirt_number + "    " +name + '\'' +
              //  ", captain=" + captain +

                "   " + position + '\n'
                ;
    }
}
