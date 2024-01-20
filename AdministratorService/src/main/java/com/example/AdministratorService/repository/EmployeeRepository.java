package com.example.AdministratorService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AdministratorService.model.EmployeeModel;

//import com.example.CreateEmployeeService.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
	List<EmployeeModel> findByEmail(String email);
}