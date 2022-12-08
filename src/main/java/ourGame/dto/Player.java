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


    public Object setHand() {
        System.out.print("What do you choose: rock, scissors or paper? Or if you don't to play more, write Exit ");
        Scanner sc = new Scanner(System.in);
        String playerInput = sc.nextLine();
        playerInput = playerInput.toUpperCase();
        char firstLetter = playerInput.charAt(0);
        if (firstLetter == 'R' || firstLetter == 'S' || firstLetter == 'P' || firstLetter == 'E') {
            switch (firstLetter) {
                case 'R':
                    return "Rock";
                case 'S':
                    return "Scissors";
                case 'P':
                    return "Paper";
                case 'E':
                    System.exit(0);
            }
        }
        return setHand();
    }

}
