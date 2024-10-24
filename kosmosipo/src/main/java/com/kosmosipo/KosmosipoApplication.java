package com.kosmosipo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@EnableAutoConfiguration
@EnableCaching
@EnableJpaRepositories
@SpringBootApplication
public class KosmosipoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KosmosipoApplication.class, args);
	}

}
