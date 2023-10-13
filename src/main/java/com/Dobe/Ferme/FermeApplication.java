package com.Dobe.Ferme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FermeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FermeApplication.class, args);
	}

}