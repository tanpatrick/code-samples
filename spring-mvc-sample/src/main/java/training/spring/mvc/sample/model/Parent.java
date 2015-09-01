package training.spring.mvc.sample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Patrick Tan
 */
@Entity
@Table(name = "parent")
public class Parent implements Serializable {

    private Integer parentId;
    private String parentName;
    @JsonBackReference
    private List<Children> children = new ArrayList<>();

    public Parent() {
    }

    public Parent(Integer parentId, String parentName) {
        this.parentId = parentId;
        this.parentName = parentName;
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Column(name = "parent_name")
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

}
