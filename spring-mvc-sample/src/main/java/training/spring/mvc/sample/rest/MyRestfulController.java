package training.spring.mvc.sample.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.spring.mvc.sample.model.Children;
import training.spring.mvc.sample.model.Parent;
import training.spring.mvc.sample.service.MyService;

/**
 *
 * @author Patrick Tan
 */
@RestController
@RequestMapping("/rest/api/*")
public class MyRestfulController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "hello", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "parent", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Parent parent() {
        return new Parent(1, "Patrick");
    }

    @RequestMapping(value = "parent/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Parent> parents() {
        return myService.getAllParent();
    }

    @RequestMapping(value = "children/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Children> children() {
        return myService.getAllChildren();
    }

    @RequestMapping(value = "parent/children", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Parent parentChildren() {
        Parent parent = new Parent(1, "Patrick");

        for (int i = 1; i <= 2; i++) {
            parent.getChildren().add(new Children(i * 10, "child [" + i + "]", parent));
        }

        return parent;
    }
}
