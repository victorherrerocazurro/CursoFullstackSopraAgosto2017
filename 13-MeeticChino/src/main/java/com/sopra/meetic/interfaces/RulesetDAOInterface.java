package com.sopra.meetic.interfaces;

import java.util.List;

import com.sopra.meetic.models.Person;



public interface RulesetDAOInterface {
	List<Person> findAffinity(Person personLookingFor, List<Person> afines);

	Person findTrueLove(Person personLookingFor, List<Person> afines);
}
