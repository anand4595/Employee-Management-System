package com.example.UpdateEmployeeService.model;

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
@Table(name = "department_list_table")
@SequenceGenerator(name="department_id_seq", initialValue = 100)
public class DepartmentListModel {
    @Id
    @Column(nullable = false)
    String name;
    
}
