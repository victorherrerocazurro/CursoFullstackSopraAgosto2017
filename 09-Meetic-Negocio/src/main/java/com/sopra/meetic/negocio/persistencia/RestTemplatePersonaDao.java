package com.sopra.meetic.negocio.persistencia;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sopra.meetic.negocio.entidades.Persona;

@Repository
public class RestTemplatePersonaDao implements PersonaDao {

	private RestTemplate restTemplate;

	@Autowired
	public RestTemplatePersonaDao(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public void save(Persona persona) {
		try {
			restTemplate.postForEntity(new URI("http://localhost:8080/Persona"), persona, Void.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Persona findById(int id) {
		try {
			return restTemplate.getForEntity(new URI("http://localhost:8080/Persona/" + id), Persona.class).getBody();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Persona findByLogin(String login) {

		return restTemplate.getForEntity(
					"http://localhost:8080/Persona?login=?", 
					Persona[].class,
					login
				).getBody()[0];

	}

	@Override
	public List<Persona> findAll() {
		
		return Arrays.asList(restTemplate.getForEntity(
				"http://localhost:8080/Persona", 
				Persona[].class
				).getBody());
	}

}
