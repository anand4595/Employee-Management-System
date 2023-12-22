package com.example.UpdateEmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UpdateEmployeeService.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
