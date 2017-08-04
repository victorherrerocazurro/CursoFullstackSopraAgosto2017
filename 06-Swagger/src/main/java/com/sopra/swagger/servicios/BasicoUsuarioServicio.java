package com.sopra.swagger.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.swagger.dto.Usuario;

//Orquestacion de logicas de negocio
@Service("basicoUsuarioServicio")
public class BasicoUsuarioServicio implements UsuarioServicio {

	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#alta(com.sopra.rest.dto.Usuario)
	 */
	@Override
	public int alta(Usuario usuario){
		//1- Invoco la logica de persistencia que inserta el registro en la BD
		//2- Envio el correo electronico al usuario para indicarle que se ha registrado
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#consulta(java.lang.String)
	 */
	@Override
	public List<Usuario> consulta(String nombre) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#consulta(int)
	 */
	@Override
	public Usuario consulta(int id) {
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#consultaRelacionPadre(int)
	 */
	@Override
	public Usuario consultaRelacionPadre(int id) {
		return null;
	}
	
	//Retorna el numero de recursos afectados por la modificacion
	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#modificacion(com.sopra.rest.dto.Usuario)
	 */
	@Override
	public int modificacion(Usuario usuario) {
		return 0;
	}
	
	//Retorna el numero de recursos afectados por el borrado
	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#borrado(int)
	 */
	@Override
	public int borrado(int id) {
		return 0;
	}
	
	//Retorna el numero de recursos afectados por el borrado
	/* (non-Javadoc)
	 * @see com.sopra.rest.servicios.UsuarioServicio#borrado(java.lang.String)
	 */
	@Override
	public int borrado(String nombre) {
		return 0;
	}
}
