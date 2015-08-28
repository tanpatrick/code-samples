package training.spring.mvc.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login?logout";
    }

}
