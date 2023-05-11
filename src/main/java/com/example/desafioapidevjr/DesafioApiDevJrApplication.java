package com.example.desafioapidevjr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioApiDevJrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiDevJrApplication.class, args);
	}

}
