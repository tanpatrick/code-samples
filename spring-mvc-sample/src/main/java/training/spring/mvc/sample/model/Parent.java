package training.spring.mvc.sample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick Tan
 */
public class Parent {

    private Integer parentId;
    private String parentName;
    @JsonBackReference
    private List<Children> children = new ArrayList<>();

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

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

}
