package com.example.FrontEndService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.externalService.AdministratorService;
import com.example.FrontEndService.externalService.CreateEmployeeService;
import com.example.FrontEndService.model.DepartmentListModel;
import com.example.FrontEndService.model.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CreateEmployeeController {

	@Autowired
	CreateEmployeeService createEmployeeService;

	@Autowired
	AdministratorService administratorService;

	@GetMapping("/createEmployee")
	public ModelAndView createEmployee(HttpServletRequest httpServletRequest) {
		
		HttpSession session = httpServletRequest.getSession();
		
		if (session.getAttribute("Role") == null || session.getAttribute("Role") != Role.Admin) {
			return new ModelAndView("accessDenied");
		}
		
		
		ModelAndView modelAndView = new ModelAndView("createEmployee");

		List<DepartmentListModel> departmentListModelList = administratorService.getDepartmentList();

		modelAndView.addObject("departmentListModelList", departmentListModelList);

		return modelAndView;
	}

	@PostMapping("/createEmployee")
	public ModelAndView createEmployeePost(
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("createEmployee");

		List<DepartmentListModel> departmentListModelList = administratorService.getDepartmentList();

		modelAndView.addObject("departmentListModelList", departmentListModelList);

		// post specific codes

		String firstName = httpServletRequest.getParameter("firstName");
		String middleName = httpServletRequest.getParameter("middleName");
		String lastName = httpServletRequest.getParameter("lastName");
		String email = httpServletRequest.getParameter("email");
		String gender = httpServletRequest.getParameter("gender");
		int age = Integer.parseInt(httpServletRequest.getParameter("age"));
		int salary = Integer.parseInt(httpServletRequest.getParameter("salary"));
		String department = httpServletRequest.getParameter("department");
		String role = httpServletRequest.getParameter("role");
		String password = httpServletRequest.getParameter("password");

		Map<String, String> responce = createEmployeeService.createEmployee(firstName, middleName, lastName, email, gender, age, salary, department,
				role, password);
		
		modelAndView.addObject("responce", responce);

		return modelAndView;
	}
}