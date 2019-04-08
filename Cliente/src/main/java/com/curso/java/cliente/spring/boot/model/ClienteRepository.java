package com.curso.java.cliente.spring.boot.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.cliente.spring.boot.model.entities.Cliente;

public interface ClienteRepository extends  JpaRepository<Cliente , String>{

	
}
