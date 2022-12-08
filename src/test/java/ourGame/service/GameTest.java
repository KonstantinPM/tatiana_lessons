package ourGame.service;

import org.junit.jupiter.api.Test;
import ourGame.dto.Computer;
import ourGame.dto.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void startGame() {
        Player pl1 = new Player();
        Computer c1 = new Computer();
        Game game = new GameImpl();
        assertNotNull(pl1);
        assertNotNull(c1);
        assertNotNull(game);
        pl1.setName("Tanya");
        assertEquals(pl1.getName(),"Tanya");
        assertNotEquals(1, pl1.getNumberOfGames());
        assertNotEquals(1,c1.getComputerScore());
    }

    @Test
    void showWinner() {
        Player pl1 = new Player();
        Computer c1 = new Computer();
        assertEquals(0, pl1.getPlayerScore());
        assertEquals(0, c1.getComputerScore());
    }
}