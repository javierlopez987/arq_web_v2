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
import edu.tudai.pojo.Dog;

@Path("/dogs")
public class DogController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Dog> getDogs() {
		return JPADAOFactory.getInstance().getDogDAO().selectAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Dog getDog(@PathParam("id") int id) {
		Dog dog = JPADAOFactory.getInstance().getDogDAO().find(id);
		return dog;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(Dog d) {
		JPADAOFactory.getInstance().getDogDAO().insert(d);
		return "El perro fue guardado con exito";
	}
}
