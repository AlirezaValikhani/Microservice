package com.example.employee.dto;

import com.example.employee.validation.FirstName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInformation {
    @FirstName
    private String firstName;
    private String lastName;
    private String email;
}
