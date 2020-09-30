package edu.tudai.controller;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tudai.dao.jpa.JPADAOFactory;
import edu.tudai.pojo.Estudiante;

@Path("/estudiantes")
public class EstudianteController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Estudiante> getEstudiantes() {
		return JPADAOFactory.getInstance().getDAOEstudiante().selectEstudiantes();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getDog(@PathParam("id") int id) {
		Estudiante estudiante = JPADAOFactory.getInstance().getDAOEstudiante().findEstudiante(id);
		return estudiante;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(Estudiante e) {
		JPADAOFactory.getInstance().getDAOEstudiante().insertEstudiante(e);
		return "El estudiante fue guardado con exito";
	}
}
