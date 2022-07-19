package com.example.employee.model;

import com.example.employee.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@RedisHash("Employee")
public class Employee extends Base<Long> {
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String email;
}
