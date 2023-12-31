package com.CRUD.ResponseModel.administrator;

import com.CRUD.model.Department;
import com.CRUD.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentListResponse {
    private CustomResponseStatus status;
    private String message;
    private List<Department> departmentList;
}
