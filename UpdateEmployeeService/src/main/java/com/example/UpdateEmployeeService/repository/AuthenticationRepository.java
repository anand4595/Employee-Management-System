package com.example.UpdateEmployeeService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UpdateEmployeeService.model.AuthenticationModel;
import com.example.UpdateEmployeeService.model.EmployeeModel;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {
	 List<AuthenticationModel> findByEmployeeModel(EmployeeModel emp);
}