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


@Path("/carreras")
public class CarreraController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Carrera> getCarreras() {
		return JPADAOFactory.getInstance().getDAOCarrera().selectCarreras();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Carrera getCarrera(@PathParam("id") int id) {
		Carrera carrera = JPADAOFactory.getInstance().getDAOCarrera().findCarrera(id);
		return carrera;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(Carrera c) {
		JPADAOFactory.getInstance().getDAOCarrera().insertCarrera(c);
		return "La carrera fue cargada con exito";
	}
	
}
