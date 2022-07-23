package com.example.microservice.service;

import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(CustomerInformation customerInformation);
    Customer loadById(String email);
    List<Customer> findAll();
    String delete(String email);
    String update(CustomerInformation customerInformation);
}
