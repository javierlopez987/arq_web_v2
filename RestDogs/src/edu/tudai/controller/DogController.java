package edu.tudai.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	public List<Dog> getDogs() {
		return IntStream.range(0, 20).mapToObj(i -> new Dog(i, "Name_" + i, "Breed_" + i, i))
				.collect(Collectors.toList());
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
	public String save(Dog u) {
		System.out.println("Guardando perro " + u);
		return "El perro fue guardado con exito";
	}
}
