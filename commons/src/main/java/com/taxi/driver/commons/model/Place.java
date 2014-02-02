package com.taxi.driver.commons.model;

import java.io.Serializable;
import java.util.Date;

public class Place implements Serializable{
	public long id;
	public User user;
	public Coordinate coordinate;
	public Date time;
}
