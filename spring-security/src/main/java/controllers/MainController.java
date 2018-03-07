package controllers;

import model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView getGreetings() {
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }

    @RequestMapping("/welcome")
    public String m() {
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Person person) {
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }
}
