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

import lombok.extern.slf4j.Slf4j;

@RestController
//@Slf4j
@RequestMapping("/DeleteEmployeeService")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AuthenticationRepository authenticationRepository;

	@GetMapping("/deleteById")
	public Map<String, Object> deleteEmployeeById(@RequestParam long id) {
//		log.info("*****");
//		log.info("GET - /deleteById");
//		log.info("id = " + id);
		
		Map<String, Object> response = new HashMap<>();

		Optional<EmployeeModel> employeeModel = employeeRepository.findById(id);
		if (employeeModel.isPresent()){
			
			authenticationRepository.deleteByEmployeeModel(employeeModel.get());
			employeeRepository.deleteById(id);
			
			response.put("status", "success");
			response.put("message", "Deleted " + employeeModel.get().getName().getFirst_name() + " 's Account");
		}
		else {
			response.put("status", "fail");
			response.put("message", "No Employee with Id: " + id);

		}
		
//		log.info("response = ");
//		log.info("\t status = " + response.get("status"));
//		log.info("\t message = " + response.get("message"));
//		log.info("*****");
		return response;
	}

}