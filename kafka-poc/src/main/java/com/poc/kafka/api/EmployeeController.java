package com.poc.kafka.api;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.kafka.producer.POCProducer;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private POCProducer POCProducer;

    @GetMapping
    public Mono<ResponseEntity<String>> get() {
        return Mono.just(ResponseEntity.ok().body("success"));
    }

    @PostMapping
    public Mono<ResponseEntity<String>> post() {
        POCProducer.send();
        return Mono.just(ResponseEntity.ok().body("success"));
    }
}
