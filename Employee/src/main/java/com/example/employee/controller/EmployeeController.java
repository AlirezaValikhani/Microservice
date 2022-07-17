package com.example.employee.controller;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public ResponseEntity<Employee> register(EmployeeInformation employeeInformation){
        return ResponseEntity.ok().body(employeeService.save(employeeInformation));
    }

    @GetMapping("/")
    public ResponseEntity<Employee> findEmployee(@RequestParam Long id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }
}
