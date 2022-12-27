package ourGame.service;

public enum Results {
    DRAW ("draw"),
    WIN ("win"),
    LOSE ("lose");

    private String name;

    Results(String name) {
        this.name = name;
    }
}
