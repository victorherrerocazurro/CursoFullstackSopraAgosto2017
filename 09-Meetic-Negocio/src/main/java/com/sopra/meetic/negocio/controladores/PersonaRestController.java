package com.sopra.meetic.negocio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.meetic.negocio.entidades.Persona;
import com.sopra.meetic.negocio.servicios.PersonaServicio;

@RestController
@RequestMapping(path="/Persona")
public class PersonaRestController {
	
	private PersonaServicio personaServicio;
	
	@Autowired
	public PersonaRestController(PersonaServicio personaServicio) {
		super();
		this.personaServicio = personaServicio;
	}

	@RequestMapping(method=RequestMethod.POST)
	public void registrar(@RequestBody Persona persona) {
		personaServicio.registrar(persona);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Persona> consultarPerfil (@PathVariable int id) {
		Persona persona = personaServicio.consultarPerfil(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Persona> consultarPerfil(@RequestParam String login) {
		Persona persona = personaServicio.consultarPerfil(login);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}/afines" ,method=RequestMethod.GET)
	public List<Persona> buscarAfines(@PathVariable int id){
		return personaServicio.buscarAfines(id);
	}
	
	@RequestMapping(path="/{id}/mediaNaranja" ,method=RequestMethod.GET)
	public Persona buscarMediaNaranja(@PathVariable int id){
		return personaServicio.buscarMediaNaranja(id);
	}
	
}










