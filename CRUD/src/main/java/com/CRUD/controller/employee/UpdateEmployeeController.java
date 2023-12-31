package com.CRUD.controller.employee;

import com.CRUD.model.*;
import com.CRUD.ResponseModel.CustomResponseStatus;
import com.CRUD.ResponseModel.employee.UpdateEmployeeResponse;
import com.CRUD.service.employee.UpdateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/updateEmployeeService/updateEmployeeById

@RestController
@RequestMapping("/updateEmployeeService")
public class UpdateEmployeeController {
    @Autowired
    UpdateEmployeeService updateEmployeeService;

    @PostMapping("/updateEmployeeById")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployeeById(@RequestParam int id, @RequestParam int salary, @RequestParam String email, @RequestParam String gender, @RequestParam int age, @RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName, @RequestParam String role, @RequestParam String password, @RequestParam String department) {
        Employee employee = Employee.builder().id(id).salary(salary).email(email).gender(Gender.valueOf(gender)).age(age).name(new Name(firstName, middleName, lastName)).role(Role.valueOf(role)).password(password).department(new Department(department)).build();

//        if employee is null that means the id dose not exists
        Employee updatedEmployee = updateEmployeeService.updateEmployee(employee);


        if (updatedEmployee != null) {
            return ResponseEntity.ok(UpdateEmployeeResponse.builder().isEmployeeUpdated(true).status(CustomResponseStatus.success).message("Employee with id: " + id + " has been updated").isEmployeeCreated(false).build());
        } else {
//            creating new employee using feign client later on
//            ResponseEntity<CreateEmployeeResponse> createEmployeeResponse = new CreateEmployeeController().create(salary, email, gender, age, firstName, middleName, lastName, role, password, department);

            return ResponseEntity.ok(
                    UpdateEmployeeResponse.builder().isEmployeeCreated(true).isEmployeeUpdated(false).status(CustomResponseStatus.notFound).message("Employee created with id: " + -1).build()
            );

        }

    }
}
