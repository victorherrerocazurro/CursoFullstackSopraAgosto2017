package com.sopra.meetic.negocio;

import java.util.List;

import com.sopra.meetic.negocio.entidades.Persona;

public interface Reglas {

	List<Persona> dameLosAfinesDelQueBuscaDentroDeLosCandidatos(Persona elQueBusca, List<Persona> candidatos);

	Persona dameLaMediaNaranjaDelQueBuscaDentroDeLosCandidatos(Persona elQueBusca, List<Persona> candidatos);

}
