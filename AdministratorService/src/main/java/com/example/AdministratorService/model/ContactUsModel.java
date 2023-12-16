package com.example.AdministratorService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ContactUsModel {
    @Id
    private String email;
    private String name;
    @Lob
    private String query;
    private boolean solved;
}
