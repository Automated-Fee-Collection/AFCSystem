package com.afcs.backend;

import com.afcs.backend.sms.AfricaTalkingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AfricaTalkingProperties.class)
@SpringBootApplication
public class AfcsBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AfcsBackendApplication.class, args);
	}

}
