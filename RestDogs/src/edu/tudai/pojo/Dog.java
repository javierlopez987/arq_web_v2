package edu.tudai.pojo;

public class Dog {

	private int id;
	private String name;
	private String breed;
	private int age;
	
	public Dog() {
		super();
	}

	public Dog(int id, String name, String breed, int age) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}
	
	
}
