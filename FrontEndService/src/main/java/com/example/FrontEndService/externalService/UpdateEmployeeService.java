package com.example.FrontEndService.externalService;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FrontEndService.model.Role;

@FeignClient(name="update-employee-service")
public interface UpdateEmployeeService {
    	@PostMapping("employeeService/updateEmployee")
		public Map<String, String> updateEmployee(
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
	
		);
}
