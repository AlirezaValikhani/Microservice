package com.example.microservice.repository;

import com.example.microservice.model.Customer;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import redis.clients.jedis.JedisPool;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl {
    private final JedisCommonRepository jedisCommonRepository;
    private static final String HASH_KEY = "Customer";

    public CustomerRepositoryImpl() throws URISyntaxException {
        JedisPool pool = new JedisPool(new URI("redis://default:sOmE_sEcUrE_pAsS@127.0.0.1:6379"));
        this.jedisCommonRepository = new JedisCommonRepository(pool);
    }

    public Customer save(Customer customer) {
        String jsomCustomer = new Gson().toJson(customer);
        jedisCommonRepository.set(HASH_KEY,customer.getEmail(),jsomCustomer);
        return customer;
    }

    public List<Customer> findAll() {
        Map<String,String> map = jedisCommonRepository.getAll(HASH_KEY);
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(e -> new Customer(e.getKey(), e.getValue())).collect(Collectors.toList());
    }

    public Customer findById(String email) {
        String json = jedisCommonRepository.get(HASH_KEY, email);
        return new Gson().fromJson(json, Customer.class);
    }

    public String delete(String key) {
        jedisCommonRepository.del(key);
        return "Deleted successfully";
    }

    public void update(Customer customer) {
        save(customer);
    }
}
