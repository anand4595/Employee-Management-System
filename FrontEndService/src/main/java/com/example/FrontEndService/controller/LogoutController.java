package com.example.FrontEndService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
	
	@GetMapping("/auth/logout")
	ModelAndView logout(HttpServletRequest httpServletRequest) {
		
		ModelAndView modelAndView = new ModelAndView("logout");
		
		String email = (String) httpServletRequest.getSession().getAttribute("email");
		modelAndView.addObject("email", email);
		
		httpServletRequest.getSession().invalidate();
		
		return modelAndView;
	}
	
}