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
@Table(name = "department_list_table")
@SequenceGenerator(name="department_id_seq", initialValue = 100)
@Builder
public class DepartmentListModel {
    @Id
    @Column(nullable = false)
    String name;
    
}
