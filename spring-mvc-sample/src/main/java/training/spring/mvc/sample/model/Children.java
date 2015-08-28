package training.spring.mvc.sample.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Patrick Tan
 */
public class Children {

    private Integer childId;
    private String childName;
    @JsonManagedReference
    private Parent parent;

    public Children(Integer childId, String childName, Parent parent) {
        this.childId = childId;
        this.childName = childName;
        this.parent = parent;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

}
