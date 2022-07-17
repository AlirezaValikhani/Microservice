package com.example.employee.service;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface EmployeeService {

    Employee save(EmployeeInformation employeeInformation);

    Employee findById(Long id);
}
