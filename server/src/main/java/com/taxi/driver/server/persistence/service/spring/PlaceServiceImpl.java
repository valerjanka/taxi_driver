package com.taxi.driver.server.persistence.service.spring;

import java.util.Iterator;
import java.util.List;

import com.taxi.driver.commons.model.Place;
import com.taxi.driver.server.persistence.dao.PlaceDao;
import com.taxi.driver.server.persistence.service.PlaceService;

public class PlaceServiceImpl implements PlaceService{

	private PlaceDao placeDao;
	
	public Place saveOrUpdate(Place place) {
		return placeDao.saveOrUpdate(place);
	}
	
	public List<Place> getByUserId(long userId) {
		List<Place> places = getAll();
		Iterator<Place> iterator = places.iterator();
		while(iterator.hasNext()) {
			Place place = iterator.next();
			if(place.user != null && place.user.id != null && place.user.id.equals(userId) ) {
				
			} else {
				iterator.remove();
			}
		}
		return places;
	}

	public Place getById(long id) {
		return placeDao.getById(id);
	}

	public void delete(Place place) {
		placeDao.delete(place);
	}

	public List<Place> getAll() {
		return placeDao.getAll();
	}

	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

}
