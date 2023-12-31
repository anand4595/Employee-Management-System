package com.example.FrontEndService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
 *   unique - id, email
 * */
public class Employee {
    int salary;
    private long id;
    private String email;

    private Gender gender;

    private int age;

    private Name name;

    private Role role;

    private String password;

    private Department department;

}