package com.example.FrontEndService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.externalService.ReadEmployeeService;
import com.example.FrontEndService.model.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReadEmployeeController {

    @Autowired
    ReadEmployeeService readEmployeeService;

    @GetMapping("/readEmployeeById")
    public ModelAndView readEmployeeByIdGet(HttpServletRequest httpServletRequest) {
    	HttpSession session = httpServletRequest.getSession();
    	
    	if (session.getAttribute("Role") == null || session.getAttribute("Role") != Role.Admin) {
			return new ModelAndView("accessDenied");
		}
        ModelAndView modelAndView = new ModelAndView("readEmployeeById");
        return modelAndView;
    }

    @PostMapping("/readEmployeeById")
    public ModelAndView readEmployeeByIdPost(HttpServletRequest httpServletRequest) {
    	HttpSession session = httpServletRequest.getSession();
    	
    	if (session.getAttribute("Role") == null || session.getAttribute("Role") != Role.Admin) {
			return new ModelAndView("accessDenied");
		}
        ModelAndView modelAndView = new ModelAndView("readEmployeeById");

        Long employeeId = Long.parseLong(httpServletRequest.getParameter("employeeId"));

        Map<String, Object> responce = readEmployeeService.getEmployeeById(employeeId);
        modelAndView.addObject("responce", responce);
        
        return modelAndView;
    }
    
    @GetMapping("/readAllEmployee")
    public ModelAndView readAllEmployeeGet (HttpServletRequest httpServletRequest) {
    	HttpSession session = httpServletRequest.getSession();
    	
    	if (session.getAttribute("Role") == null || session.getAttribute("Role") != Role.Admin) {
			return new ModelAndView("accessDenied");
		}
    	ModelAndView modelAndView = new ModelAndView("readAllEmployee");
    	
    	List<Map<String, Object>>  employeeList = readEmployeeService.getEmployeeList();
    	modelAndView.addObject("employeeList", employeeList);
    	
    	
    	return modelAndView;
    }
    
}