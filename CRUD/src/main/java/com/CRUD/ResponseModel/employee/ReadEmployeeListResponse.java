package com.CRUD.ResponseModel.employee;


import com.CRUD.model.Employee;
import com.CRUD.ResponseModel.CustomResponseStatus;
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
