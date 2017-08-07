package com.sopra.meetic.persistencia;

import java.util.List;

import com.sopra.meetic.persistencia.entidades.Persona;

public interface PersonaDao {

	void save(Persona persona);

	Persona findById(int id);

	Persona findByLogin(String login);

	List<Persona> findAll();

}
