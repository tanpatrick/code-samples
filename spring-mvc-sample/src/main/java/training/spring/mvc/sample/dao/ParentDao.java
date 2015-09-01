package training.spring.mvc.sample.dao;

import java.util.List;
import training.spring.mvc.sample.model.Parent;

/**
 *
 * @author Patrick Tan
 */
public interface ParentDao {

    List<Parent> getAll();
}
