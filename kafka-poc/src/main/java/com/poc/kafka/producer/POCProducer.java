package com.poc.kafka.producer;

import java.util.Random;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.poc.kafka.avro.Employee;

@Slf4j
@Service
public class POCProducer {
    @Autowired
    private Processor processor;

    public void send(){
        Employee employee = new Employee();
        employee.setFirstName("Abid");
        employee.setLastName("Khan");
        employee.setId(new Random().nextInt());

        Message<Employee> message = MessageBuilder.withPayload(employee).build();
        processor.output().send(message);
    }
}
