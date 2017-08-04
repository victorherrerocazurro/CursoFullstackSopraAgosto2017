package com.sopra.resttemplate.servicios;

import java.util.List;

import com.sopra.resttemplate.dto.Usuario;

public interface UsuarioServicio {

	int alta(Usuario usuario);

	List<Usuario> consulta(String nombre);

	Usuario consulta(int id);

	Usuario consultaRelacionPadre(int id);

	//Retorna el numero de recursos afectados por la modificacion
	int modificacion(Usuario usuario);

	//Retorna el numero de recursos afectados por el borrado
	int borrado(int id);

	//Retorna el numero de recursos afectados por el borrado
	int borrado(String nombre);

}