package com.curso.java.spring.boot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.java.spring.boot.model.entities.Cliente;
import com.curso.java.spring.boot.model.entities.ClienteRepository;

@Configuration
public class Configuracion {

	@Bean
	public CommandLineRunner iniciarBaseDeDatos(ClienteRepository repo) {
		return args -> {
			repo.save(new Cliente("Ruben", 100));
			repo.save(new Cliente("Ruben2", 40));
			repo.save(new Cliente("Ruben3", 2300));
		};
	}
	
}
