package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private String firstName;
    private String lastName;
    private String email;

    public Employee(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }
}
