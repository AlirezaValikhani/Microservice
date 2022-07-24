package com.example.microservice.listener;

import com.example.microservice.config.MQConfiguration;
import com.example.microservice.dto.CustomerInformation;
import com.example.microservice.messageClass.CustomMessage;
import com.example.microservice.model.Customer;
import com.example.microservice.service.impl.CustomerServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private CustomerServiceImpl customerService;

    public MessageListener(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @RabbitListener(queues = MQConfiguration.QUEUE)
    @SendTo
    public String Listener(CustomerInformation customerInformation) {
        Customer customer = customerService.save(customerInformation);
        System.out.println(customer.getFirstName());
        return "OK";
    }
}
