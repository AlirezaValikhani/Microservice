package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepositoryImp;
import com.example.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepositoryImp employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryImp employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee save(EmployeeInformation employeeInformation) {
        Employee employee = new Employee(employeeInformation.getFirstName(),employeeInformation.getLastName(),employeeInformation.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public String delete(String id) {
        return employeeRepository.delete(id);
    }
}
