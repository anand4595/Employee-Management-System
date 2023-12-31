package com.CRUD.controller.administrator;

import com.CRUD.model.*;
import com.CRUD.service.employee.CreateEmployeeService;
import com.CRUD.service.administrator.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InitializeDatabaseController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CreateEmployeeService employeeService;

    @GetMapping("/initialize")
    public ResponseEntity<String> initialize() {

        List<String> departmentList = new ArrayList<>();
        departmentList.add("HR");
        departmentList.add("Development");
        departmentList.add("Finance");
        departmentList.add("Others");
        departmentList.add("Not assigned");
        departmentList.add("Testing");

        for (String department : departmentList)
            departmentService.create(Department.builder().name(department).build());

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(
                Employee
                        .builder()
                        .salary(10_000)
                        .email("anand@xyz.com")
                        .gender(Gender.Male)
                        .age(12)
                        .name(
                                Name
                                        .builder()
                                        .firstName("anand")
                                        .middleName("kumar")
                                        .lastName("rohal")
                                        .build()
                        )
                        .role(Role.Admin)
                        .password("anand")
                        .department(new Department("Development"))
                        .build()
        );

        employeeService.createAll(employeeList);

        return ResponseEntity.ok("Added new Departments and initial employees");
    }
}
