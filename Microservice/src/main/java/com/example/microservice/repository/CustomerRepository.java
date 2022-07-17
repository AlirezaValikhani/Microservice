package com.example.microservice.repository;

import com.example.microservice.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    @Query("select c from Customer c where c.id = :id")
    Customer loadById(@Param("id") Long id);
}
