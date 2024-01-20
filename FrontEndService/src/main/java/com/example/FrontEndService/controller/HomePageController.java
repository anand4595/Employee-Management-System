package com.example.FrontEndService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
   
	@GetMapping("/")
    public String index(){
        return "index";
    }
	
	 @GetMapping("/index")
	    public String getIndexPage() {
	        return "index"; 
	    }
	 
	 @GetMapping("/login")
	 	public String loginPage() {
		 return "login";
	 }

	
}
