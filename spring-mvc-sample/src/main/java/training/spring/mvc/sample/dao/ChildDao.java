package training.spring.mvc.sample.dao;

import java.util.List;
import training.spring.mvc.sample.model.Child;

/**
 *
 * @author Patrick Tan
 */
public interface ChildDao {

    List<Child> getAll();

    Child getChildById(Integer id);
}
