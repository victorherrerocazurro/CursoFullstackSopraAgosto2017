package com.sopra.meetic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.meetic.interfaces.PersonDAOInterface;
import com.sopra.meetic.interfaces.RulesetDAOInterface;
import com.sopra.meetic.models.Person;
import com.sopra.meetic.utils.WrongUserDataException;


@Service
public class BasicPersonService implements PersonService{

	private PersonDAOInterface personDao;
	private RulesetDAOInterface rulesetInterface;
	
	@Autowired
	public BasicPersonService(PersonDAOInterface personInterface, RulesetDAOInterface rulesetInterface) {
		super();
		this.personDao = personInterface;
		this.rulesetInterface = rulesetInterface;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int alta(Person person) throws WrongUserDataException{
		if(badData(person)){
			throw new WrongUserDataException("Some fields seems to be null!");
		}
		else{
			personDao.save(person);
			return 0;
		}
	}
		
	/**
	 * Este método nunca puede retornar Null
	 */
	public List<Person> consulta() {		
		List<Person> resultado = personDao.findAll();
		
		if (resultado == null) {
			throw new RuntimeException();
		}
		
		return resultado;
	}
	
	public Person consulta(Integer id){
		return personDao.findById(id);
	}
	
	public Person consulta(String user){	
		return personDao.findByUser(user);
	}
		
	public List<Person> consultaAfines(Integer id){
		
		Person personLookingFor = this.consulta(id);
		List<Person> afines = personDao.findAll();
		return rulesetInterface.findAffinity(personLookingFor,afines);
	}
	
	public Person consultaMediaNaranja(Integer id){
		
		Person personLookingFor = consulta(id);
		List<Person> afines = personDao.findAll();
		return rulesetInterface.findTrueLove(personLookingFor,afines);
	}
	
	
	
	////////////////////////////
	
	private Boolean badData(Person p){
		return p.getUser().equals(null) || 
				p.getPassword().equals(null) ||
				p.getAge().equals(null) ||
				p.getGender().equals(null) ||
				p.getHeight().equals(null) ||
				p.getName().equals(null);
	}

}
