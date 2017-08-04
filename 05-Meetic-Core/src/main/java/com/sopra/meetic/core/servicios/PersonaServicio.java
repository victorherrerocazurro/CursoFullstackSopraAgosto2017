package com.sopra.meetic.core.servicios;

import java.util.List;

import com.sopra.meetic.entidades.Persona;

public interface PersonaServicio {

	void registrar(Persona persona);

	Persona consultarPerfil(int id);

	Persona consultarPerfil(String login);

	List<Persona> buscarAfines(int id);

	Persona buscarMediaNaranja(int id);

}