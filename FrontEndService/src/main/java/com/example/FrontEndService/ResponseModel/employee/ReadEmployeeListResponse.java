package com.example.FrontEndService.ResponseModel.employee;


import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import com.example.FrontEndService.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadEmployeeListResponse {
    private CustomResponseStatus status;
    private String message;
    private List<Employee> employeeList;
}
