package training.spring.mvc.sample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.spring.mvc.sample.dao.ChildrenDao;
import training.spring.mvc.sample.dao.ParentDao;
import training.spring.mvc.sample.model.Children;
import training.spring.mvc.sample.model.Parent;
import training.spring.mvc.sample.service.MyService;

/**
 *
 * @author Patrick Tan
 */
@Service
public class ParentServiceImpl implements MyService {

    @Autowired
    private ChildrenDao childrenDao;
    @Autowired
    private ParentDao parentDao;

    @Override
    public List<Parent> getAllParent() {
        return parentDao.getAll();
    }

    @Override
    public List<Children> getAllChildren() {
        return childrenDao.getAll();
    }

    @Override
    public void save(Parent parent) {
//        parentDao.save(parent);
    }
}
