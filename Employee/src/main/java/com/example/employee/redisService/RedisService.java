package com.example.employee.redisService;

import com.example.employee.model.Employee;

import java.util.List;

public interface RedisService {
    Employee save(Employee employee);
    List<Employee> findAll(Employee employee);
    Employee findById(Employee employee);
    Employee delete(Employee employee);
}
