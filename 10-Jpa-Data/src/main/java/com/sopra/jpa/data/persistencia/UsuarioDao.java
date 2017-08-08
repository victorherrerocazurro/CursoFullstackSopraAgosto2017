package com.sopra.jpa.data.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.jpa.data.entidades.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	//Se traducea JPQL
	List<Usuario> findByNombre(String nombre);
	
	//Consulta en formato JPQL
	@Query("from Usuario u where u.nombre = :nombre")
	List<Usuario> consultaPorNombre(@Param("nombre") String nombre);
	
}
