package com.example.CreateEmployeeService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee_table")
@SequenceGenerator(name = "employee_id_seq", initialValue = 1000)
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
	private long id;

	@Column(nullable = false)
	int salary;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private EmployeeGender gender;

	@Column(nullable = false)
	private int age;

	@Embedded
	EmployeeNameModel name;

	@ManyToOne
	@JoinColumn(name = "department")
	private DepartmentListModel deparment;

	@OneToOne(mappedBy = "employeeModel")
	AuthenticationModel authenticationModel;
}