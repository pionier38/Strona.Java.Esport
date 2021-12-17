package pl.edu.zse.gry.dao;

import pl.edu.zse.gry.model.Game;

import java.util.List;

public interface IGameDAO {
    List<Game> getAllConsoles();
    List<Game> getGamesByConsole(Game.Console console);
    void persistGame(Game game);
}
