package polskie.grupy.esportowe.structur.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import polskie.grupy.esportowe.structur.services.IAuthenticationService;
import polskie.grupy.esportowe.structur.session.SessionObject;


import javax.annotation.Resource;

@Controller
public class AuthController {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        this.authenticationService.authenticate(login, password);

        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String login,
                           @RequestParam String password,
                           @RequestParam String password2) {
        if(password.equals(password2)) {
            this.authenticationService.register(login, password);
            return "redirect:/main";
        } else {
            return "redirect:/register";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setUser(null);
        return "redirect:/main";
    }
}
