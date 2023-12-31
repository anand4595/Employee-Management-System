package com.CRUD.controller.administrator;

import com.CRUD.model.ContactUs;
import com.CRUD.ResponseModel.CustomResponseStatus;
import com.CRUD.ResponseModel.administrator.AddQueryResponse;
import com.CRUD.ResponseModel.administrator.ReadAllContactUsResponse;
import com.CRUD.service.administrator.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// localhost:8080/contactUsService/readAllQuery
// localhost:8080/contactUsService/addQuery

@RestController
@RequestMapping("/contactUsService")
public class ContactUsController {

    @Autowired
    ContactUsService contactUsService;

    @GetMapping("/readAllQuery")
    public ResponseEntity<ReadAllContactUsResponse> readAllQuery () {
        return ResponseEntity.ok(
                ReadAllContactUsResponse
                        .builder()
                        .status(CustomResponseStatus.success)
                        .contactUsList(contactUsService.getAllQueries())
                        .message("All queries are displayed below")
                        .build()
        );
    }

    @PostMapping("/addQuery")
    public ResponseEntity<AddQueryResponse> addQuery (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String query
    ){
        ContactUs contactUs = ContactUs.builder().email(email).name(name).query(query).solved(false).build();
        boolean isSaved = contactUsService.addQuery(contactUs);
        return ResponseEntity.ok(
            AddQueryResponse
                    .builder()
                    .isQueryAdded(isSaved)
                    .message(isSaved? "Query with email " + email + " alredy exsists": "Thanks " + name + " your query has been added")
                    .status(CustomResponseStatus.success)
                    .build()
        );
    }
}
