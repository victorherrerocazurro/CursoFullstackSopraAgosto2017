package com.sopra.meetic.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sopra.meetic.interfaces.PersonDAOInterface;
import com.sopra.meetic.models.Person;

@Repository
public class PersonRepository implements PersonDAOInterface{
	Map<Integer,Person> personDatabase;
	private int nextPk =0;
	
	public PersonRepository(Map<Integer,Person> personDatabase){
		super();
		this.personDatabase = personDatabase;
		
		inicializacion();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void inicializacion(){
		save(new Person("user1","user1","Jeff",32,1.80,"Hombre"));
		save(new Person("user2","user2","Annie",24,1.55,"Mujer"));
		save(new Person("user3","user3","Britta",28,1.72,"Mujer"));
		save(new Person("user4","user4","Troy",26,1.75,"Hombre"));
		save(new Person("user5","user5","Pierce",78,1.65,"Hombre"));
		save(new Person("user6","user6","Chloe",21,1.70,"Mujer"));
		save(new Person("user7","user7","Max",21,1.65,"Mujer"));
		save(new Person("user8","user8","Corbec",34,1.82,"Hombre"));
		save(new Person("user9","user9","Paracelso",76,1.59,"Hombre"));
		save(new Person("user10","user10","Hackerman",24,1.60,"Hombre"));
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void save(Person person) {
		person.setId(nextPk++);
		personDatabase.put(person.getId(), person);	
	}

	@Override
	public List<Person> findAll() {
		return new ArrayList(personDatabase.values());
	}

	@Override
	public Person findById(Integer id) {
		return personDatabase.get(id);
	}

	@Override
	public Person findByUser(String user) {
		Person result = null;
		for(Person p:personDatabase.values()){
			if(p.getUser().equals(user)) result = p;
		}
		return result;
	}
}
