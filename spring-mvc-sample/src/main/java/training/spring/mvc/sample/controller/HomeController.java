package training.spring.mvc.sample.controller;

import training.spring.mvc.sample.model.Person;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Patrick Tan
 */
@Controller
@RequestMapping("/sample/*")
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @RequestMapping("index.htm")
    public String index(ModelMap model, @RequestParam(value = "id", required = false) Integer id) {
        model.addAttribute("myName", "Patrick");
        model.addAttribute("personBea", new Person("Patrick", 12));

        LOGGER.info(" ...id: " + id);

        return "index";
    }

    @RequestMapping("home.htm")
    public String home() {
        return "home";
    }
}
