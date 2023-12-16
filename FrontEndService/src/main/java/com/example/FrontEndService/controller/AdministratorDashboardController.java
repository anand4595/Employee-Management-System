package com.example.FrontEndService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.model.ContactUsModel;

@Controller
@RequestMapping("/admin")
public class AdministratorDashboardController {
	
	@GetMapping("/dashboard")
	public ModelAndView administratorDashboard() {
		ModelAndView modelAndView = new ModelAndView("administratorDashboard");
		
		ContactUsModel [] ls = new ContactUsModel[3];
		ls[0] = ContactUsModel.builder()
				.email("anand@xyz.com")
				.name("anand")
				.query("anands query")
				.solved(false)
				.build();
		
		ls[1] = ContactUsModel.builder()
				.email("anand@xyz.com")
				.name("anand")
				.query("anands query")
				.solved(true)
				.build();	
		
		ls[2] = ContactUsModel.builder()
				.email("yash@xyz.com")
				.name("yash")
				.query("yash query")
				.solved(true)
				.build();
		
		modelAndView.addObject("contactUsModelArray", ls);
		
		return modelAndView;
	}
}
