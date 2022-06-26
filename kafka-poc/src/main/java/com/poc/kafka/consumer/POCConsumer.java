package com.poc.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

import com.poc.kafka.avro.Employee;

@Slf4j
@Service
public class POCConsumer {

    @StreamListener(Processor.INPUT)
    public void read(Employee employee) {
        log.info("Received employee with firstName={} lastName={} and id={}", employee.getFirstName(), employee.getLastName(), employee.getId());
    }
}
