package training.spring.mvc.sample.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.spring.mvc.sample.model.Child;
import training.spring.mvc.sample.model.Parent;
import training.spring.mvc.sample.service.BasicService;

/**
 *
 * @author Patrick Tan
 */
@RestController
@RequestMapping("/rest/api/*")
public class BasicRestController {

    @Autowired
    private BasicService basicService;

    @RequestMapping(value = "hello", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "child/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Child getChildById(@PathVariable("id") Integer childId) {
        return basicService.getChildById(childId);
    }

    @RequestMapping(value = "parent/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Parent getParentById(@PathVariable("id") Integer parentId) {
        return basicService.getParentById(parentId);
    }

    @RequestMapping(value = "parent/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Parent> parents() {
        return basicService.getAllParent();
    }

    @RequestMapping(value = "children/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Child> children() {
        return basicService.getAllChildren();
    }

    @RequestMapping(value = "parent/children", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Parent parentChildren() {
        Parent parent = new Parent(1, "Patrick");

        for (int i = 1; i <= 2; i++) {
            parent.getChildren().add(new Child(i * 10, "child [" + i + "]", parent));
        }

        return parent;
    }

}
