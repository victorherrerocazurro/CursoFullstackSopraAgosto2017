package com.sopra.testing;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
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

import com.sopra.testing.dto.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws RestClientException, URISyntaxException {
		
		// 1-Definicion de los datos de prueba

		// Datos de entorno -> Dependencias -> Las resuelve Spring
		
		// Datos de Entrada -> Parametros de ejecucion del "método/peticion"
		Usuario usuario = new Usuario(1, "Victor");
		// Datos Esperados
		HttpStatus estadoEsperado = HttpStatus.CREATED;
		
		// 2-Ejecucion de la logica a probar
		ResponseEntity<Void> respuestaAlta = restTemplate.postForEntity(
				new URI("http://localhost:8080/api/Usuario"), 
				usuario, 
				Void.class);
		
		// 3-Validacion del Feedback
		Assert.assertEquals(estadoEsperado, respuestaAlta.getStatusCode());
	}
}
