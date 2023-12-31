package com.CRUD.controller.employee;

import com.CRUD.model.*;
import com.CRUD.ResponseModel.employee.CreateEmployeeResponse;
import com.CRUD.ResponseModel.CustomResponseStatus;
import com.CRUD.service.employee.CreateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// localhost:8080/createService/create
@RestController
@RequestMapping("/createService")
public class CreateEmployeeController {

    @Autowired
    private CreateEmployeeService createEmployeeService;

    private static CreateEmployeeResponse getCreateEmployeeResponse(long id) {
        CreateEmployeeResponse response = new CreateEmployeeResponse();

//        from create employee service
        if (id == -1) {
            response.setStatus(CustomResponseStatus.fail);
            response.setEmployeeId(-1);
            response.setEmployeeCreated(false);
            response.setMessage("Employee by email  already exists");
        } else {
            response.setStatus(CustomResponseStatus.success);
            response.setEmployeeId(id);
            response.setEmployeeCreated(true);
            response.setMessage("Employee created with id " + id);
        }
        return response;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateEmployeeResponse> create(
            @RequestParam("salary") int salary,
            @RequestParam("email") String email,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName,
            @RequestParam("lastName") String lastName,
            @RequestParam("role") String role,
            @RequestParam("password") String password,
            @RequestParam("department") String department
    ) {

        Employee employee = Employee
                .builder()
                .salary(salary)
                .email(email)
                .gender(Gender.valueOf(gender))
                .age(age)
                .name(new Name(firstName, middleName, lastName))
                .role(Role.valueOf(role))
                .password(password)
                .department(new Department(department))
                .build();

        long id = createEmployeeService.create(employee);

        CreateEmployeeResponse response = getCreateEmployeeResponse(id);

        return ResponseEntity.ok(response);
    }

}
