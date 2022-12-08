package ourGame.dto;

import java.util.Random;

public class Computer {

    private String hand;

    public void setHand(String hand) {
        this.hand = hand;
    }

    private int computerScore = 0;

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public Hand getHand() {
        Hand[] moves = Hand.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];

    }
}
