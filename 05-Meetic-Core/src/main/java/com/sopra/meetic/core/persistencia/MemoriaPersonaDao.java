package com.sopra.meetic.core.persistencia;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopra.meetic.entidades.Persona;

@Repository
public class MemoriaPersonaDao implements PersonaDao{

	private Map<Integer,Persona> tablaPersonas;
	
	private int nextPk = 0;
	
	@Autowired
	public MemoriaPersonaDao(Map<Integer, Persona> tablaPersonas) {
		super();
		this.tablaPersonas = tablaPersonas;
		
		inicializacion();
		
	}

	private void inicializacion() {
		save(new Persona("Juan", "Juan", "Juan", 24, 1.75f, "Masculino"));
		save(new Persona("Maria", "Maria", "Maria", 25, 1.70f, "Femenino"));
		save(new Persona("Laura", "Laura", "Laura", 34, 1.30f, "Femenino"));
		save(new Persona("Victor", "Victor", "Victor", 27, 1.85f, "Masculino"));
	}

	@Override
	public void save(Persona persona) {
		persona.setId(nextPk++);
		tablaPersonas.put(persona.getId(), persona);
	}

	@Override
	public Persona findById(int id) {
		return tablaPersonas.get(id);
	}

	@Override
	public Persona findByLogin(String login) {
		// Habria que implementar la busqueda
		throw new RuntimeException("Operacion No Implementada");
	}

	@Override
	public List<Persona> findAll() {
		return new LinkedList<>(tablaPersonas.values());
	}

}
