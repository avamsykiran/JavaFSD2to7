package com.cts.sbwmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@GetMapping({"","/","/home"})
	public String defaultUrlHandler() {
		return "home-page";
	}

	@RequestMapping("/header")
	public ModelAndView headerUrlHandler() {
		return new ModelAndView("header-segment", "webTitle", "Income Statement Portal");
	}
}
