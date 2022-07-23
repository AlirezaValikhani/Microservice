package com.example.microservice.service.impl;

import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.model.Customer;
import com.example.microservice.repository.JedisCommonRepository;
import com.example.microservice.service.CustomerService;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerServiceImpl implements CustomerService {
    private final JedisCommonRepository customerRepository;

    public CustomerServiceImpl(JedisCommonRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(CustomerInformation customerInformation) {
        Customer customer = new Customer(customerInformation.getFirstName(),customerInformation.getLastName(),customerInformation.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public Customer loadById(Long id) {
        return customerRepository.loadById(id);
    }
}
