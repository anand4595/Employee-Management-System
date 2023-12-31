package com.example.FrontEndService.ResponseModel.employee;

import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateEmployeeResponse {
    private CustomResponseStatus status;
    private String message;
    private boolean isEmployeeUpdated;
    private boolean isEmployeeCreated;
}
