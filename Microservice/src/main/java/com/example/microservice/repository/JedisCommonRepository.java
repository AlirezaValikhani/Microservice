package com.example.microservice.repository;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class JedisCommonRepository {
    private final JedisPool jedisPool;

    public JedisCommonRepository(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void set(String group,String key , String input){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.hset(group, key, input);
        }
    }

    public String get(String group, String key ) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hget(group,key);
        }
    }

    public Map<String, String> getAll(String group) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hgetAll(group);
        }
    }

    public void del(String group,String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.hdel(group, key);
        }
    }
}
