package com.example.ReadEmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReadEmployeeService.model.AuthenticationModel;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {

}
