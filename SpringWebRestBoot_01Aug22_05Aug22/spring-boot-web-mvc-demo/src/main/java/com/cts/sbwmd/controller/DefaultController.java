package com.cts.sbwmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	/*
	 * http://localhost:7777
	 * http://localhost:7777/
	 * http://localhost:7777/home
	 */
	@GetMapping({"","/","/home"})
	public String defaultUrlHandler() {
		return "home-page";
	}
	
}
