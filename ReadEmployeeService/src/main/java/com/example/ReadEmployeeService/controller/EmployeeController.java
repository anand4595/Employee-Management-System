package com.example.ReadEmployeeService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReadEmployeeService.model.EmployeeModel;
import com.example.ReadEmployeeService.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/CreateEmployeeService")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/getEmployeeById")
	public Map<String, Object> getEmployeeById(@RequestParam long id) {

		Map<String, Object> responce = new HashMap<>();

		Optional<EmployeeModel> employeeModel = employeeRepository.findById(id);

		if (employeeModel.isEmpty()) {
			responce.put("status", "fail");
			responce.put("message", "employee not found");
			responce.put("employeeModel", null);
		} else {
			responce.put("status", "success");
			responce.put("message", "Employee found");
			responce.put("employeeModel", EmployeeModel.convertToMap(employeeModel.get()));
		}

		return responce;
	}

	@GetMapping("/getEmployeeList")
	public List<Map<String, Object>> getEmployeeList() {
		List<EmployeeModel> ls = employeeRepository.findAll();
	
		List<Map<String, Object>> responce = new ArrayList<Map<String,Object>>();
		
		for (EmployeeModel e : ls) {
			responce.add(EmployeeModel.convertToMap(e));
		}
		
		return responce;
	}
}
