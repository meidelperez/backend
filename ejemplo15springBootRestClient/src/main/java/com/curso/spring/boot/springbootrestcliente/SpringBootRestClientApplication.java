package com.curso.spring.boot.springbootrestcliente;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.curso.java.cliente.spring.boot.model.entities.Cliente;

//@SpringBootApplication
public class SpringBootRestClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ClienteApplication.class, args);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Cliente[]> httpEntity = new HttpEntity<Cliente[]>(headers);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Cliente[]> response = template.exchange("http://localhost:8080/clientes", HttpMethod.GET,
				httpEntity, Cliente[].class);
		HttpStatus statusCode = response.getStatusCode();

		if (statusCode == HttpStatus.OK) {
			Cliente[] clientes = response.getBody();
			if (clientes != null) {
				for (Cliente cliente : clientes) {
					System.out.println(cliente.getNombre());
				}
			}
		}
	}

}
