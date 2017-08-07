package com.sopra.meetic.negocio.persistencia;

import java.util.List;

import com.sopra.meetic.negocio.entidades.Persona;

public interface PersonaDao {

	void save(Persona persona);

	Persona findById(int id);

	Persona findByLogin(String login);

	List<Persona> findAll();

}
