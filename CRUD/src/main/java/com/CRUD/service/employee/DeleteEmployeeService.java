package com.CRUD.service.employee;

import com.CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeleteEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean deleteEmployee(long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
