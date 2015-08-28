package training.spring.mvc.sample.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.spring.mvc.sample.model.Parent;

/**
 *
 * @author Patrick Tan
 */
@RestController
@RequestMapping("/rest/api/*")
public class MyRestfulController {

    @RequestMapping(value = "hello", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "parent", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Parent parent() {
        return new Parent(1, "Patrick");
    }
}
