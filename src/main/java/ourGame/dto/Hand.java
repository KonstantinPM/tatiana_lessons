package ourGame.dto;

import static ourGame.RunGame.resourceBundle;

public enum Hand {
    Rock(resourceBundle.getString("Rock")),
    Paper(resourceBundle.getString("Paper")),
    Scissors(resourceBundle.getString("Scissors"));

    private final String name;


    public String getName() {
        return name;
    }

    Hand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
