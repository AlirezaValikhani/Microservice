package com.example.microservice.service;

import com.example.microservice.model.Customer;

public interface CustomerService {
    Customer save(Customer customer);
    Customer loadById(Long id);
}
