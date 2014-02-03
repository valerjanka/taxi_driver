package com.taxi.driver.server.persistence.dao;

import java.util.List;
import com.taxi.driver.commons.model.User;

public interface UserDao {
	User saveOrUpdate(User user);
	
	User getById(long id);
	
	void delete(User user);
	
	List<User> getAll();
}
