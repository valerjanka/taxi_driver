package com.taxi.driver.server.persistence.service.spring;

import java.util.List;

import com.taxi.driver.commons.model.User;
import com.taxi.driver.server.persistence.dao.UserDao;
import com.taxi.driver.server.persistence.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public User saveOrUpdate(User user) {
		return userDao.saveOrUpdate(user);
	}

	public User getById(long id) {
		return userDao.getById(id);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
