package com.example.employee.service;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee save(EmployeeInformation employeeInformation);
    List<Employee> findAll();
    Employee findById(String id);
    String delete(String id);
    String update(EmployeeInformation employeeInformation);
}
