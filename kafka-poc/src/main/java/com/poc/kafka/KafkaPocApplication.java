package com.poc.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

@EnableBinding(Processor.class)
@EnableSchemaRegistryClient
@SpringBootApplication
public class KafkaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocApplication.class, args);
	}

}
