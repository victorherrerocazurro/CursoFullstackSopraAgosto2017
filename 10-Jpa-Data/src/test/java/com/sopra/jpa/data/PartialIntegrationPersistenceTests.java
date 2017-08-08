package com.sopra.jpa.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sopra.jpa.data.entidades.Usuario;
import com.sopra.jpa.data.servicio.Servicio;

//Esta clase de Test, realiza test de Integracion entre la capa de 
//Servicio, Persistencia y BD

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartialIntegrationPersistenceTests {

	@Autowired
	private Servicio sut;

	@Test
	public void conDatosDePruebaValidos() {

		// 1-Definicion de los datos de prueba

		// Datos de entorno -> Dependencias -> Las resuelve Spring
		
		// Datos de Entrada -> Parametros de ejecucion del método
		String nombre = "Victor";
		Usuario usuario = new Usuario(1, nombre);

		// Datos Esperados

		// 2-Ejecucion de la logica a probar
		List<Usuario> todos = sut.metodo(usuario);

		// 3-Validacion del Feedback
		assertEquals(1, todos.size());
		
		assertEquals(nombre, todos.get(0).getNombre());
	}
	
	@Test(expected=Exception.class)
	public void conDatosDePruebaErroneos() {

		// 1-Definicion de los datos de prueba

		// Datos de entorno -> Dependencias -> Las resuelve Spring
		
		// Datos de Entrada -> Parametros de ejecucion del método
		Usuario usuario = null; 
		// Datos Esperados

		// 2-Ejecucion de la logica a probar
		sut.metodo(usuario);

		// 3-Validacion del Feedback
	}

}
