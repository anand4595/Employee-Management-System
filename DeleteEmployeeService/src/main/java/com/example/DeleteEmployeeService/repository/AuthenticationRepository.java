package com.example.DeleteEmployeeService.repository;

import com.example.DeleteEmployeeService.model.EmployeeModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DeleteEmployeeService.model.AuthenticationModel;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {

    @Transactional
    void deleteByEmployeeModel (EmployeeModel employeeModel);
}
