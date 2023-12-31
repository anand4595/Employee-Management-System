package com.example.FrontEndService.ResponseModel.administrator;

import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDepartmentResponse {
    private CustomResponseStatus status;
    private String message;
    private boolean isDepartmentAdded;
}
