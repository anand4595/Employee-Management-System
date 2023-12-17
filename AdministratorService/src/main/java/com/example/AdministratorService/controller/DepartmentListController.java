package com.example.AdministratorService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdministratorService.model.DepartmentListModel;
import com.example.AdministratorService.repository.DepartmentListRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/deparment")
public class DepartmentListController {

	@Autowired
	DepartmentListRepository departmentListRepository;

	@GetMapping("/initialize")
	public Map<String, Object> initialize() {

		List<DepartmentListModel> ls = new ArrayList<>() {
			{
				add(DepartmentListModel.builder().name("HR").build());
				add(DepartmentListModel.builder().name("Finance").build());
				add(DepartmentListModel.builder().name("Devlopment").build());
				add(DepartmentListModel.builder().name("finance").build());
				add(DepartmentListModel.builder().name("Not Assigned").build());

			}
		};

		for (DepartmentListModel deparment : ls)
			if (!departmentListRepository.existsById(deparment.getName()))
				departmentListRepository.save(deparment);

		Map<String, Object> responce = new HashMap<String, Object>();

		responce.put("status", "success");
		responce.put("message", "Initialized HR, Finance, Devlopment, Other and not assigned");

		return responce;
	}

	@GetMapping("/getDepartmentList")
	public List<DepartmentListModel> getDepartmentList() {
		return departmentListRepository.findAll();
	}

	@PostMapping("/createDepartment")
	public Map<String, String> createDepartment(@RequestParam String name) {

		name = name.strip();

		DepartmentListModel deparment = DepartmentListModel.builder().name(name).build();
		Map<String, String> responce = new HashMap<String, String>();

		
		if (departmentListRepository.existsById(name)) {
			responce.put("status", "fail");
			responce.put("message", "deparment already exists");
		}else {
			departmentListRepository.save(deparment);
			responce.put("status", "success");
			responce.put("message", "added deparment " + name);	
		}
		
		return responce;

	}

}
