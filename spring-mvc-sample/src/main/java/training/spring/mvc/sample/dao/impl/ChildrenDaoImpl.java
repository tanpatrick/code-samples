package training.spring.mvc.sample.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.spring.mvc.sample.dao.ChildrenDao;
import training.spring.mvc.sample.model.Children;

/**
 *
 * @author Patrick Tan
 */
@Repository
public class ChildrenDaoImpl implements ChildrenDao {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Children> getAll() {
        Criteria criteria = getSession().createCriteria(Children.class);
        return criteria.list();
    }

    private Session getSession() {
        return sf.getCurrentSession();
    }

}
