package ourGame.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ourGame.dto.Computer;
import ourGame.dto.Hand;
import ourGame.dto.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void playerShouldWin() {
        Player pl1 = new Player();
        pl1.setHand("Rock");
        pl1.setName("Tanya");
        Computer c1 = Mockito.mock(Computer.class);
        Mockito.when(c1.getHand()).thenReturn(Hand.Paper);

        new GameImpl().startGame(pl1, c1);

        assertEquals(pl1.getPlayerScore(), 1);
        assertEquals(pl1.getNumberOfLoseGames(), 0);
    }

    @Test
    void computerShouldWin() {
        Player pl1 = new Player();
        pl1.setHand("Paper");
        pl1.setName("Tanya");
        Computer c1 = Mockito.mock(Computer.class);
        Mockito.when(c1.getHand()).thenReturn(Hand.Rock);

        new GameImpl().startGame(pl1, c1);

        assertEquals(pl1.getPlayerScore(), 0);
        assertEquals(pl1.getNumberOfLoseGames(), 1);
        Mockito.verify(c1).setComputerScore(1);
    }
}