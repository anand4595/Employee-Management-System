package com.example.FrontEndService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeNameModel {
    private String first_name;
    private String middle_name;
    private String last_name;

}