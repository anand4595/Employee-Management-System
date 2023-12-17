package com.example.FrontEndService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.FrontEndService.externalService.AdministratorService;
//import com.example.FrontEndService.externalService.AdministratorService.ContactUsService;
//import com.example.FrontEndService.externalService.AdministratorService.DeparmentListService;
import com.example.FrontEndService.model.ContactUsModel;
import com.example.FrontEndService.model.DepartmentListModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
// @RequestMapping("/admin")
public class AdministratorDashboardController {

	@Autowired
	AdministratorService administratorService;

	public ModelAndView standardDashboardDisplay(ModelAndView modelAndView) {

		List<ContactUsModel> contactUsModelList = administratorService.readAllQuery();
		List<DepartmentListModel> departmentListModel = administratorService.getDepartmentList();

		modelAndView.addObject("contactUsModelList", contactUsModelList);
		modelAndView.addObject("departmentListModel", departmentListModel);

		return modelAndView;
	}

	@GetMapping("/admin/dashboard")
	public ModelAndView administratorDashboard() {
		ModelAndView modelAndView = new ModelAndView("administratorDashboard");
		return standardDashboardDisplay(modelAndView);
	}

	@PostMapping("/admin/createDepartment")
	public ModelAndView createDepartment(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView("administratorDashboard");
		
		String departmentName = (String) httpServletRequest.getParameter("departmentName");
		
		Map<String, String> addDeparmentNameResponce = administratorService.createDepartment(departmentName);
		
		modelAndView.addObject("addDeparmentNameResponce", addDeparmentNameResponce);
		
		return standardDashboardDisplay(modelAndView);
	}
}
