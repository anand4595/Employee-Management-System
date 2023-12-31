package com.CRUD.controller.administrator;

import com.CRUD.model.Department;
import com.CRUD.ResponseModel.administrator.AddDepartmentResponse;
import com.CRUD.ResponseModel.administrator.DepartmentListResponse;
import com.CRUD.ResponseModel.CustomResponseStatus;
import com.CRUD.ResponseModel.administrator.RemoveDepartmentResponse;
import com.CRUD.service.administrator.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// localhost:8080/departmentService/departmentList
// localhost:8080/departmentService/addDepartment
// localhost:8080/departmentService/removeDepartment


@RestController
@RequestMapping("/departmentService")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departmentList")
    public ResponseEntity<DepartmentListResponse> departmentList() {
        DepartmentListResponse responseBody = new DepartmentListResponse();
        List<Department> departmentList = departmentService.getDepartmentList();

        responseBody.setStatus(CustomResponseStatus.success);
        responseBody.setMessage("List of departments");
        responseBody.setDepartmentList(departmentList);

        return ResponseEntity.ok(responseBody);

    }

    @PostMapping("/removeDepartment")
    public ResponseEntity<RemoveDepartmentResponse> responseDepartment(
            @RequestParam String department
    ) {
        boolean isRemoved = departmentService.delete(new Department(department));
        if (isRemoved) {
            return ResponseEntity.ok(
                    RemoveDepartmentResponse
                            .builder()
                            .isDepartmentRemoved(true)
                            .status(CustomResponseStatus.success)
                            .message("Remove department " + department)
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    RemoveDepartmentResponse
                            .builder()
                            .isDepartmentRemoved(false)
                            .status(CustomResponseStatus.fail)
                            .message(department + " doesn't exists")
                            .build()
            );
        }
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<AddDepartmentResponse> addDepartment(
            @RequestParam("department") String department
    ) {
        boolean isCreated = departmentService.create(new Department(department));


        if (isCreated) {
            return ResponseEntity.ok(
                    AddDepartmentResponse
                            .builder()
                            .isDepartmentAdded(true)
                            .status(CustomResponseStatus.success)
                            .message("Added department " + department)
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    AddDepartmentResponse
                            .builder()
                            .isDepartmentAdded(false)
                            .status(CustomResponseStatus.fail)
                            .message(department + " already exists")
                            .build()
            );
        }
    }
}
