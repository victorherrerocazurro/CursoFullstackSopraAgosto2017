package com.sopra.meetic.interfaces;

import java.util.List;

import com.sopra.meetic.models.Person;


public interface PersonDAOInterface {
	void save(Person person);

	List<Person> findAll();

	Person findById(Integer id);

	Person findByUser(String user);
}
