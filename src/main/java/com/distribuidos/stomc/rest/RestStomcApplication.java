package com.distribuidos.stomc.rest;

import com.google.gson.Gson;
import dominio.Employee;
import negocio.EmployeeJpaController;
import negocio.EntityManagerFactoryBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
public class RestStomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestStomcApplication.class, args);

	}

	@GetMapping
	public String hello(){
		return "HELLO WORLD";
	}
}
