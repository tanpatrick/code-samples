package training.spring.mvc.sample.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import training.spring.mvc.sample.model.Child;
import training.spring.mvc.sample.model.Parent;

/**
 *
 * @author Patrick Tan
 */
public interface BasicService {

    @Transactional(readOnly = true)
    List<Parent> getAllParent();

    @Transactional(readOnly = true)
    List<Child> getAllChildren();

    @Transactional(readOnly = true)
    Parent getParentById(Integer id);

    @Transactional(readOnly = true)
    Child getChildById(Integer id);

    void save(Parent parent);
}
