package com.curso.java.spring.boot.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.java.spring.boot.model.entities.Multa;
import com.curso.java.spring.boot.model.entities.MultaRepository;

@Configuration
public class ConfiguracionMultas {

	@Bean
	public CommandLineRunner iniciarBaseDeDatos(MultaRepository repo) {
		return args -> {
			repo.save(new Multa("1", "leve", 100));
			repo.save(new Multa("2", "moderada", 1000));
			repo.save(new Multa("3", "grave", 10000));
		};
	}
	
}
