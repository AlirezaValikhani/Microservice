package com.example.microservice.service.impl;

import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.model.Customer;
import com.example.microservice.repository.CustomerRepositoryImpl;
import com.example.microservice.service.CustomerService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepositoryImpl customerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(CustomerInformation customerInformation) {
        Customer customer = new Customer(customerInformation.getFirstName(),customerInformation.getLastName(),customerInformation.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public Customer loadById(String email) {
        return customerRepository.findById(email);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public String delete(String email) {
        return customerRepository.delete(email);
    }

    @Override
    public String update(CustomerInformation customerInformation) {
        Customer customer = new Customer(customerInformation.getFirstName(),customerInformation.getLastName(),customerInformation.getEmail());
        return customerRepository.update(customer);
    }
}
