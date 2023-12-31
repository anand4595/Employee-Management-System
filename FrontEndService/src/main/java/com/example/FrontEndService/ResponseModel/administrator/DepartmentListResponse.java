package com.example.FrontEndService.ResponseModel.administrator;

import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import com.example.FrontEndService.model.Department;

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
