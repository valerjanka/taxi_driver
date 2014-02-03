package com.taxi.driver.commons.model;

import java.io.Serializable;

public class Coordinate implements Serializable {
	public Long id;
	public long longitude;
	public long latitude;
	
	@Override
	public String toString() {
		return "Coordinate [id=" + id + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}
	
	
}
