package com.example.FrontEndService.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.CRUD.ResponseModel.employee.CreateEmployeeResponse;
import com.example.FrontEndService.ResponseModel.administrator.AddDepartmentResponse;
//import com.CRUD.ResponseModel.administrator.AddDepartmentResponse;
//import com.CRUD.ResponseModel.administrator.ReadAllContactUsResponse;
import com.example.FrontEndService.ResponseModel.administrator.DepartmentListResponse;
import com.example.FrontEndService.ResponseModel.administrator.ReadAllContactUsResponse;
import com.example.FrontEndService.ResponseModel.employee.CreateEmployeeResponse;
//import com.example.FrontEndService.ResponseModel.employee.CreateEmployeeResponse;

@FeignClient(name="CRUD-SERVICE")
public interface CRUDService {
	  @GetMapping("departmentService/departmentList")
	    public ResponseEntity<DepartmentListResponse> departmentList() ;
	  
	  @GetMapping("contactUsService/readAllQuery")
	    public ResponseEntity<ReadAllContactUsResponse> readAllQuery ();
	  
	    @PostMapping("departmentService/addDepartment")
	    public ResponseEntity<AddDepartmentResponse> addDepartment(
	            @RequestParam("department") String department
	    );
	    
	    @PostMapping("createService/create")
	    public ResponseEntity<CreateEmployeeResponse> create(
	            @RequestParam("salary") int salary,
	            @RequestParam("email") String email,
	            @RequestParam("gender") String gender,
	            @RequestParam("age") int age,
	            @RequestParam("firstName") String firstName,
	            @RequestParam("middleName") String middleName,
	            @RequestParam("lastName") String lastName,
	            @RequestParam("role") String role,
	            @RequestParam("password") String password,
	            @RequestParam("department") String department
	    ) ;
	    
	  
}
