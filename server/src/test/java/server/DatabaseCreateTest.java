package server;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.taxi.driver.commons.model.Coordinate;
import com.taxi.driver.commons.model.Place;
import com.taxi.driver.commons.model.User;

public class DatabaseCreateTest {
	private static final SessionFactory ourSessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			ourSessionFactory = configuration
					.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return ourSessionFactory.openSession();
	}

	public static void main(String[] args) {
		save();
		save();
		Place place = getPlace();
		removePlace(place);
		place = getPlace();
		System.out.println(place);
	}

	private static void removePlace(Place place) {
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			getSession().delete(place);
			tx.commit();
			System.out.println("Place id : " + place.id + " was removed");
		} catch (Exception ex) {
			System.out.println(ex);
			if (tx != null)
				tx.rollback();
		} finally {
			getSession().close();
		}
	}

	private static Place getPlace() {
		Place place = null;
		try {
			place = (Place) getSession().get(Place.class, 0L);
			System.out.println("Place id : " + place.id);
			System.out.println("Place latitude : " + place.coordinate.latitude);
			System.out.println("Coordinate id : " + place.coordinate.id);
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			getSession().close();
		}
		return place;
	}

	private static void save() {
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			User user = new User();
			user.name = "test";
			user.pass = "test";
			Place place = new Place();
			place.coordinate = new Coordinate();
			place.coordinate.latitude = 30;
			place.coordinate.longitude = 35;
			place.user = user;
			place.time = new Date();
			getSession().save(user);
			getSession().save(place);
			tx.commit();
			System.out.println("User id : " + user.id);
			System.out.println("Place id : " + place.id);
			System.out.println("Coordinate id : " + place.coordinate.id);
		} catch (Exception ex) {
			System.out.println(ex);
			if (tx != null)
				tx.rollback();
			
		} finally {
			getSession().close();
		}
	}
}
