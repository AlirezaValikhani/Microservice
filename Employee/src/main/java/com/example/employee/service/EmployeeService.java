package com.example.employee.service;

import com.example.employee.model.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(Long id);
}
