package com.example.Assignment4;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library Management System",version = "1.0",description = "API use for performing CRUD operation on Book."))
public class Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Application.class, args);
	}

}
