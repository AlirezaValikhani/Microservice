package com.example.employee.controller;

import com.example.employee.config.MQConfiguration;
import com.example.employee.dto.CustomerInformation;
import com.example.employee.dto.EmployeeInformation;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private RabbitTemplate rabbitTemplate;

    public EmployeeController(EmployeeServiceImpl employeeService, RabbitTemplate rabbitTemplate) {
        this.employeeService = employeeService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/")
    public ResponseEntity<Employee> register(@RequestBody EmployeeInformation employeeInformation){
        return ResponseEntity.ok().body(employeeService.save(employeeInformation));
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Employee> findByEmail(@PathVariable @RequestParam String email) {
        return ResponseEntity.ok().body(employeeService.findById(email));
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody EmployeeInformation employeeInformation) {
        return ResponseEntity.ok().body(employeeService.update(employeeInformation));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam String email) {
        return ResponseEntity.ok().body(employeeService.delete(email));
    }

    @PostMapping("/newCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerInformation customerInformation) {
        String result = (String) rabbitTemplate.convertSendAndReceive(MQConfiguration.EXCHANGE,
                MQConfiguration.ROUTING_KEY, customerInformation);
        return ResponseEntity.ok(result);
    }
}
