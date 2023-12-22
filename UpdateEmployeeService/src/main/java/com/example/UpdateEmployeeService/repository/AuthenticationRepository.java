package com.example.UpdateEmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UpdateEmployeeService.model.AuthenticationModel;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {

}


