package com.example.AdministratorService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AdministratorService.model.AuthenticationModel;
import com.example.AdministratorService.model.EmployeeModel;

//import com.example.CreateEmployeeService.model.AuthenticationModel;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {
	List<AuthenticationModel> findByEmployeeModel(EmployeeModel employeeModel);
	
}