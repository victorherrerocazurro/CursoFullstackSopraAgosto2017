package com.sopra.meetic;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.sopra.meetic.models.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class PersonaRestServiceIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void init() {

	}
	
	@Test
	public void altaPerson() throws RestClientException, URISyntaxException {
		//Datos de prueba
		HttpStatus StatusEsperado = HttpStatus.CREATED;
		Person person = new Person("user1","user1","Jeff",32,1.8,"Masculino");
		
		//Logica a probar
		ResponseEntity<Void> entity = restTemplate.withBasicAuth("user", "user").postForEntity(
				new URI("http://localhost:8080/api/people"), 
				person, 
				Void.class);
		
		//Validacion
		assertEquals(StatusEsperado, entity.getStatusCode());
	}
	
	@Test
	public void buscarPorLogin() throws RestClientException, URISyntaxException {
		//Datos de prueba
		HttpStatus StatusEsperado = HttpStatus.OK;
		String login = "user1";
		
		//Logica a probar
		ResponseEntity<Person[]> entities = restTemplate.withBasicAuth("user", "user").getForEntity(
				"http://localhost:8080/api/people?login=" + login, 
				Person[].class);
		
		//Validacion
		assertEquals(StatusEsperado, entities.getStatusCode());
		assertEquals(1, entities.getBody().length);
		assertEquals("Jeff", entities.getBody()[0].getName());
	}

}
