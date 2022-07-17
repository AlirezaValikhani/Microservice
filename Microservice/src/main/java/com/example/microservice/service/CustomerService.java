package com.example.microservice.service;

import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.model.Customer;

public interface CustomerService {
    Customer save(CustomerInformation customerInformation);
    Customer loadById(Long id);
}
