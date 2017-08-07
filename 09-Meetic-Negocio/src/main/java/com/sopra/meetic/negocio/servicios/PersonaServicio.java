package com.sopra.meetic.negocio.servicios;

import java.util.List;

import com.sopra.meetic.negocio.entidades.Persona;

public interface PersonaServicio {

	void registrar(Persona persona);

	Persona consultarPerfil(int id);

	Persona consultarPerfil(String login);

	List<Persona> buscarAfines(int id);

	Persona buscarMediaNaranja(int id);

}