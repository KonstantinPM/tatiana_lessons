package ourGame;

import ourGame.dto.Computer;
import ourGame.dto.Player;
import ourGame.service.Game;
import ourGame.service.GameImpl;

import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {
        String continueGame = "Y";
        int numberOfGames;
        Player pl1 = new Player();
        Computer c1 = new Computer();
        Game game = new GameImpl();

        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        pl1.setName(sc.nextLine());
        System.out.println("Enter number of games");
        numberOfGames = sc.nextInt();

       while (!continueGame.equalsIgnoreCase("N")) {

            if (numberOfGames > 0) {
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
}
