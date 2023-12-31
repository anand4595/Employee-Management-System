package com.CRUD.model;

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
/*
 *   unique - id, email
 * */
public class Employee {
    @Column(nullable = false)
    int salary;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    private long id;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private int age;

    @Embedded
    private Name name;

    private Role role;

    private String password;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

}