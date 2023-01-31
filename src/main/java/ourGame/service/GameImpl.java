package ourGame.service;

import ourGame.dto.Computer;
import ourGame.dto.Player;

import static ourGame.RunGame.logger;
import static ourGame.RunGame.resourceBundle;

//import java.util.logging.Logger;


public class GameImpl implements Game {
    public static Results rez;
    public static String handOfComputer;

    public void showWinner(Player player, Computer computer) {
        int pScore = player.getPlayerScore();
        int cScore = computer.getComputerScore();
        logger.info(resourceBundle.getString("score"));
        logger.info(resourceBundle.getString("pl_score")+pScore);
        logger.info(resourceBundle.getString("c_score")+cScore);
    }

    public Results startGame(Player player, Computer computer) {
        handOfComputer = String.valueOf(computer.getHand());
        logger.info(resourceBundle.getString("pl_choose")+player.getHand());
        logger.info(resourceBundle.getString("c_choose" )+handOfComputer);
        if (player.getHand().equals(handOfComputer)) {
            System.out.println(resourceBundle.getString(String.valueOf(rez = Results.DRAW)));
            showWinner(player, computer);
        }
        if ((player.getHand().equals(resourceBundle.getString("Rock")) && handOfComputer.equals(resourceBundle.getString("Paper")))
                || (player.getHand().equals(resourceBundle.getString("Paper")) && handOfComputer.equals(resourceBundle.getString("Scissors")))
                || (player.getHand().equals(resourceBundle.getString("Scissors")) && handOfComputer.equals(resourceBundle.getString("Rock")))) {
            player.setPlayerScore(player.getPlayerScore() + 1);
            System.out.println(resourceBundle.getString(String.valueOf(rez = Results.LOSE)));
            showWinner(player, computer);
        } else if ((player.getHand().equals(resourceBundle.getString("Paper"))) && (handOfComputer.equals(resourceBundle.getString("Rock")))
                || (player.getHand().equals(resourceBundle.getString("Scissors"))) && (handOfComputer.equals(resourceBundle.getString("Paper")))
                || (player.getHand().equals(resourceBundle.getString("Rock"))) && (handOfComputer.equals(resourceBundle.getString("Scissors")))) {
            computer.setComputerScore(computer.getComputerScore()+1);
            player.setNumberOfLoseGames(player.getNumberOfLoseGames()+1);
            System.out.println(resourceBundle.getString(String.valueOf(rez = Results.WIN)));
            showWinner(player, computer);
        }
        player.setNumberOfGames(player.getNumberOfGames() + 1);
        //Logger.logger();
        return rez;
    }

}
