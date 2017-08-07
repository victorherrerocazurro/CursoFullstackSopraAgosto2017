package com.sopra.meetic.persistencia.controladores;

import java.util.Collections;
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

import com.sopra.meetic.persistencia.PersonaDao;
import com.sopra.meetic.persistencia.entidades.Persona;

@RestController
@RequestMapping("/Persona")
public class PersonaDaoRestController {
	
	private PersonaDao personaDao;
	
	@Autowired
	public PersonaDaoRestController(PersonaDao personaDao) {
		super();
		this.personaDao = personaDao;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Persona persona) {
		
		personaDao.save(persona);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Persona> findById(@PathVariable int id) {
		
		Persona persona = personaDao.findById(id);
		
		return new ResponseEntity<>(persona, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Persona>> find(@RequestParam(required=false) String login) {
		
		if(login != null && login != "") {
			Persona persona = personaDao.findByLogin(login);
			return new ResponseEntity<>(
					Collections.singletonList(persona),
					HttpStatus.OK);
		} else {
			List<Persona> resultado = personaDao.findAll();
			return new ResponseEntity<>(resultado,HttpStatus.OK);
		}
		
		
	}
}
