package com.CRUD.controller.employee;

import com.CRUD.ResponseModel.CustomResponseStatus;
import com.CRUD.ResponseModel.employee.DeleteEmployeeResponse;
import com.CRUD.service.employee.DeleteEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/deleteEmployeeService/deleteById

@RestController
@RequestMapping("/deleteEmployeeService")
public class DeleteEmployeeController {

    @Autowired
    DeleteEmployeeService deleteEmployeeService;

    @PostMapping("/deleteById")
    public ResponseEntity<DeleteEmployeeResponse> deleteById(
            @RequestParam long id
    ) {
        boolean deleted = deleteEmployeeService.deleteEmployee(id);

        DeleteEmployeeResponse response = new DeleteEmployeeResponse();

        if (deleted) {
            response.setIsDeleted(true);
            response.setStatus(CustomResponseStatus.notFound);
            response.setMessage("Employee with Id " + id + " was deleted");
        } else {
            response.setIsDeleted(false);
            response.setStatus(CustomResponseStatus.success);
            response.setMessage("Employee with Id " + id + " not found");
        }
        return ResponseEntity.ok(response);
    }

}
