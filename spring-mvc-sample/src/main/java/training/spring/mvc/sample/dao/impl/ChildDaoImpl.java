package training.spring.mvc.sample.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.spring.mvc.sample.dao.ChildDao;
import training.spring.mvc.sample.model.Child;

/**
 *
 * @author Patrick Tan
 */
@Repository
public class ChildDaoImpl implements ChildDao {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Child> getAll() {
        Criteria criteria = getSession().createCriteria(Child.class);
        criteria.createAlias("parent", "parent");
        return criteria.list();
    }

    @Override
    public Child getChildById(Integer id) {
        Criteria criteria = getSession().createCriteria(Child.class);
        criteria.add(Restrictions.eq("childId", id));
        return (Child) criteria.uniqueResult();
    }

    private Session getSession() {
        return sf.getCurrentSession();
    }

}
