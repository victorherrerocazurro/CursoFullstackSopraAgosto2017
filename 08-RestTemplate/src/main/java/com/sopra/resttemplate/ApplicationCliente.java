package com.sopra.resttemplate;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sopra.resttemplate.dto.Usuario;

public class ApplicationCliente {

	public static void main(String[] args) throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//Alta de un usuario
		
		Usuario usuario = new Usuario(1, "Victor");
		
		ResponseEntity<Void> respuestaAlta = restTemplate.postForEntity(
				new URI("http://localhost:8080/api/Usuario"), 
				usuario, 
				Void.class);
		
		System.out.println("Codigo de Respuesta: " 
								+ respuestaAlta.getStatusCode());
		
		System.out.println("Location: " 
								+ respuestaAlta.getHeaders().getLocation());
		
		ResponseEntity<Usuario> usuario2 = restTemplate.getForEntity(respuestaAlta.getHeaders().getLocation(), Usuario.class);
		
		System.out.println("Usuario: " + usuario2.getBody());
		
	}
}









