package training.spring.mvc.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick Tan
 */
public class Parent {

    private Integer parentId;
    private String parentName;
    private List<Child> children = new ArrayList<>();

    public Parent(Integer parentId, String parentName) {
        this.parentId = parentId;
        this.parentName = parentName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

   
}
