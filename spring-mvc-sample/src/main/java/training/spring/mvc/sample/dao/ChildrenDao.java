package training.spring.mvc.sample.dao;

import java.util.List;
import training.spring.mvc.sample.model.Children;

/**
 *
 * @author Patrick Tan
 */
public interface ChildrenDao {

    List<Children> getAll();
}
