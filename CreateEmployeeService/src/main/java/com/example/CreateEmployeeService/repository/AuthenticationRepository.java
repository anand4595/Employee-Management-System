package com.example.CreateEmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CreateEmployeeService.model.AuthenticationModel;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {

}
