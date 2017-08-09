package com.sopra.meetic.models;



public class Person {
	private Integer id;
	private String user;
	private String password;
	private String name;
	private Integer age;
	private Double height;
	private String gender;
	

	public Person() {
		super();
	}
	public Person(String user, String password, String name,
			Integer age, Double height, String gender) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", user=" + user + ", password="
				+ password + ", name=" + name + ", age=" + age + ", height="
				+ height + ", gender=" + gender + "]";
	}
	
	
}
