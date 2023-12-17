package com.example.FrontEndService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeModel {
	private long id;
	int salary;
	private String email;
	private EmployeeGender gender;
	private int age;
	EmployeeNameModel name;
	private DepartmentListModel deparment;

}