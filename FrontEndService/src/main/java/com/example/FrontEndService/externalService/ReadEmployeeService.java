package com.example.FrontEndService.externalService;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FrontEndService.model.EmployeeModel;

@FeignClient("read-emplooyee-service")
public interface ReadEmployeeService {
    @GetMapping("CreateEmployeeService/getEmployeeById")
    public Map<String, Object> getEmployeeById(@RequestParam long id);

    @GetMapping("CreateEmployeeService/getEmployeeList")
	public List<Map<String, Object>> getEmployeeList();
    
}
