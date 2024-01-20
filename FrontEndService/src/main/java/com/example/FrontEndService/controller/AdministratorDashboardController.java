package com.example.FrontEndService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.externalService.AdministratorService;
import com.example.FrontEndService.externalService.ReadEmployeeService;
//import com.example.FrontEndService.externalService.AdministratorService.ContactUsService;
//import com.example.FrontEndService.externalService.AdministratorService.DeparmentListService;
import com.example.FrontEndService.model.ContactUsModel;
import com.example.FrontEndService.model.DepartmentListModel;
import com.example.FrontEndService.model.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
// @RequestMapping("/admin")
public class AdministratorDashboardController {

	@Autowired
	AdministratorService administratorService;
	
	@Autowired
	ReadEmployeeService readEmployeeService;

	public ModelAndView standardDashboardDisplay(ModelAndView modelAndView) {

		List<ContactUsModel> contactUsModelList = administratorService.readAllQuery();
		List<DepartmentListModel> departmentListModel = administratorService.getDepartmentList();

		modelAndView.addObject("contactUsModelList", contactUsModelList);
		modelAndView.addObject("departmentListModel", departmentListModel);

		return modelAndView;
	}

public ModelAndView employeeDashboardDisplay(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
		
		HttpSession session = httpServletRequest.getSession();

		
		Map<String, Object> serverResponse = readEmployeeService.getEmployeeByEmail((String)session.getAttribute("email"));
		
		modelAndView.addObject("serverResponse", serverResponse);

		
		return modelAndView;
	}

	@GetMapping("/admin/dashboard")
	public ModelAndView administratorDashboard(HttpServletRequest httpServletRequest) {

		HttpSession session = httpServletRequest.getSession();

		if (session.getAttribute("Role") == null) {
			return new ModelAndView("accessDenied");

		} else if (session.getAttribute("Role") == Role.Admin) {
			return standardDashboardDisplay(new ModelAndView("administratorDashboard"));
		} else {
			return employeeDashboardDisplay(new ModelAndView("employeeDashboard"), httpServletRequest);
		}
	}

	@PostMapping("/admin/createDepartment")
	public ModelAndView createDepartment(HttpServletRequest httpServletRequest) {


		HttpSession session = httpServletRequest.getSession();

		if (session.getAttribute("Role") == null) {
			return new ModelAndView("accessDenied");

		} else if (session.getAttribute("Role") == Role.Admin) {
			
			ModelAndView modelAndView = new ModelAndView("administratorDashboard");

			String departmentName = (String) httpServletRequest.getParameter("departmentName");

			Map<String, String> addDeparmentNameResponce = administratorService.createDepartment(departmentName);

			modelAndView.addObject("addDeparmentNameResponce", addDeparmentNameResponce);

			return standardDashboardDisplay(modelAndView);
		} else {
			return employeeDashboardDisplay(new ModelAndView("employeeDashboard"), httpServletRequest);
		}

	}
}