package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImp {
    private RedisTemplate<String,Employee> redisTemplate;
    private HashOperations hashOperations;
    private static final String HASH_KEY = "Employee";

    public EmployeeRepositoryImp( RedisTemplate<String, Employee> redisTemplate, HashOperations hashOperations) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = hashOperations;
    }

    public Employee save(Employee employee){
        hashOperations.putIfAbsent(HASH_KEY,employee.getEmail(),employee);
        return employee;
    }

    public List<Employee> findAll(){
        return hashOperations.values(HASH_KEY);
    }


    public Employee findById(Long id){
        return (Employee) hashOperations.get(HASH_KEY,id);
    }

    public String delete(Long id){
        hashOperations.delete(HASH_KEY,id);
        return "Deleted successfully";
    }

    public void update(Employee employee) {
        save(employee);
    }
}
