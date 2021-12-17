package polskie.grupy.esportowe.structur.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import polskie.grupy.esportowe.structur.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("user", this.sessionObject.getUser());
        return "main";
    }
}
