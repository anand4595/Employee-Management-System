package com.CRUD.ResponseModel.administrator;

import com.CRUD.ResponseModel.CustomResponseStatus;
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
