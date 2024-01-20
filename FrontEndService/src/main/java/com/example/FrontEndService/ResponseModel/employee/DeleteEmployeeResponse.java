package com.example.FrontEndService.ResponseModel.employee;


import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeResponse {
    private CustomResponseStatus status;
    private String message;
    private Boolean isDeleted;
//    private Boolean notFound;
}