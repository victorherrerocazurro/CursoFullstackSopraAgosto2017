package com.sopra.mvc.dto;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Usuario() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}
}
