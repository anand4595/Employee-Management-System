package com.example.FrontEndService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.externalService.DeleteEmployeeService;
import com.example.FrontEndService.model.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
//@Slf4j
public class DeleteEmployeeController {

	@Autowired
	DeleteEmployeeService deleteEmployeeService;

	@GetMapping("/deleteEmployee")
	public ModelAndView getDeleteEmployee(HttpServletRequest httpServletRequest) {
    	HttpSession session = httpServletRequest.getSession();
    	
    	if (session.getAttribute("Role") == null || session.getAttribute("Role") != Role.Admin) {
			return new ModelAndView("accessDenied");
		}
		System.out.println("*****");
		System.out.println("GET - /deleteEmployee");

		ModelAndView modelAndView = new ModelAndView("deleteEmployee");

//		log.info("*****");
		return modelAndView;
	}

	@PostMapping("/deleteEmployee")
	public ModelAndView postDeleteEmployee(HttpServletRequest httpServletRequest) {
    	HttpSession session = httpServletRequest.getSession();
    	
    	if (session.getAttribute("Role") == null || session.getAttribute("Role") != Role.Admin) {
			return new ModelAndView("accessDenied");
		}
//		log.info("*****");
//		log.info("POST - /deleteEmployee");
//		log.info("employeeId = " + httpServletRequest.getParameter("employeeId"));

		ModelAndView modelAndView = new ModelAndView("deleteEmployee");
		Long employeeId = Long.parseLong(httpServletRequest.getParameter("employeeId"));

		Map<String, Object> serverResponse = null;
		
//		calling delete employee microservice
		try {
			serverResponse = deleteEmployeeService.deleteEmployeeById(employeeId);

//			log.info("Called delete-employee-service");
//			log.info("Response = " + serverResponse.get("message"));
		
		} catch (Exception e) {
//			log.error("delete-employee-service error");
//			log.error(e.getMessage());
		}

		modelAndView.addObject("serverResponse", serverResponse);

//		log.info("*****");
		return modelAndView;
	}

}