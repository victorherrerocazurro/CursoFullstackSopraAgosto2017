package com.sopra.meetic.persistencia.entidades;

public class Persona {

	private Integer id;//Destinado a ser autogenerado y es PK
	private String login;
	private String password;
	private String nombre;
	private Integer edad;
	private Float altura;
	private String genero;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	//La presencia de este constructor biene marcado por facilitar
	//la construccion de estos objetos para el desarrollador, por 
	//ejemplo en el proceso de registro
	public Persona(String login, String password, String nombre, Integer edad, Float altura,
			String genero) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.genero = genero;
	}
	//La presencia de esteconstructor biene marcado por su necesidad 
	//por parte de Hibernate
	public Persona() {
		super();
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", login=" + login + ", password=" + password + ", nombre=" + nombre + ", edad="
				+ edad + ", altura=" + altura + ", genero=" + genero + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
