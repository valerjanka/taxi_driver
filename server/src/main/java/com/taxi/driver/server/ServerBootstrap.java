package com.taxi.driver.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taxi.driver.commons.model.User;
import com.taxi.driver.server.persistence.service.UserService;

public class ServerBootstrap {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
				"data-db-context.xml", "applicationContext.xml"});
		UserService service = (UserService) ctx.getBean("userService");
 
        User user = new User();
        user.name = "test1";
        user.pass = "test1";
 
        System.out.println("Users in: " + service.getAll());
        System.out.println("Adding new user");
        service.saveOrUpdate(user);
        System.out.println("Users in: " + service.getAll());
        System.out.println("Deleting user:" + user);
        service.delete(user);
        System.out.println("Users in: " + service.getAll());
	}
}
