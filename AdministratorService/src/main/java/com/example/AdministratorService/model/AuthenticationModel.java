package com.example.AdministratorService.model;

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
@Table(name = "authentication_table")
public class AuthenticationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long EXTRA_ID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true, nullable = false)
    private EmployeeModel employeeModel;

    private Role role;

    private String password;
}
