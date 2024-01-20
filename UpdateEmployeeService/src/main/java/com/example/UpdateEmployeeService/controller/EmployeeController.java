package com.example.UpdateEmployeeService.controller;

import com.example.UpdateEmployeeService.ExternalServices.CreateEmployeeService;
import com.example.UpdateEmployeeService.model.*;
import com.example.UpdateEmployeeService.repository.AuthenticationRepository;
import com.example.UpdateEmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employeeService")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private CreateEmployeeService createEmployeeService;

    @PostMapping("/updateEmployee")
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

    ) {
        Optional<EmployeeModel> employeeModel = employeeRepository.findById(employeeId);

        if (employeeModel.isEmpty()) {
            // Employee not found, call create service using Feign Client
            Map<String, String> response = createEmployeeService.createEmployee(
                    firstName,
                    middleName,
                    lastName,
                    email,
                    gender,
                    age,
                    salary,
                    department,
                    role,
                    password
            );


            return response;
        } else {
            // Employee found, perform update
        	
//        	System.err.println("-----------------------------------------------");
//        	System.err.println("/n/n/n/n" + "Indside else" +"/n/n/n/n");
//        	System.err.println("------------------------------------------------");
        	
        	EmployeeModel newEmpmodel = EmployeeModel
        			.builder()
        			.id(employeeId)
        			.name(EmployeeNameModel.builder().first_name(firstName).middle_name(middleName).last_name(lastName).build())
        			.age(age)
        			.salary(salary)
        			.email(email)
        			.deparment(DepartmentListModel.builder().name(department).build())
        			.gender(EmployeeGender.valueOf(gender))
        			.build();

//        	System.err.println("-----------------------------------------------");
//        	System.err.println("/n/n/n/n" + "newEmplomdel===/n" + newEmpmodel.toString() +"/n/n/n/n");
//        	System.err.println("------------------------------------------------");
        	
            newEmpmodel = employeeRepository.save(newEmpmodel);

//        	System.err.println("-----------------------------------------------");
//        	System.err.println("/n/n/n/n" + "employee saved===/n" + newEmpmodel.toString()+"/n/n/n/n");
//        	System.err.println("------------------------------------------------");
            
            
            List<AuthenticationModel> authenticationModel = authenticationRepository.findByEmployeeModel(newEmpmodel);

//        	System.err.println("-----------------------------------------------");
//        	System.err.println("/n/n/n/n" + "employee saved===/n" + authenticationModel.toString()+"/n/n/n/n");
//        	System.err.println("------------------------------------------------");
                      
            
            // Authentication found, perform update
            authenticationModel.get(0).setRole(Role.valueOf(role));
            authenticationModel.get(0).setPassword(password);

            authenticationRepository.save(authenticationModel.get(0));

//        	System.err.println("-----------------------------------------------");
//        	System.err.println("/n/n/n/n" + "Auth model saved" + "/n/n/n/n");
//        	System.err.println("------------------------------------------------");
            
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Employee with ID: " + employeeModel.get().getId() + " has been updated");
            return response;
        }
    }
}