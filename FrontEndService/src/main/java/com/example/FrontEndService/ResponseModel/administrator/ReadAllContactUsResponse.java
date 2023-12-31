package com.example.FrontEndService.ResponseModel.administrator;


import com.example.FrontEndService.ResponseModel.CustomResponseStatus;
import com.example.FrontEndService.model.ContactUs;
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
