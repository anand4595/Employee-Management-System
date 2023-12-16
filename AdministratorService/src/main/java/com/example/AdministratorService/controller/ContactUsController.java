package com.example.AdministratorService.controller;

import com.example.AdministratorService.model.ContactUsModel;
import com.example.AdministratorService.repository.ContactUsRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/contactUs")
public class ContactUsController {
    @Autowired
    ContactUsRepository contactUsRepository;


    @GetMapping("/test")
    public String test(){
        return "working";
    }

    @GetMapping("/readAllQuery")
    public List<ContactUsModel> readAllQuery(){
        return contactUsRepository.findAll();
    }

    @PostMapping("/createQuery")
    public Map<String, String> createQuery(
           @RequestParam("name") String name,
           @RequestParam("email") String email,
           @RequestParam("query") String query
    ) {

        if (contactUsRepository.existsByEmail(email)){
            return new HashMap<>(){{
                put("status", "fail");
                put("message", "Query with this email exists please wait for it to be resolved");
            }};
        }


        ContactUsModel contactUsModel = ContactUsModel.builder()
                .name(name)
                .email(email)
                .query(query)
                .solved(false)
                .build();

        contactUsModel = contactUsRepository.save(contactUsModel);

        return new HashMap<>() {{
            put("status", "success");
            put("message", "Thanks for contacting us " + name + " we will respond you at " + email);
        }};
    }
}
