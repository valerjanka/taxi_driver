package com.taxi.driver.server.persistence.service;

import java.util.List;

import com.taxi.driver.commons.model.Place;

public interface PlaceService {
	Place saveOrUpdate(Place place);
	
	Place getById(long id);
	
	List<Place> getByUserId(long userId);
	
	void delete(Place place);
	
	List<Place> getAll();

}
