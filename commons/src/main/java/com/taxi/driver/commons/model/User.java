package com.taxi.driver.commons.model;

import java.io.Serializable;

public class User implements Serializable{
	public Long id;
	public String name;
	public String pass;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
}
