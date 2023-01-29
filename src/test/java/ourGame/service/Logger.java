package ourGame.service;

import org.junit.platform.commons.logging.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static ourGame.RunGame.c1;
import static ourGame.RunGame.pl1;
import static ourGame.service.GameImpl.handOfComputer;
import static ourGame.service.GameImpl.rez;

public class Logger {


    public static void logger () {

        Game game = new GameImpl();
        Path path = Path.of(System.getProperty("user.dir"));
        File file = new File(path.toAbsolutePath().toFile(), "resultOfGame.txt");
        System.out.println("Result of game saved in " + file.getAbsolutePath());
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\n" + "Number of all games - " + pl1.getNumberOfGames() + "\nNumber of lose games - " + pl1.getNumberOfLoseGames() + "\nNumber of win games - " + pl1.getPlayerScore() + "\nPlayer chose - " + pl1.getHand() + "\nComputer chose - " + handOfComputer + "\nResult of this game - " + rez);
            fileWriter.write("\n-------------");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
