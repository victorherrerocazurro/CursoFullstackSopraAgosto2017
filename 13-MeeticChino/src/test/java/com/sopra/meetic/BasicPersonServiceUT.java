package com.sopra.meetic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Java6AbstractBDDSoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sopra.meetic.interfaces.PersonDAOInterface;
import com.sopra.meetic.interfaces.RulesetDAOInterface;
import com.sopra.meetic.models.Person;
import com.sopra.meetic.services.BasicPersonService;
import com.sopra.meetic.services.PersonService;
import com.sopra.meetic.utils.WrongUserDataException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicPersonServiceUT {
	
	@Autowired
	private BasicPersonService sut;
	
	@MockBean
	private PersonDAOInterface personDao;
	
	@MockBean 
	private RulesetDAOInterface rulesetDao;
	
	@Before
	public void init() {
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////
//Test del comportamiento deseado de las funcionalidades
///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testFindAllCorrecto() {
		
		//Datos de prueba
		int sizeEsperado = 0;
		when(personDao.findAll()).thenReturn(Collections.emptyList());
		
		//Logica a probar
		List<Person> result = sut.consulta();
		
		//Validacion
		assertEquals(sizeEsperado,result.size());
	}
	
	@Test
	public void testAffinityPerson(){
		//Dato de prueba de entrada
		int id = 0;
		//comportamientos del entorno
		when(personDao.findAll()).thenReturn(Collections.emptyList());
		when(rulesetDao.findAffinity(any(Person.class), Collections.emptyList())).thenReturn(Collections.emptyList());

		List<Person> result = sut.consultaAfines(id);
		
		assertEquals(0,result.size());
	}
	
	/*
	@Test
	public void testFindOne(){
		Person result = sut.consulta(0);
		
		assertEquals("Jeff",result.getName());
	}
	
	@Test
	public void testFindByUser(){
		Person result = sut.consulta("user3");
		
		assertEquals("Britta",result.getName());
	}
	
	@Test
	public void testAddPerson() throws WrongUserDataException{
		Person newPerson = new Person("newUser","newUser","Kung Fury",27,1.60,"Hombre");
		sut.alta(newPerson);
		List<Person> result = sut.consulta();
		Person result2 = sut.consulta(10);
		
		assertEquals(11,result.size());
		assertEquals("Kung Fury",result2.getName());
		
	}
	
	
	
	@Test
	public void testPerfectMatch(){
		Person testSubject = sut.consulta("user1");
		//{id=0, user=user1, password=user1, name=Jeff, age=32, height=1.8, gender=Hombre}
		Person result = sut.consultaMediaNaranja(testSubject.getId());

		
		assertEquals("Britta",result.getName());
	}*/
	
///////////////////////////////////////////////////////////////////////////////////////////////
//Test de comportamientos anomalos del entorno
///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test(expected=Exception.class)
	public void testFindAllConExcepcionEnElDao() {
		
		when(personDao.findAll()).thenThrow(Exception.class);
		
		List<Person> result = sut.consulta();
	}
	
	@Test(expected=Exception.class)
	public void testFindAllConNullEnElDao() {
		
		when(personDao.findAll()).thenReturn(null);
		
		List<Person> result = sut.consulta();
		
		assertNotEquals(null, result);
	}
	
	
	
	
	/*
	@Test(expected=NullPointerException.class)
	public void testFindOneError(){
		Person result = sut.consulta(999);
		
		assertEquals("Jeff",result.getName());
	}
	
	@Test(expected=NullPointerException.class)
	public void testFindByUserError(){
		Person result = sut.consulta("Pincho de tortilla");
		
		assertEquals("Britta",result.getName());
	}
	
	@Test(expected=WrongUserDataException.class)
	public void testAddPersonError() throws WrongUserDataException{
		Person newPerson = new Person(null,null,null,null,null,null);
		sut.alta(newPerson);
		
	}*/

}
