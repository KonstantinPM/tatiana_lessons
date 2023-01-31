package ourGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ourGame.dto.Computer;
import ourGame.dto.Player;
import ourGame.service.Game;
import ourGame.service.GameImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.nio.charset.Charset;

public class RunGame {
    public static final Logger logger = LoggerFactory.getLogger("logger".getClass());
    public static Player pl1 = new Player();
    public static Computer c1 = new Computer();
    public static ResourceBundle resourceBundle;

    public static void main(String[] args) throws IOException {
        Locale defLocale = Locale.getDefault();
        if (args.length != 0) {
            defLocale = new Locale(args[0]);
        }
        resourceBundle = ResourceBundle.getBundle("Message", defLocale);

        String continueGame = "Y";
        int numberOfGames;
        Game game = new GameImpl();

        logger.info(resourceBundle.getString("enter_name"));
        //System.out.println((resourceBundle.getString("enter_name")));
        Scanner sc = new Scanner(System.in);
        pl1.setName(sc.nextLine());
        logger.info(resourceBundle.getString("enter_numberOfGames"));
        numberOfGames = sc.nextInt();

        while ((!continueGame.equalsIgnoreCase(resourceBundle.getString("N")))) {

            if (numberOfGames > 0) {
                pl1.setHand(playerHand());
                game.startGame(pl1, c1);
                logger.info(resourceBundle.getString("enter_you_have") + (--numberOfGames));
                //System.out.print(--numberOfGames);
                System.out.println();
            } else {
                logger.info(resourceBundle.getString("you_played") + pl1.getNumberOfGames());
                //System.out.println(pl1.getNumberOfGames());
                logger.info(resourceBundle.getString("lost_games") + pl1.getNumberOfLoseGames());
                //System.out.println(pl1.getNumberOfLoseGames());
                logger.info(resourceBundle.getString("win_games") + pl1.getPlayerScore());
                //System.out.println(pl1.getPlayerScore());
                System.out.println();
                logger.info(resourceBundle.getString("games_overed"));
                continueGame = sc.next();

                if (continueGame.equalsIgnoreCase("y") || continueGame.equalsIgnoreCase("д")) {
                    logger.info(resourceBundle.getString("enter_numberOfGames"));
                    numberOfGames = sc.nextInt();
                }
            }
        }


    }

    public static String playerHand() {
        logger.info(resourceBundle.getString("choose"));
        Scanner sc = new Scanner(System.in);
        String playerInput = sc.nextLine();
        playerInput = playerInput.toUpperCase();
        char firstLetter = playerInput.charAt(0);
        if (firstLetter == 'R' || firstLetter == 'S' || firstLetter == 'P' || firstLetter == 'E' ||
                firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б' || firstLetter == 'В') {
            switch (firstLetter) {
                case 'R':
                case 'К':
                    return resourceBundle.getString("Rock");
                case 'S':
                case 'Н':
                    return resourceBundle.getString("Scissors");
                case 'P':
                case 'Б':
                    return resourceBundle.getString("Paper");
                case 'E':
                case 'В':
                    System.exit(0);
            }
        }
        return playerHand();
    }
}
