package com.example.FrontEndService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationModel {
    long EXTRA_ID;
    private EmployeeModel employeeModel;

    private Role role;

    private String password;
}
