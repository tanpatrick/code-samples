package training.spring.mvc.sample.model;

/**
 *
 * @author Patrick Tan
 */
public class Child {

    private Integer childId;
    private String childName;
    private Parent parent;

    public Child(Integer childId, String childName, Parent parent) {
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
