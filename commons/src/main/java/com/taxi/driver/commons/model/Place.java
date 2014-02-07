package com.taxi.driver.commons.model;

import java.io.Serializable;
import java.util.Date;

public class Place implements Serializable{
	public Long id;
	public User user;
	public long longitude;
	public long latitude;
	public Date time;
	
	@Override
	public String toString() {
		return "Place [id=" + id + ", user=" + user + ", longitude="
				+ longitude + ", latitude=" + latitude + ", time=" + time + "]";
	}
	
}
