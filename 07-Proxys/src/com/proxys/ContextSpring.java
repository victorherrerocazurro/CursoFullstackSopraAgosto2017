package com.proxys;

public class ContextSpring {

	public static Servicio getBean(Class<Servicio> class1) {
		
		return new ProxyServicio();
	}

}
