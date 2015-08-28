package training.spring.mvc.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Patrick Tan
 */
@Controller
@RequestMapping("*")
public class MyController {

    @RequestMapping
    public String login() {
        return "login";
    }

    @RequestMapping("/admin/*")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/developer/*")
    public String developerPage() {
        return "developer";
    }

    @RequestMapping("/public/*")
    public String publicPage() {
        return "public";
    }

    @RequestMapping("/secured/*")
    public String securedPage() {
        return "home";
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}
