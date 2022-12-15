package ourGame.service;

import ourGame.dto.Computer;
import ourGame.dto.Player;

public class GameImpl implements Game {

    public void showWinner(Player player, Computer computer) {
        int pScore = player.getPlayerScore();
        int cScore = computer.getComputerScore();
        System.out.println("Scores after games");
        System.out.println("Player score " + pScore);
        System.out.println("Computer score " + cScore);
    }

    public void startGame(Player player, Computer computer) {
        String handOfComputer = String.valueOf(computer.getHand());
        System.out.println("Player choose: " + player.getHand());
        System.out.println("Computer choose: " + handOfComputer);
        if (player.getHand().equals(handOfComputer)) {
            System.out.println("Draw");
            showWinner(player, computer);
        }
        if ((player.getHand().equals("Rock") && handOfComputer.equals("Paper"))
                || (player.getHand().equals("Paper") && handOfComputer.equals("Scissors"))
                || (player.getHand().equals("Scissors") && handOfComputer.equals("Rock"))) {
            player.setPlayerScore(player.getPlayerScore() + 1);
            System.out.println("You've won");
            showWinner(player, computer);
        } else if ((player.getHand().equals("Paper")) && (handOfComputer.equals("Rock"))
                || (player.getHand().equals("Scissors")) && (handOfComputer.equals("Paper"))
                || (player.getHand().equals("Rock")) && (handOfComputer.equals("Scissors"))) {
            computer.setComputerScore(computer.getComputerScore()+1);
            player.setNumberOfLoseGames(player.getNumberOfLoseGames()+1);
            System.out.println("Computer has won");
            showWinner(player, computer);
        }
        player.setNumberOfGames(player.getNumberOfGames() + 1);

    }
}
