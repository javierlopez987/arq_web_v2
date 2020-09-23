package edu.tudai.rest;

public class Usuario {
	
	private int id;
	private String name;
	private String lastname;
	
	public Usuario() {
		
	}

	public Usuario(int id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}

}
