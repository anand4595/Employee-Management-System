package com.example.DeleteEmployeeService.model;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class EmployeeNameModel {
    private String first_name;
    private String middle_name;
    private String last_name;

    public static Map<String, String> getMap(EmployeeNameModel e){
    	Map<String, String> m = new HashMap<String, String>();
    	
    	m.put("first_name", e.getFirst_name());
    	m.put("middle_name", e.getMiddle_name());
    	m.put("last_name", e.getLast_name());
    	return m;
    }
}