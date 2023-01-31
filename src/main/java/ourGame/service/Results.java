package ourGame.service;

import static ourGame.RunGame.resourceBundle;

public enum Results {
    DRAW (resourceBundle.getString("draw")),
    WIN (resourceBundle.getString("win")),
    LOSE (resourceBundle.getString("lose"));

    private String name;

    Results(String name) {
        this.name = name;
    }
}
