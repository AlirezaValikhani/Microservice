package com.example.employee.controller;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public ResponseEntity<Employee> register(@RequestBody EmployeeInformation employeeInformation){
        return ResponseEntity.ok().body(employeeService.save(employeeInformation));
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Employee> findEmployee(@PathVariable @RequestParam String email) {
        return ResponseEntity.ok().body(employeeService.findById(email));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam String email) {
        return ResponseEntity.ok().body(employeeService.delete(email));
    }
}
