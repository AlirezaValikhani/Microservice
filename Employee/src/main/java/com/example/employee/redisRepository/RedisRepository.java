package com.example.employee.redisRepository;

import com.example.employee.model.Employee;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisRepository {
    private RedisTemplate template;
    private static final String HASH_KEY = "Employee";

    public RedisRepository(RedisTemplate template) {
        this.template = template;
    }

    public Employee save(Employee employee){
        template.opsForHash().put(HASH_KEY,employee.getId(),employee);
        return employee;
    }

    public List<Employee> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Employee findById(Long id){
        return (Employee) template.opsForHash().get(HASH_KEY,id);
    }

    public String delete(Long id){
        template.opsForHash().delete(HASH_KEY,id);
        return "Employee removed";
    }
}
