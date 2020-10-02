package edu.tudai.dto;

import java.io.Serializable;

public class CarreraDTO implements Serializable{
	
	private int id;
	
	private String carrera;
	
	private int ciclo;
	
	private int inscriptos;
	
	private int egresados;

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(int inscriptos) {
		this.inscriptos = inscriptos;
	}

	public int getEgresados() {
		return egresados;
	}

	public void setEgresados(int egresados) {
		this.egresados = egresados;
	}

	public int getId() {
		return id;
	}
	
	
}
