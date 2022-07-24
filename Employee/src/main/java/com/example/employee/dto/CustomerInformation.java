package com.example.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class CustomerInformation implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
}
