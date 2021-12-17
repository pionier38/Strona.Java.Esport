package polskie.grupy.esportowe.structur.services;


import polskie.grupy.esportowe.structur.model.Game;

import java.util.List;

public interface IGameService {
    List<Game.Console> getConsoleList();
    List<Game> getGamesByConsole(Game.Console console);
    void persistGame(Game game);
}
