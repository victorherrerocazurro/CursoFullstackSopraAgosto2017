package com.sopra.jpa.data.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.jpa.data.entidades.Usuario;
import com.sopra.jpa.data.persistencia.UsuarioDao;

@Service
public class Servicio {

	private UsuarioDao usuarioDao;

	@Autowired
	public Servicio(UsuarioDao usuarioDao) {
		super();
		this.usuarioDao = usuarioDao;
	}
	
	public List<Usuario> metodo(Usuario usuario) {
		Usuario save = usuarioDao.save(usuario);
		
		System.out.println(save);
		
		List<Usuario> all = usuarioDao.findAll();
		
		System.out.println(all);
		
		Usuario one = usuarioDao.findOne(usuario.getId());
		
		if(one.getNombre().equals(usuario.getNombre())) {
			
		}
		
		System.out.println(one);
		
		List<Usuario> consultaPorNombre = usuarioDao.consultaPorNombre(usuario.getNombre());
		
		System.out.println(consultaPorNombre);
		
		return all;
	}
	
	
	
	
	
	
	
	
}
