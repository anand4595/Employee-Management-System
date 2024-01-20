package com.example.AdministratorService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdministratorService.model.AuthenticationModel;
import com.example.AdministratorService.model.EmployeeModel;
import com.example.AdministratorService.model.Role;
import com.example.AdministratorService.repository.AuthenticationRepository;
import com.example.AdministratorService.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
//@Slf4j
public class AuthenticationController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AuthenticationRepository authenticationRepository;
	
	@PostMapping("/login")
	public Map<String, Object> login(
			@RequestParam("email") String email,
			@RequestParam("password") String password
		){
//		log.info("*****");
//		log.info("POST /auth/login");
//		log.info("Email = " + email);
//		log.info("Password = " + "*****");
		
		Map serverResponce = new HashMap<String, Object>();
//		serverResponce.put("status", null);
//		serverResponce.put("message", null);

		
//		check if email exists
		List<EmployeeModel> userWithGivenEmail = employeeRepository.findByEmail(email);
		
		if (email.equals("root@root.com") && password.equals("root")) {
//			log.info("Logged in as root user");
			serverResponce.put("status", "success");
			serverResponce.put("message", "Login granted");
			serverResponce.put("Role" , Role.Admin.toString());	
			return serverResponce;
		}
		
		if (userWithGivenEmail.size() == 1) {
//			log.info("User with email found");
			
			List<AuthenticationModel> authenticationModelOfUser = authenticationRepository.findByEmployeeModel(userWithGivenEmail.get(0));
//			check if password matches
			if (authenticationModelOfUser.get(0).getPassword().equals(password)) {
//				log.info("Password match");
				serverResponce.put("status", "success");
				serverResponce.put("message", "Login granted");
				serverResponce.put("Role" , authenticationModelOfUser.get(0).getRole().toString());

			}else {
//				log.info("password dose not match");
				serverResponce.put("status", "fail");
				serverResponce.put("message", "Password is not correct");
				serverResponce.put("Role" , null);
			}
			
		}else {
//			log.info("User with given email not found");
			serverResponce.put("status", "not found");
			serverResponce.put("message", "User with given email not found");
			serverResponce.put("Role" , null);
			
		}
		
//		log.info("*****");
		return serverResponce;
	}
}