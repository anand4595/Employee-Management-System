package com.example.DeleteEmployeeService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.DeleteEmployeeService.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DeleteEmployeeService.model.EmployeeModel;
import com.example.DeleteEmployeeService.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/DeleteEmployeeService")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AuthenticationRepository authenticationRepository;

	@GetMapping("/deleteById")
	public Map<String, Object> getEmployeeById(@RequestParam long id) {

		Map<String, Object> responce = new HashMap<>();

		Optional<EmployeeModel> employeeModel = employeeRepository.findById(id);
		if (employeeModel.isPresent()){
			authenticationRepository.deleteByEmployeeModel(employeeModel.get());
			employeeRepository.deleteById(id);
			responce.put("status", "success");
			responce.put("message", "Deleted " + employeeModel.get().getName().getFirst_name() + " 's id");
		}
		else {
			responce.put("status", "fail");
			responce.put("message", "No employee with id: " + id);

		}
		return responce;
	}

}
