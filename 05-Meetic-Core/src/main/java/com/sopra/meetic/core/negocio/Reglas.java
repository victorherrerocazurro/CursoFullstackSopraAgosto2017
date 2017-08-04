package com.sopra.meetic.core.negocio;

import java.util.List;

import com.sopra.meetic.entidades.Persona;

public interface Reglas {

	List<Persona> dameLosAfinesDelQueBuscaDentroDeLosCandidatos(Persona elQueBusca, List<Persona> candidatos);

	Persona dameLaMediaNaranjaDelQueBuscaDentroDeLosCandidatos(Persona elQueBusca, List<Persona> candidatos);

}
