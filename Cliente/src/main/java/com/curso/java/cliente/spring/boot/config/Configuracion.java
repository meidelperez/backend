package com.curso.java.cliente.spring.boot.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.java.cliente.spring.boot.model.ClienteRepository;
import com.curso.java.cliente.spring.boot.model.entities.Cliente;

@Configuration
public class Configuracion {

	@Bean
	public CommandLineRunner iniciarBaseDeDatos(ClienteRepository repo) {
		return args -> {
			repo.save(new Cliente("P074026","Meidel","Perez", "graciela 83 cuba"));
			repo.save(new Cliente("P074027","Samuel","Perez", "graciela 83 cuba"));
			repo.save(new Cliente("P074028","Claudia","Diez", "beatriz "));
			repo.save(new Cliente("P074029","Maria","Diez", "beatriz entre "));

		};
	}
	
}