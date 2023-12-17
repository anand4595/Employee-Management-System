package com.example.CreateEmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CreateEmployeeService.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
