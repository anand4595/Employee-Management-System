package com.CRUD.ResponseModel.administrator;

import com.CRUD.ResponseModel.CustomResponseStatus;
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
