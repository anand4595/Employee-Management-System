package com.CRUD.service.employee;

import com.CRUD.model.Employee;
import com.CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CreateEmployeeService createEmployeeService;

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
            employeeRepository.save(employee);
            return employee;
        }
        return null;
    }
}
