package polskie.grupy.esportowe.structur.dao;

import polskie.grupy.esportowe.structur.model.Game;

import java.util.List;

public interface IGameDAO {
    List<Game> getAllConsoles();
    List<Game> getGamesByConsole(Game.Console console);
    void persistGame(Game game);
}
