package training.spring.mvc.sample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.spring.mvc.sample.dao.ChildDao;
import training.spring.mvc.sample.dao.ParentDao;
import training.spring.mvc.sample.model.Child;
import training.spring.mvc.sample.model.Parent;
import training.spring.mvc.sample.service.BasicService;

/**
 *
 * @author Patrick Tan
 */
@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    private ChildDao childrenDao;
    @Autowired
    private ParentDao parentDao;

    @Override
    public List<Parent> getAllParent() {
        return parentDao.getAll();
    }

    @Override
    public List<Child> getAllChildren() {
        return childrenDao.getAll();
    }

    @Override
    public Parent getParentById(Integer id) {
        return parentDao.getParentById(id);
    }

    @Override
    public Child getChildById(Integer id) {
        return childrenDao.getChildById(id);
    }

    @Override
    public void save(Parent parent) {
//        parentDao.save(parent);
    }

}
