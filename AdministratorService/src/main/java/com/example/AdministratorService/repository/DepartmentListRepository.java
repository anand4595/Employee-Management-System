package com.example.AdministratorService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AdministratorService.model.DepartmentListModel;

import jakarta.transaction.Transactional;

public interface DepartmentListRepository extends JpaRepository<DepartmentListModel, String> {


//	List<DepartmentListModel> saveAll(List<DepartmentListModel> departmentListModel);
//	public List<DepartmentListModel> saveAll(List<DepartmentListModel> deparmentList);
	
}
