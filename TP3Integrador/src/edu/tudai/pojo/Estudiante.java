package edu.tudai.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estudiante implements Comparable<Estudiante>{
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	@Column (nullable = false)
	private int dni;
	@Column
	private String residencia;
	@Column (nullable = false)
	private int nro_lu;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno")
	@JsonIgnore
	private List<Matricula> titulos;
	
	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellido, int edad, String genero, int dni,
			String residencia, int nro_lu) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.residencia = residencia;
		this.nro_lu = nro_lu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public int getNro_lu() {
		return nro_lu;
	}

	public void setNro_lu(int nro_lu) {
		this.nro_lu = nro_lu;
	}

	public int getId_estudiante() {
		return id;
	}
	
	public List<Matricula> getTitulos() {
		List<Matricula> copy = new ArrayList<Matricula>(titulos);
		return copy;
	}
	
	@Override
	public String toString() {
		return apellido + ", " + nombre + " [edad=" + edad + ", genero=" + genero + ", dni=" + dni + ", residencia=" + residencia + ", nro_lu="
				+ nro_lu + "]";
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
		Estudiante other = (Estudiante) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Estudiante o) {
		return this.apellido.compareTo(o.getApellido());
	}
	
	
}
