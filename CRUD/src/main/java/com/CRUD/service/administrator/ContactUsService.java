package com.CRUD.service.administrator;

import com.CRUD.model.ContactUs;
import com.CRUD.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsService {

    @Autowired
    ContactUsRepository contactUsRepository;

    public List<ContactUs> getAllQueries() {
        return contactUsRepository.findAll();
    }

    public boolean addQuery (ContactUs contactUs){
        if (contactUsRepository.findById(contactUs.getEmail()).isPresent())
            return false;
        contactUsRepository.save(contactUs);
        return true;
    }
}
