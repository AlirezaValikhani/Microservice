package com.example.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }
}
