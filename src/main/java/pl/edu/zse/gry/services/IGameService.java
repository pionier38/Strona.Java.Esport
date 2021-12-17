package pl.edu.zse.gry.services;

import pl.edu.zse.gry.model.Game;

import java.util.List;

public interface IGameService {
    List<Game.Console> getConsoleList();
    List<Game> getGamesByConsole(Game.Console console);
    void persistGame(Game game);
}
