package edu.tudai.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tudai.dao.jpa.JPADAOEstudiante;
import edu.tudai.dao.jpa.JPADAOFactory;
import edu.tudai.pojo.Carrera;
import edu.tudai.pojo.Estudiante;

@Path("/estudiantes")
public class EstudianteController {

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Estudiante> getEstudiantes() {
		return JPADAOFactory.getInstance().getDAOEstudiante().selectEstudiantes();
	}
	
	@GET
	@Path("/listarxresidencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Estudiante> getEstudiantesByResidencia(Carrera carrera, String residencia) {
		Collection<Estudiante> result = JPADAOFactory.getInstance().getDAOEstudiante().selectEstudiantesByResidencia(carrera,residencia);
		return result;
	}
	
	@GET
	@Path("/listarxresidencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Estudiante> getEstudiantesByGenero(String genero) {
		Collection<Estudiante> result = JPADAOFactory.getInstance().getDAOEstudiante().selectEstudiantesByGenero(genero);
		return result;
	}
	

	@GET
	@Path("/{nro_lu}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getEstudiante(@PathParam("nro_lu") int nro_lu) {
		Estudiante estudiante = JPADAOFactory.getInstance().getDAOEstudiante().getEstudiante(nro_lu);
		return estudiante;
	}

	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(Estudiante e) {
		JPADAOFactory.getInstance().getDAOEstudiante().insertEstudiante(e);
		return "El estudiante fue guardado con exito";
	}
}
