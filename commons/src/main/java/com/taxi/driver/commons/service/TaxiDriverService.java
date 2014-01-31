package com.taxi.driver.commons.service;

import java.util.List;

import com.taxi.driver.commons.model.Place;
import com.taxi.driver.commons.model.User;

public interface TaxiDriverService {
	User addUser(User user);
	
	User getUser(long userId);
	
	List<Place> getPlaces(long userId);
	
	void addPlace(Place place);
}
