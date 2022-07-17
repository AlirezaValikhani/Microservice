package com.example.microservice.model;

import com.example.microservice.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer extends Base<Long> {
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String email;
}
