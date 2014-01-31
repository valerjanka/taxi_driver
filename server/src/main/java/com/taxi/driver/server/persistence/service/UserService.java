package com.taxi.driver.server.persistence.service;

import com.taxi.driver.server.model.User;

public interface UserService {
	void addUser(User user);
	
	User getUser(long id);
}
