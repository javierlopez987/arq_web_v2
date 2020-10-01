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
import edu.tudai.pojo.Carrera;
import edu.tudai.pojo.Matricula;

@Path("/matriculas")
public class MatriculaController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Matricula> getMatriculas() {
		return JPADAOFactory.getInstance().getDAOMatricula().selectMatriculas();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Matricula getMatricula(@PathParam("id") int id) {
		Matricula matricula = JPADAOFactory.getInstance().getDAOMatricula().findMatricula(id);
		return matricula;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(Matricula m) {
		JPADAOFactory.getInstance().getDAOMatricula().insertMatricula(m);
		return "La matricula fue cargada con exito";
	}
}
