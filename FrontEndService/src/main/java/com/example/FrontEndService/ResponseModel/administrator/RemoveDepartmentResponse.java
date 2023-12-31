package com.example.FrontEndService.ResponseModel.administrator;

import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveDepartmentResponse {
    private CustomResponseStatus status;
    private String message;
    private boolean isDepartmentRemoved;
}
