package com.sopra.meetic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sopra.meetic.models.Person;



@Configuration
public class PersistenceConfiguration {
	
	@Bean
	public Map<Integer,Person> personTable(){
		return new HashMap<Integer,Person>();
	}
}
