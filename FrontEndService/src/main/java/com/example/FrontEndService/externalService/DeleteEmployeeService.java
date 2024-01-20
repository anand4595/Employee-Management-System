package com.example.FrontEndService.externalService;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="delete-employee-service")
public interface DeleteEmployeeService {
	@GetMapping("/DeleteEmployeeService/deleteById")
	public Map<String, Object> deleteEmployeeById(@RequestParam long id);
	
}