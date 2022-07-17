package com.example.employee.dto;

import com.example.employee.validation.FirstName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class EmployeeInformation {
    @FirstName
    private String firstName;
    private String lastName;
    @Email(message = "Message is not valid!!!",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
}
