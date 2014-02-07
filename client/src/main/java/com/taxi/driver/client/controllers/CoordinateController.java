package com.taxi.driver.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoordinateController {

	@RequestMapping("/index.html")
	public String index(Model model) {
		return "";
	}
}
