package training.spring.mvc.sample.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.spring.mvc.sample.dao.ParentDao;
import training.spring.mvc.sample.model.Parent;

/**
 *
 * @author Patrick Tan
 */
@Repository
public class ParentDaoImpl implements ParentDao {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Parent> getAll() {
        Criteria criteria = getSession().createCriteria(Parent.class);
        return criteria.list();
    }

    private Session getSession() {
        return sf.getCurrentSession();
    }

}
