package com.example.FrontEndService.controller;

import com.example.FrontEndService.ResponseModel.administrator.DepartmentListResponse;
import com.example.FrontEndService.ResponseModel.employee.CreateEmployeeResponse;
//import com.example.FrontEndService.externalServices.AdministratorService;
import com.example.FrontEndService.externalServices.CRUDService;
//import com.example.FrontEndService.externalServices.CreateEmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateEmployeeController {

	@Autowired
	CRUDService crudService;

	@GetMapping("/createEmployee")
	public ModelAndView createEmployee() {
		ModelAndView modelAndView = new ModelAndView("createEmployee");

		ResponseEntity<DepartmentListResponse> departmentListResponse = crudService.departmentList();

		modelAndView.addObject("departmentListResponse", departmentListResponse);

		return modelAndView;
	}

	@PostMapping("/createEmployee")
	public ModelAndView createEmployeePost(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("createEmployee");

		ResponseEntity<DepartmentListResponse> departmentListResponse = crudService.departmentList();

		modelAndView.addObject("departmentListResponse", departmentListResponse);

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

		ResponseEntity<CreateEmployeeResponse> CreateResponse = crudService.create(
	            salary,
	            email,
	            gender,
	            age,
	            firstName,
	            middleName,
	            lastName,
	            role,
	            password,
	            department
				);

		modelAndView.addObject("CreateResponse", CreateResponse);

		return modelAndView;
	}
}
