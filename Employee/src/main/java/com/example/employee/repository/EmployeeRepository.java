package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Query("select e from Employee e where e.id = :id")
    Employee loadById(@Param("id") Long id);
}
