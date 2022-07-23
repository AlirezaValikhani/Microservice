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
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String email;
}
