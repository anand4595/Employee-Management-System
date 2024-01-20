package com.example.FrontEndService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.externalService.AdministratorService;

//import com.example.FrontEndService.externalService.AdministratorService.ContactUsService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

@Controller
public class ContactusController {

	@Autowired
	AdministratorService administratorService;
	
	@GetMapping("/contactus")
	public String contactusGet() {
		return "contactus";
	}

	@PostMapping("/contactus")
	public ModelAndView contactusPost(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("contactus");
		String name = httpServletRequest.getParameter("name");
		String email = httpServletRequest.getParameter("email");
		String query = httpServletRequest.getParameter("query");

//		this is inter service communication
		Map<String,String> serverResponce =  administratorService.createQuery(name, email, query);

		modelAndView.addObject("status", serverResponce.get("status"));
		modelAndView.addObject("message", serverResponce.get("message"));

		return modelAndView;
	}
}
