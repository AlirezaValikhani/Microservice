package com.example.microservice.service.impl;

import com.example.microservice.model.Customer;
import com.example.microservice.repository.CustomerRepository;
import com.example.microservice.service.CustomerService;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer loadById(Long id) {
        return customerRepository.loadById(id);
    }
}
