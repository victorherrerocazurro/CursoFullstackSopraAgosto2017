package com.sopra.meetic.negocio;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sopra.meetic.negocio.entidades.Persona;

@Component
public class BasicoReglas implements Reglas {

	@Override
	public List<Persona> dameLosAfinesDelQueBuscaDentroDeLosCandidatos(Persona elQueBusca, List<Persona> candidatos) {

		List<Persona> afines = new LinkedList<>();

		for (Persona candidato : candidatos) {
			if (!elQueBusca.equals(candidato) && Math.abs(elQueBusca.getEdad() - candidato.getEdad()) <= 10
					&& Math.abs(elQueBusca.getAltura() - candidato.getAltura()) <= 0.5) {
				afines.add(candidato);
			}
		}

		return afines;
	}

	@Override
	public Persona dameLaMediaNaranjaDelQueBuscaDentroDeLosCandidatos(Persona elQueBusca, List<Persona> candidatos) {
		for (Persona candidato : candidatos) {
			if (
					!elQueBusca.equals(candidato) && 
					!elQueBusca.getGenero().equals(candidato.getGenero()) &&
					Math.abs(elQueBusca.getEdad() - candidato.getEdad()) <= 5 && 
					Math.abs(elQueBusca.getAltura() - candidato.getAltura()) <= 0.1) {
				return candidato;
			}
		}
		
		return null;
	}

}
