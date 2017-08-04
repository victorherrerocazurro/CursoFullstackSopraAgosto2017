package com.sopra.rest.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.rest.dto.Usuario;
import com.sopra.rest.servicios.BasicoUsuarioServicio;
import com.sopra.rest.servicios.UsuarioServicio;

@RestController
@RequestMapping(path="/api/Usuario")
public class UsuarioRestController {

	//No queremos acoplarnos con una implementacion concreta del servicio
	//private UsuarioServicio servicio = new BasicoUsuarioServicio();
	private UsuarioServicio servicio;

	@Autowired
	public UsuarioRestController(@Qualifier("basicoUsuarioServicio") UsuarioServicio servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping(
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Usuario usuario){
		
		int id = servicio.alta(usuario);
		
		System.out.println("ALTA de: " + usuario);
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.setLocation(new URI("http://localhost:8080/api/Usuario/" + id ));
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> consulta(@RequestParam(required=false) String nombre) {
		//El acceso a la logica de negocio que permite 
		//realizar el alta del usuario
		
		if(nombre != null) {
			//logica de filtrado por nombre
		} else {
			//logica de consultar todos 
		}
		
		List<Usuario> resultado = Arrays.asList(
							new Usuario[] {
									new Usuario(1, "Victor"),
									new Usuario(2, "Jose")
							});
		
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}
	
	@RequestMapping(
			path="/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> consulta(@PathVariable int id) {
		//El acceso a la logica de negocio que permite 
		//realizar el alta del usuario
		return new ResponseEntity<Usuario>(new Usuario(id, "Victor"), HttpStatus.OK);
	}
	
	@RequestMapping(
			path="/{id}/padre",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE //La cabecera Accept
			)
	public ResponseEntity<Usuario> consultaRelacionPadre(@PathVariable int id) {
		//El acceso a la logica de negocio que permite 
		//realizar el alta del usuario
		return new ResponseEntity<Usuario>(new Usuario(1, "Victor"), HttpStatus.OK);
	}
	
	@RequestMapping(
			method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> modificacion(@RequestBody Usuario usuario) {
		//El acceso a la logica de negocio que permite 
		//realizar el alta del usuario
		System.out.println("ACTUALIZACION de: " + usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			path="/{id}",
			method=RequestMethod.DELETE)
	public ResponseEntity<Void> borrado(@PathVariable int id) {
		//El acceso a la logica de negocio que permite 
		//realizar el alta del usuario
		System.out.println("BORRADO del Usuario con ID: " + id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			method=RequestMethod.DELETE)
	public ResponseEntity<Void> borrado(@RequestParam(required=true) String nombre) {
		//El acceso a la logica de negocio que permite 
		//realizar el alta del usuario
		System.out.println("BORRADO del Usuario con NOMBRE: " + nombre);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}