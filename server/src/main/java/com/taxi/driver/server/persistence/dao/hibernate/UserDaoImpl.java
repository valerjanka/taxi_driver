package com.taxi.driver.server.persistence.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.driver.commons.model.User;
import com.taxi.driver.server.persistence.dao.UserDao;

@Repository("bookRepository")
@Transactional(propagation = Propagation.MANDATORY, readOnly = true)
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    
    @Transactional(readOnly = false)
	public User saveOrUpdate(User user) {
		if(user.id == null) {
			getSession().save(user);
		} else {
			getSession().merge(user);
		}
		return user;
	}

    @Transactional(readOnly = false)
	public User getById(long id) {
		return (User) getSession().get(User.class, id);
	}

	@Transactional(readOnly = false)
	public void delete(User user) {
		getSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<User> getAll() {
		return getSession().createCriteria(User.class).list();
	}
	
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
