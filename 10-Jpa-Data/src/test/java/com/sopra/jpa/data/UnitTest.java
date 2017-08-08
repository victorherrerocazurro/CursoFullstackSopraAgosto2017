package com.sopra.jpa.data;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sopra.jpa.data.entidades.Usuario;
import com.sopra.jpa.data.persistencia.UsuarioDao;
import com.sopra.jpa.data.servicio.Servicio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {

	private String nombre = "Victor";
	private Usuario usuario = new Usuario(1, nombre);

	@Autowired
	private Servicio sut;

	@MockBean
	private UsuarioDao usuarioDao;

	@Before
	public void init() {
		when(usuarioDao.save(usuario)).thenReturn(usuario);
		when(usuarioDao.findAll()).thenReturn(Collections.singletonList(usuario));
		when(usuarioDao.findOne(usuario.getId())).thenReturn(usuario);
	}

	@Test
	public void test() {
		// 2-Ejecucion de la logica a probar
		List<Usuario> todos = sut.metodo(usuario);

		// 3-Validacion del Feedback
		assertEquals(1, todos.size());

		assertEquals(nombre, todos.get(0).getNombre());
	}

}
