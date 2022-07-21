package com.example.employee.config;

//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.JedisPool;
//
//@Configuration
//public class RedisConfiguration {
//
//
//    public JedisPool jedisPool() {
//        return new JedisPool();
//    }
//}
import com.example.employee.model.Employee;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
        import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
        import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Employee> redisTemplate(){
        RedisTemplate<String,Employee> redisTemplate = new RedisTemplate<String, Employee>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
