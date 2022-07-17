package com.example.microservice.dto;

import com.example.microservice.validation.FirstName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class CustomerInformation {
    @FirstName
    private String firstName;
    private String lastName;
    @Email(message = "Message is not valid!!!",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
}
