package com.sports.rafael;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
//@SpringBootApplication
@Slf4j
public class RafaelApplication implements CommandLineRunner {

	@Autowired
	private RafaelConfig rafaelConfig;

	@Value("${rafael.security.test:90}")
	private int expirationTime;

	@Override
	public void run(String... args) throws Exception {
		log.info("RUN...{}", rafaelConfig.toString());

		log.info("Test={}", expirationTime);



	}
}
