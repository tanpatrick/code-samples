package training.spring.mvc.sample.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import training.spring.mvc.sample.model.Children;
import training.spring.mvc.sample.model.Parent;

/**
 *
 * @author Patrick Tan
 */
public interface MyService {

    @Transactional(readOnly = true)
    List<Parent> getAllParent();

    @Transactional(readOnly = true)
    List<Children> getAllChildren();

    void save(Parent parent);
}
