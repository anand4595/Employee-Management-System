package com.CRUD.service.employee;

import com.CRUD.model.Employee;
import com.CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CreateEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public long create(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository.findByEmail(employee.getEmail());
        if (employeeByEmail.isPresent())
            return -1;
        return employeeRepository.save(employee).getId();
    }

    public void createAll(List<Employee> employeeList) {
        employeeRepository.saveAll(employeeList);
    }
}
