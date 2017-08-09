package com.sopra.meetic.repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Repository;

import com.sopra.meetic.interfaces.RulesetDAOInterface;
import com.sopra.meetic.models.Person;

@Repository
public class RulesetRepository implements RulesetDAOInterface{

	@Override
	public List<Person> findAffinity(Person personLookingFor,
			List<Person> afines) {
		
		List<Person> result = new LinkedList<>();
		for(Person p:afines){
			if(Math.abs(p.getHeight()-personLookingFor.getHeight())<=0.5 
				&& (Math.abs(p.getAge()-personLookingFor.getAge())<=10)
				&& (!p.equals(personLookingFor)))
					result.add(p);
		}
		return result;
	}

	@Override
	public Person findTrueLove(Person personLookingFor, List<Person> afines) {
		
		List<Person> result = new ArrayList<Person>();
		for(Person p:afines){
			if(Math.abs(p.getHeight()-personLookingFor.getHeight())<=0.1 
				&& (Math.abs(p.getAge()-personLookingFor.getAge())<=5)
				&& (!p.getGender().equals(personLookingFor.getGender())
				&& (!p.equals(personLookingFor))))
					result.add(p);
		}
		Integer randomValue = ThreadLocalRandom.current().nextInt(0, result.size());
		return result.get(randomValue);
	}

}
