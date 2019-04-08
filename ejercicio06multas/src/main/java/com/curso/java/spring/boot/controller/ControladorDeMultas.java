package com.curso.java.spring.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.java.spring.boot.model.entities.Multa;
import com.curso.java.spring.boot.model.entities.MultaRepository;

@RestController
public class ControladorDeMultas {

	private final MultaRepository repository;

	public ControladorDeMultas(MultaRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/multas")
	public List<Multa> multas(){
		return repository.findAll();
	}
	
	@GetMapping("/multas/{id}")
	public Multa multa(@PathVariable Integer id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	@PostMapping("/multas")
	public Multa nuevaMulta(@RequestBody Multa multa) {
		return repository.save(multa);
	}
	
	@DeleteMapping("/multas/{id}")
	public void borrarMulta(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	@PutMapping("/multas/{id}")
	public Multa actualizarMulta(@RequestBody Multa multa,@PathVariable Integer id) {
		return repository.findById(id)
			.map(c -> {
					c.setMatricula(multa.getMatricula());
					c.setCategoria(multa.getCategoria());
					c.setCantidad(multa.getCantidad());
					return repository.save(c);
				})
			.orElseGet(()->{
				multa.setId(id);
				return repository.save(multa);
			});
			
	}
}
