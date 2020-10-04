package edu.tudai.dao.i;

import java.util.Collection;

import edu.tudai.pojo.Carrera;
import edu.tudai.pojo.Estudiante;

public interface DAOEstudiante {
	
	boolean insertEstudiante(Estudiante e);

	boolean deleteEstudiante(Estudiante e);

	Estudiante findEstudiante(int id);
	
	Estudiante getEstudiante(int nro_lu);
	
	Collection<Estudiante> selectEstudiantesByResidencia(Carrera carrera,String residencia);
	
	Collection<Estudiante> selectEstudiantesByGenero(String genero);

	boolean updateEstudiante(Estudiante e);

	Collection<Estudiante> selectEstudiantes();
}
