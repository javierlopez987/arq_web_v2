package edu.tudai.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.tudai.dao.jpa.JPADAOFactory;

@Entity
public class Carrera {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String titulo;
	@Column
	private String tipo;
	@Column
	private String unidad_academica;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cursada")
	@JsonIgnore
	private List<Matricula> matriculas;

	public Carrera() {
		super();
	}

	public Carrera(String titulo, String tipo, String unidad_academica) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.unidad_academica = unidad_academica;
	}

	public int getId_carrera() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnidad_academica() {
		return unidad_academica;
	}

	public void setUnidad_academica(String unidad_academica) {
		this.unidad_academica = unidad_academica;
	}

	public List<Matricula> getMatriculas() {
		List<Matricula> copy = new ArrayList<Matricula>(matriculas);
		return copy;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", unidad_academica="
				+ unidad_academica + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrera other = (Carrera) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
