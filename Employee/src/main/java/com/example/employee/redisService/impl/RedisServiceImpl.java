package com.example.employee.redisService.impl;

import com.example.employee.model.Employee;
import com.example.employee.redisRepository.RedisRepository;
import com.example.employee.redisService.RedisService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    private final RedisRepository redisRepository;

    public RedisServiceImpl(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAll(Employee employee) {
        return null;
    }

    @Override
    public Employee findById(Employee employee) {
        return null;
    }

    @Override
    public Employee delete(Employee employee) {
        return null;
    }
}
