package com.taxi.driver.server;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taxi.driver.commons.model.Place;
import com.taxi.driver.commons.model.User;
import com.taxi.driver.server.persistence.service.PlaceService;
import com.taxi.driver.server.persistence.service.UserService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ServerBootstrap {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
				"data-db-context.xml", 
				"applicationContext.xml"});
		UserService service = (UserService) ctx.getBean("userService");
		PlaceService placeService = (PlaceService) ctx.getBean("placeService");
 
        User user = new User();
        user.name = "test1";
        user.pass = "test1";
 
        System.out.println("Users in: " + service.getAll());
        System.out.println("Adding new user");
        user = service.saveOrUpdate(user);
        System.out.println("Users in: " + service.getAll());
        Place place = new Place();
        place.latitude = 30;
        place.longitude = 40;
        place.time = new Date();
        place.user = user;
        System.out.println("Save place:" + place);
        placeService.saveOrUpdate(place);
        System.out.println("Places in:" + placeService.getAll());
        System.out.println("Users in: " + service.getAll());
        
        SpringApplication.run(ServerBootstrap.class, args);
	}
}
