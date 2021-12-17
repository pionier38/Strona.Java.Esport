package pl.edu.zse.gry.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.gry.dao.IGameDAO;
import pl.edu.zse.gry.model.Game;
import pl.edu.zse.gry.services.IGameService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService implements IGameService {

    @Autowired
    IGameDAO gameDAO;

    @Override
    public List<Game.Console> getConsoleList() {
        List<Game> games = this.gameDAO.getAllConsoles();
        List<Game.Console> consoles = new ArrayList<>();

        for(Game game : games) {
            consoles.add(game.getConsole());
        }

        return consoles;
    }

    @Override
    public List<Game> getGamesByConsole(Game.Console console) {
        return this.gameDAO.getGamesByConsole(console);
    }

    @Override
    public void persistGame(Game game) {
        this.gameDAO.persistGame(game);
    }
}
