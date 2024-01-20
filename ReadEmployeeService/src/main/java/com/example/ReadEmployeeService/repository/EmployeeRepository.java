package com.example.ReadEmployeeService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReadEmployeeService.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    		Optional<EmployeeModel> findById(Long id);
    		List<EmployeeModel> findByEmail (String email);
    		
}