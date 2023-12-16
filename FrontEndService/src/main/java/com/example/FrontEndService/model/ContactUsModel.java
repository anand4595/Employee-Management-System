package com.example.FrontEndService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactUsModel {
    private String email;
    private String name;
    private String query;
    private boolean solved;
}
