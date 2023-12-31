package com.CRUD.service.administrator;

import com.CRUD.model.Department;
import com.CRUD.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public boolean create(Department department) {

        Optional<Department> departmentQuery = departmentRepository.findById(department.getName());

        if (departmentQuery.isPresent())
            return false;

        departmentRepository.save(department);
        return true;
    }

    public boolean delete(Department department) {
        Optional<Department> departmentQuery = departmentRepository.findById(department.getName());
        departmentRepository.delete(department);
        return departmentQuery.isPresent();
    }

    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

}
