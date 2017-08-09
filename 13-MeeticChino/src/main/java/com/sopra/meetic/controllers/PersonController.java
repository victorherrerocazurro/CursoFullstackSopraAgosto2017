package com.sopra.meetic.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.meetic.models.Person;
import com.sopra.meetic.services.PersonService;
import com.sopra.meetic.utils.WrongUserDataException;

@RestController
@RequestMapping("/api/people")
public class PersonController {
	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService){
		super();
		this.personService = personService;
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	//Guardado de persona
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Person person){
		Person newPerson = new Person();
		
		newPerson.setUser(person.getUser());
		newPerson.setPassword(person.getPassword());
		newPerson.setName(person.getName());
		newPerson.setHeight(person.getHeight());
		newPerson.setGender(person.getGender());
		newPerson.setAge(person.getAge());
		
		try {
			personService.alta(newPerson);
		} catch (WrongUserDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	//Consultas
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> consulta(@RequestParam(required=false) String login) {

		List<Person> result = null;
		
		if(login != null || !login.equals("")) {
			Person person = personService.consulta(login);
			result = Collections.singletonList(person);
		} else {
			result = personService.consulta();
		}		
		return new ResponseEntity<List<Person>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> consulta(@PathVariable Integer id){
		Person result = new Person();
		
		result = personService.consulta(id);
		
		return new ResponseEntity<Person>(result, HttpStatus.OK);
	}
	

///////////////////////////////////////////////////////////////////////////////
	
	//Consultar relaciones
	
	@RequestMapping(path="/{id}/afines",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> consultaAfines(@PathVariable Integer id){
		List<Person> result = new ArrayList<Person>();
		
		result = personService.consultaAfines(id);
		
		return new ResponseEntity<List<Person>>(result,HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}/mednar", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> consultaMediaNaranja(@PathVariable Integer id){
		Person result = new Person();
		
		result = personService.consultaMediaNaranja(id);
		
		return new ResponseEntity<Person>(result,HttpStatus.OK);
	}
}
