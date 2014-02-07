package com.taxi.driver.server.persistence.dao;

import java.util.List;

import com.taxi.driver.commons.model.Place;

public interface PlaceDao {
	Place saveOrUpdate(Place Place);
	
	Place getById(long id);
	
	void delete(Place Place);
	
	List<Place> getAll();

}
