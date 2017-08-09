package com.sopra.meetic.services;

import java.util.List;

import com.sopra.meetic.models.Person;
import com.sopra.meetic.utils.WrongUserDataException;

public interface PersonService {

	public abstract int alta(Person person) throws WrongUserDataException;
	
	public abstract List<Person> consulta();

	public abstract Person consulta(Integer id);
	
	public abstract Person consulta(String user);

	public abstract List<Person> consultaAfines(Integer id);

	public abstract Person consultaMediaNaranja(Integer id);

}
