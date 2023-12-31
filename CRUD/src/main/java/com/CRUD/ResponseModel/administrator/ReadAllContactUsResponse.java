package com.CRUD.ResponseModel.administrator;


import com.CRUD.model.ContactUs;
import com.CRUD.ResponseModel.CustomResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadAllContactUsResponse {
    private CustomResponseStatus status;
    private String message;
    private List<ContactUs> contactUsList;
}
