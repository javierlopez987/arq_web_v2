package edu.tudai.dao.i;

import java.util.Collection;

import edu.tudai.pojo.Estudiante;
import edu.tudai.pojo.Carrera;

public interface DAOCarrera {
	
	boolean insertCarrera(Carrera c);

	boolean deleteCarrera(Carrera c);

	Carrera findCarrera(int id);

	boolean updateCarrera(Carrera c);
	
	
	Collection<Carrera> selectCarreras();
	
	Collection<Carrera> selectCarreras(Estudiante e);
}
