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
import com.example.FrontEndService.model.ContactUsModel;
import com.example.FrontEndService.model.DepartmentListModel;
import com.example.FrontEndService.model.Role;

import jakarta.servlet.SessionTrackingMode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/auth")
//@Slf4j
public class LoginController {

	@Autowired
	AdministratorService administratorService;

	@Autowired
	AdministratorDashboardController administratorDashboardController;

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

		Map<String, Object> serverResponse = readEmployeeService
				.getEmployeeByEmail((String) session.getAttribute("email"));

		modelAndView.addObject("serverResponse", serverResponse);

		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView getLogin() {
//		log.info("GET - login");
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	public ModelAndView postLogin(HttpServletRequest httpServletRequest) {
//		log.info("POST - login");
//		log.info("Email = " + httpServletRequest.getParameter("email"));

		String email = httpServletRequest.getParameter("email");
		String password = httpServletRequest.getParameter("password");

//		main logic
		Map<String, Object> serverResponse = administratorService.login(email, password);

		if (serverResponse.get("status").equals("success")) {
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("email", email);
			session.setAttribute("Role", Role.valueOf((String) serverResponse.get("Role")));
//			log.info("Role = " + serverResponse.get("Role"));
			if (Role.Employee == session.getAttribute("Role")) {
				return employeeDashboardDisplay(new ModelAndView("employeeDashboard"), httpServletRequest);

			} else if (Role.Admin == session.getAttribute("Role")) {

				ModelAndView modelAndView = new ModelAndView("readAllEmployee");

				List<Map<String, Object>> employeeList = readEmployeeService.getEmployeeList();
				modelAndView.addObject("employeeList", employeeList);

				return modelAndView;
			}
		} else {
			ModelAndView loginFail = new ModelAndView("login");

			loginFail.addObject("message", "Invalid login credentials");
			return loginFail;
		}
		return new ModelAndView("login");
	}
}