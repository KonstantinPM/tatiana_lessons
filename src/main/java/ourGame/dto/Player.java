package ourGame.dto;

import java.util.Scanner;

public class Player {

    private String hand;

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    private String name;

    public String getName() {
        return name;
    }

    private int playerScore = 0;
    private int numberOfGames = 0;

    private int numberOfLoseGames = 0;

    public void setNumberOfLoseGames(int numberOfLoseGames) {
        this.numberOfLoseGames = numberOfLoseGames;
    }


    public int getNumberOfLoseGames() {
        return numberOfLoseGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setName(String name) {
        this.name = name;
    }


}
