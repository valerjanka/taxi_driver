package com.taxi.driver.server.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.driver.commons.model.Place;
import com.taxi.driver.server.persistence.service.PlaceService;

@Controller
public class PlaceController {
	private PlaceService placeService;

	@RequestMapping("/place")
	public @ResponseBody List<Place> getPlaces(
			@RequestParam(value = "userId", required = true) Long userId) {
		
		return placeService.getByUserId(userId);
	}

	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}
	
}
