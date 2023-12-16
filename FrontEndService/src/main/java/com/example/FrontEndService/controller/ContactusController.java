package com.example.FrontEndService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ContactusController {

	@GetMapping("/contactus")
	public String contactusGet() {
		return "contactus";
	}

	@PostMapping("/contactus")
	public ModelAndView contactusPost(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("contactus");
		
		modelAndView.addObject("name", httpServletRequest.getParameter("name"));
		modelAndView.addObject("email", httpServletRequest.getParameter("email"));
		
		return modelAndView;
	}
}
