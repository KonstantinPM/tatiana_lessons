package ourGame.dto;

public enum Hand {
    Rock("Rock"),
    Paper("Paper"),
    Scissors("Scissors");

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
