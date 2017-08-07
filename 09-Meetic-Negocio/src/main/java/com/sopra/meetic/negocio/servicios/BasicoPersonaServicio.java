package com.sopra.meetic.negocio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.meetic.negocio.Reglas;
import com.sopra.meetic.negocio.entidades.Persona;
import com.sopra.meetic.negocio.persistencia.PersonaDao;

@Service
public class BasicoPersonaServicio implements PersonaServicio {

	private PersonaDao personaDao;
	private Reglas reglas;
	
	@Autowired
	public BasicoPersonaServicio(PersonaDao personaDao, Reglas reglas) {
		super();
		this.personaDao = personaDao;
		this.reglas = reglas;
	}

	/* (non-Javadoc)
	 * @see com.sopra.meetic.core.servicios.PersonaServicio#registrar(com.sopra.meetic.entidades.Persona)
	 */
	@Override
	public void registrar(Persona persona) {
		personaDao.save(persona);
	}
	
	/* (non-Javadoc)
	 * @see com.sopra.meetic.core.servicios.PersonaServicio#consultarPerfil(int)
	 */
	@Override
	public Persona consultarPerfil (int id) {
		return personaDao.findById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.sopra.meetic.core.servicios.PersonaServicio#consultarPerfil(java.lang.String)
	 */
	@Override
	public Persona consultarPerfil(String login) {
		return personaDao.findByLogin(login);
	}
	
	/* (non-Javadoc)
	 * @see com.sopra.meetic.core.servicios.PersonaServicio#buscarAfines(int)
	 */
	@Override
	public List<Persona> buscarAfines(int id){
		
		Persona elQueBusca = consultarPerfil(id);
		List<Persona> candidatos = personaDao.findAll();
		
		return reglas.dameLosAfinesDelQueBuscaDentroDeLosCandidatos(elQueBusca, candidatos);
	}
	
	/* (non-Javadoc)
	 * @see com.sopra.meetic.core.servicios.PersonaServicio#buscarMediaNaranja(int)
	 */
	@Override
	public Persona buscarMediaNaranja(int id){
		
		Persona elQueBusca = consultarPerfil(id);
		List<Persona> candidatos = personaDao.findAll();
		
		return reglas.dameLaMediaNaranjaDelQueBuscaDentroDeLosCandidatos(elQueBusca, candidatos);
	}
	
}
