package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.exception.NotFoundEmployeeException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(EmployeeInformation employeeInformation) {
        Employee employee = new Employee(employeeInformation.getFirstName()
                ,employeeInformation.getLastName(),employeeInformation.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = employeeRepository.loadById(id);
        if(employee == null)
            throw new NotFoundEmployeeException();
        else return employee;
    }
}
