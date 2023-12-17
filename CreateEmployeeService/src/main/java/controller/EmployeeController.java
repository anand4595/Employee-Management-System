package controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeService")
public class EmployeeController {
	
	@GetMapping("/")
	public Map<String, Object> initailDepartmentList (){
		return null;
	}
}
