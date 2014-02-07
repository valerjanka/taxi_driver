package com.taxi.driver.server.persistence.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.driver.commons.model.Place;
import com.taxi.driver.server.persistence.dao.PlaceDao;

@Repository("PlaceRepository")
@Transactional(propagation = Propagation.MANDATORY, readOnly = true)
public class PlaceDaoImpl implements PlaceDao{

    private SessionFactory sessionFactory;
    
    @Transactional(readOnly = false)
	public Place saveOrUpdate(Place Place) {
		if(Place.id == null) {
			getSession().save(Place);
		} else {
			getSession().merge(Place);
		}
		return Place;
	}

    @Transactional(readOnly = false)
	public Place getById(long id) {
		return (Place) getSession().get(Place.class, id);
	}

	@Transactional(readOnly = false)
	public void delete(Place Place) {
		getSession().delete(Place);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Place> getAll() {
		return getSession().createCriteria(Place.class).list();
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
