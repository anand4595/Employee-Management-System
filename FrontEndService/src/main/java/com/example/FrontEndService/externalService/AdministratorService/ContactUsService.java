package com.example.FrontEndService.externalService.AdministratorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//using feign client 
@FeignClient(name = "administrator-service", path = "/contactUs")
public interface ContactUsService {
	@GetMapping("/test")
	public String test();

	@GetMapping("/readAllQuery")
	public List<Object> readAllQuery();

	@PostMapping("/createQuery")
	public Map<String, String> createQuery(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("query") String query);
}
