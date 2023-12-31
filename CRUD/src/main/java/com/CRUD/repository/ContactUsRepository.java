package com.CRUD.repository;

import com.CRUD.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUs, String> {
}
