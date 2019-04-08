package com.curso.java.cliente.spring.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.java.cliente.spring.boot.model.ClienteRepository;
import com.curso.java.cliente.spring.boot.model.entities.Cliente;

@RestController
public class ControladorDeClientes {
	
	private final ClienteRepository repository;

	public ClienteRepository getRepository() {
		return repository;
	}

	public ControladorDeClientes(ClienteRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/clientes")
	public List<Cliente> clientes(){
		return repository.findAll();
	}
	
	@GetMapping("/clientes/{matricula}")
	public Cliente cliente(@PathVariable String matricula) {
		return repository.findById(matricula)
				.orElse(null);
	}
	
	@PostMapping("/clientes")
	public Cliente nuevoCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@DeleteMapping("/clientes/{matricula}")
	public void borrarCliente(@PathVariable String matricula) {
		repository.deleteById(matricula);
	}
	@PutMapping("/clientes/{matricula}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable String matricula) {
		return repository.findById(matricula)
			.map(c -> {
					c.setNombre(cliente.getNombre());
					c.setDireccion(cliente.getDireccion());
					return repository.save(c);
				})
			.orElseGet(()->{
				cliente.setDireccion(matricula);
				return repository.save(cliente);
});


}
}
