package com.sopra.meetic.persistencia.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sopra.meetic.persistencia.entidades.Persona;

@Configuration
public class ConfiguracionPersistencia {

	@Bean
	public Map<Integer, Persona> tablaPersonas(){
		return new HashMap<>();
	}
	
}
