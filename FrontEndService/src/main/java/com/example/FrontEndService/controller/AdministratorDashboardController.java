package com.example.FrontEndService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.ResponseModel.administrator.AddDepartmentResponse;
import com.example.FrontEndService.ResponseModel.administrator.DepartmentListResponse;
import com.example.FrontEndService.ResponseModel.administrator.ReadAllContactUsResponse;
import com.example.FrontEndService.externalServices.CRUDService;
//import com.example.FrontEndService.externalServices.AdministratorService;
import com.example.FrontEndService.model.ContactUs;

import jakarta.servlet.http.HttpServletRequest;

@Controller
 @RequestMapping("/admin")
public class AdministratorDashboardController {

	@Autowired
	CRUDService crudService;
	
	public ModelAndView standardDashboardDisplay(ModelAndView modelAndView) {

		ResponseEntity<ReadAllContactUsResponse> contactUsModelList = crudService.readAllQuery();
		ResponseEntity<DepartmentListResponse> departmentListModel = crudService.departmentList();

		modelAndView.addObject("contactUsModelList", contactUsModelList);
		modelAndView.addObject("departmentListModel", departmentListModel);

		return modelAndView;
	}
//
	@GetMapping("/dashboard")
	public ModelAndView administratorDashboard() {
		ModelAndView modelAndView = new ModelAndView("administratorDashboard");
		return standardDashboardDisplay(modelAndView);
	}
//
	@PostMapping("/createDepartment")
	public ModelAndView createDepartment(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("administratorDashboard");
		
		String departmentName = (String) httpServletRequest.getParameter("departmentName");
		
		ResponseEntity<AddDepartmentResponse> addDeparmentNameResponce = crudService.addDepartment(departmentName);
		
		modelAndView.addObject("addDeparmentNameResponce", addDeparmentNameResponce);
		
		return standardDashboardDisplay(modelAndView);
	}
}
