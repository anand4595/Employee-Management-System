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
import com.example.FrontEndService.externalService.UpdateEmployeeService;
import com.example.FrontEndService.model.DepartmentListModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UpdateController {

	@Autowired
	UpdateEmployeeService updateEmployeeService;

	@Autowired
	AdministratorService administratorService;

	@GetMapping("/updateEmployee")
	public ModelAndView createEmployee() {
		ModelAndView modelAndView = new ModelAndView("updateEmployee");

		List<DepartmentListModel> departmentListModelList = administratorService.getDepartmentList();

		modelAndView.addObject("departmentListModelList", departmentListModelList);

		return modelAndView;
	}

	@PostMapping("/updateEmployee")
	public ModelAndView updateEmployeePost(
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("updateEmployee");

		List<DepartmentListModel> departmentListModelList = administratorService.getDepartmentList();

		modelAndView.addObject("departmentListModelList", departmentListModelList);

		// post specific codes
		Long employeeid = Long.getLong(httpServletRequest.getParameter("employeeid"));
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

		Map<String, String> responce = updateEmployeeService.updateEmployee(employeeid,firstName, middleName, lastName, email, gender, age, salary, department,
				role, password);
		
		modelAndView.addObject("responce", responce);

		return modelAndView;
	}
}
