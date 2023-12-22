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
            employeeModel.get().setName(EmployeeNameModel.builder()
                    .first_name(firstName)
                    .middle_name(middleName)
                    .last_name(lastName)
                    .build());
            employeeModel.get().setEmail(email);
            employeeModel.get().setGender(EmployeeGender.valueOf(gender));
            employeeModel.get().setAge(age);
            employeeModel.get().setSalary(salary);
            employeeModel.get().setDeparment(DepartmentListModel.builder().name(department).build());

            employeeRepository.save(employeeModel.get());

            Optional<AuthenticationModel> authenticationModel = authenticationRepository.findById(employeeModel.get().getId());

            // Authentication found, perform update
            authenticationModel.get().setRole(Role.valueOf(role));
            authenticationModel.get().setPassword(password);

            authenticationRepository.save(authenticationModel.get());

            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Employee with ID: " + employeeModel.get().getId() + " has been updated");
            return response;
        }
    }
}
