package com.example.employee.repository;

import com.example.employee.model.Employee;
import com.example.employee.repository.generic.JedisCommonRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class EmployeeRepositoryImp {
    private final JedisCommonRepository employeeRepository;
    private static final String HASH_KEY = "Employee";

    public EmployeeRepositoryImp() throws URISyntaxException {
        JedisPool pool = new JedisPool(new URI("redis://default:sOmE_sEcUrE_pAsS@127.0.0.1:6379"));
        this.employeeRepository = new JedisCommonRepository(pool);
    }

    public Employee save(Employee employee) {
        String jsonEm = new Gson().toJson(employee);
        employeeRepository.set(HASH_KEY, employee.getEmail(), jsonEm);
        return employee;
    }

    public List<Employee> findAll(){
        Map<String , String> map = employeeRepository.getAll(HASH_KEY);
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(e -> new Employee(e.getKey(), e.getValue())).collect(Collectors.toList());
    }


    public Employee findById(String email) {
        String json = employeeRepository.get(HASH_KEY, email);
        return new Gson().fromJson(json, Employee.class);
    }

    public String delete(String key) {
        employeeRepository.del(key);
        return "Deleted successfully";
    }

    public void update(Employee employee) {
        save(employee);
    }
}
