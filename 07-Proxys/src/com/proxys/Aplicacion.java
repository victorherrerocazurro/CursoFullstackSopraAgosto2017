package com.proxys;

public class Aplicacion {

	public static void main(String[] args) {
		
		new Servicio();
		
		Servicio servicio = ContextSpring.getBean(Servicio.class);
		
		servicio.metodo();
		
	}

}
