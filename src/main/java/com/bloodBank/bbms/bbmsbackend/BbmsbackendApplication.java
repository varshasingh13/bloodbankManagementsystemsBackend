package com.bloodBank.bbms.bbmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BbmsbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbmsbackendApplication.class, args);
	}

}
