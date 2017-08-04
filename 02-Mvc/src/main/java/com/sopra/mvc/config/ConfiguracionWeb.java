package com.sopra.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ConfiguracionWeb implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webApplicationContext 
						= new AnnotationConfigWebApplicationContext();
		
		//webApplicationContext.scan(this.getClass().getPackage().getName());
		webApplicationContext.scan("com.sopra.mvc.config");
		
		Dynamic dispatcherServlet = servletContext
				.addServlet(
						"dispatcherServlet", 
						new DispatcherServlet(webApplicationContext));
		
		//Mapeabamos el servlet con el path generico
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
		
	}

}
