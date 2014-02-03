package com.taxi.driver.commons.model;

import java.io.Serializable;
import java.util.Date;

public class Place implements Serializable{
	public Long id;
	public User user;
	public Coordinate coordinate;
	public Date time;
	
	@Override
	public String toString() {
		return "Place [id=" + id + ", user=" + user + ", coordinate="
				+ coordinate + ", time=" + time + "]";
	}
	
	
}
