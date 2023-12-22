package com.example.UpdateEmployeeService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UpdateEmployeeService.model.AuthenticationModel;
import com.example.UpdateEmployeeService.model.DepartmentListModel;
import com.example.UpdateEmployeeService.model.EmployeeGender;
import com.example.UpdateEmployeeService.model.EmployeeModel;
import com.example.UpdateEmployeeService.model.EmployeeNameModel;
import com.example.UpdateEmployeeService.model.Role;
import com.example.UpdateEmployeeService.repository.AuthenticationRepository;
import com.example.UpdateEmployeeService.repository.EmployeeRepository;

@RestController
@RequestMapping("/employeeService")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AuthenticationRepository authenticationRepository;

	@PostMapping("/updateEmployee")
	public Map<String, String> createEmployee(
			@RequestParam Long employeeId,
			@RequestParam String firstName,
			@RequestParam String middleName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String gender,
			@RequestParam int age,
			@RequestParam int salary,
			@RequestParam String department,
			@RequestParam String role,
			@RequestParam String password

	) 
	{
		EmployeeModel employeeModel = EmployeeModel
				.builder()
				.name(
					EmployeeNameModel
					.builder()
					.first_name(firstName)
					.middle_name(middleName)
					.last_name(lastName)
					.build()
				)
				.email(email)
				.gender(EmployeeGender.valueOf(gender))
				.age(age)
				.salary(salary)
				.deparment(
						DepartmentListModel
								.builder()
								.name(department)
								.build())
				.build();

		employeeModel = employeeRepository.save(employeeModel);

		AuthenticationModel authenticationModel = AuthenticationModel
				.builder()
				.employeeModel(employeeModel)
				.role(Role.valueOf(role))
				.password(password)
				.build();

		authenticationRepository.save(authenticationModel);

		Map<String, String> responce = new HashMap<>();
		responce.put("status", "success");
		responce.put("message", "New Employee have been created with ID: " + employeeModel.getId());

		return responce;
	}
}
