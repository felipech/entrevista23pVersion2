package com.entrevistav2.entrevista.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.entrevistav2.entrevista")
@EnableJpaRepositories("com.entrevistav2.entrevista")
@EntityScan("com.entrevistav2.entrevista")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
