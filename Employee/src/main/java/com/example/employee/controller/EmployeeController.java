package com.example.employee.controller;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(EmployeeInformation employeeInformation){
        Employee employee = new Employee(employeeInformation.getFirstName(),employeeInformation.getLastName(),employeeInformation.getEmail());
        Employee foundedEmployee = employeeService.save(employee);
        if(foundedEmployee != null)
            return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
        else return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findEmployee")
    public ResponseEntity<Employee> findEmployee(Long id){
        Employee foundedEmployee = employeeService.findById(id);
        return ResponseEntity.ok(foundedEmployee);
    }
}
