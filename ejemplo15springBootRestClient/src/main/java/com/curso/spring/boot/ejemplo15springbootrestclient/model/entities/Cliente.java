package com.curso.spring.boot.ejemplo15springbootrestclient.model.entities;


public class Cliente {
	
	private Integer id;
	private String nombre;
	private Integer valor;
	
	
	public Cliente(String nombre, Integer valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public Cliente() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
