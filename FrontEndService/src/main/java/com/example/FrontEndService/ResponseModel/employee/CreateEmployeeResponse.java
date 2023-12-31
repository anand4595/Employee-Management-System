package com.example.FrontEndService.ResponseModel.employee;

import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// -1 if email not found else any long
public class CreateEmployeeResponse {
    private CustomResponseStatus status;
    private String message;
    private boolean employeeCreated;
    private long employeeId;
}
