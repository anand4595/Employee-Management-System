package com.example.FrontEndService.externalService;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FrontEndService.model.ContactUsModel;
import com.example.FrontEndService.model.DepartmentListModel;


@FeignClient(name="administrator-service")
public interface AdministratorService {

//	department controller 
	
	@GetMapping("/deparment/initialize")
	public Map<String, Object> initialize();
	
	@GetMapping("/deparment/getDepartmentList")
	public List<DepartmentListModel> getDepartmentList();
	
	@PostMapping("/deparment/createDepartment")
	public Map<String, String> createDepartment(@RequestParam String name);

//	Contact us controller 
	
	@GetMapping("/contactUs/test")
	public String test();

    @GetMapping("/contactUs/readAllQuery")
    public List<ContactUsModel> readAllQuery();

	@PostMapping("/contactUs/createQuery")
	public Map<String, String> createQuery(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("query") String query);

	
}
