package com.example.microservice.controller;

import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.model.Customer;
import com.example.microservice.service.impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<Customer> register(@RequestBody CustomerInformation customerInformation){
        return ResponseEntity.ok().body(customerService.save(customerInformation));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> findByEmail(@PathVariable @RequestParam String email) {
        return ResponseEntity.ok().body(customerService.loadById(email));
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok().body(customerService.findAll());
    }

    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam String email) {
        return ResponseEntity.ok().body(customerService.delete(email));
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody CustomerInformation customerInformation) {
        return ResponseEntity.ok().body(customerService.update(customerInformation));
    }
}