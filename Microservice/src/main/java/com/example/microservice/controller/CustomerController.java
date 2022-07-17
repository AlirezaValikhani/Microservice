package com.example.microservice.controller;

import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.model.Customer;
import com.example.microservice.service.impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<Customer> register(CustomerInformation customerInformation){
        return ResponseEntity.ok().body(customerService.save(customerInformation));
    }

    @GetMapping("/")
    public ResponseEntity<Customer> findEmployee(@RequestParam Long id) {
        return ResponseEntity.ok().body(customerService.loadById(id));
    }
}