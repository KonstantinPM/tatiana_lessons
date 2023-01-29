package ourGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ourGame.dto.Computer;
import ourGame.dto.Player;
import ourGame.service.Game;
import ourGame.service.GameImpl;

import java.io.IOException;
import java.util.Scanner;

public class RunGame {
    public static final Logger logger = LoggerFactory.getLogger("logger".getClass());
    public static Player pl1 = new Player();
    public static Computer c1 = new Computer();
    public static void main(String[] args) throws IOException {
        String continueGame = "Y";
        int numberOfGames;
        Game game = new GameImpl();

        System.out.println("Enter your name");
        logger.info("Enter your name");
        Scanner sc = new Scanner(System.in);
        pl1.setName(sc.nextLine());
        System.out.println("Enter number of games");
        logger.info("Enter number of games");
        numberOfGames = sc.nextInt();

       while (!continueGame.equalsIgnoreCase("N")) {

            if (numberOfGames > 0) {
                pl1.setHand(playerHand());
                game.startGame(pl1, c1);
                System.out.println("You have " + --numberOfGames + " games left to play");
                System.out.println();
            } else {
                System.out.println("You played " + pl1.getNumberOfGames() + " games.");
                System.out.println("You lost: " + pl1.getNumberOfLoseGames() + " games");
                System.out.println("You won: " + pl1.getPlayerScore() + " games");
                System.out.println();
                System.err.println("Your games overed. Do you want to continue?[Y/N]");
                continueGame = sc.next();

                if (continueGame.equalsIgnoreCase("y")) {
                    System.out.println("Enter number of games");
                    numberOfGames = sc.nextInt();
                }
            }
        }


    }

    public static String playerHand() {
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
        return playerHand();
    }
}
