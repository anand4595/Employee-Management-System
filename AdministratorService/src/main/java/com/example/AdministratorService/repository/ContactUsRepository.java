package com.example.AdministratorService.repository;

import com.example.AdministratorService.model.ContactUsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactUsRepository extends JpaRepository<ContactUsModel, String> {
    public ContactUsModel save(ContactUsModel contactUsModel);
    public List<ContactUsModel> findAll();

    public boolean existsByEmail(String email);
}
