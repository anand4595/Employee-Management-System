package com.CRUD.service.employee;

import com.CRUD.model.Employee;
import com.CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }
}
