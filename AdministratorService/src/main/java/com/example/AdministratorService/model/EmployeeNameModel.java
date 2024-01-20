package com.example.AdministratorService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class EmployeeNameModel {
    private String first_name;
    private String middle_name;
    private String last_name;

}