package ourGame.service;

import ourGame.dto.Computer;
import ourGame.dto.Player;

public interface Game {

    Results startGame(Player player, Computer computer);

    void showWinner(Player player, Computer computer);
}
