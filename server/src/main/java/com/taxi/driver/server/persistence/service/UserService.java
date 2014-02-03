package com.taxi.driver.server.persistence.service;

import java.util.List;

import com.taxi.driver.commons.model.User;

public interface UserService {
	User saveOrUpdate(User user);
	
	User getById(long id);
	
	void delete(User user);
	
	List<User> getAll();
}
