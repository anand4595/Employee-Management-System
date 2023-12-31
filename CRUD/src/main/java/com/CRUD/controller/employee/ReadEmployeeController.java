package com.CRUD.controller.employee;

import com.CRUD.ResponseModel.CustomResponseStatus;
import com.CRUD.ResponseModel.employee.ReadEmployeeListResponse;
import com.CRUD.service.employee.ReadEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readService")
public class ReadEmployeeController {

    @Autowired
    ReadEmployeeService readEmployeeService;

    @GetMapping("/employeeList")
    public ResponseEntity<ReadEmployeeListResponse> employeeList() {
        ReadEmployeeListResponse response = new ReadEmployeeListResponse();

        response.setStatus(CustomResponseStatus.success);
        response.setMessage("List of employees");
        response.setEmployeeList(readEmployeeService.readAll());
        return ResponseEntity.ok(response);
    }
}
