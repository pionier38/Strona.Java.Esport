package pl.edu.zse.gry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.zse.gry.dao.IGameDAO;
import pl.edu.zse.gry.model.Game;
import pl.edu.zse.gry.services.IGameService;
import pl.edu.zse.gry.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    IGameService gameService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String games(Model model) {
        model.addAttribute("consoles",
                this.gameService.getConsoleList());
        return "consoles";
    }

    @RequestMapping(value = "/{console}", method = RequestMethod.GET)
    public String listGames(@PathVariable Game.Console console, Model model) {
        List<Game> games = this.gameService.getGamesByConsole(console);
        model.addAttribute("games", games);
        return "games";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGame(Model model) {
        model.addAttribute("user", this.sessionObject.getUser());
        model.addAttribute("game", new Game());
        return "addGame";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGame(@ModelAttribute Game game) {
        this.gameService.persistGame(game);

        return "main";
    }
}
