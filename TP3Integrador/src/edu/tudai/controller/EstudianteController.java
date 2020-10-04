package edu.tudai.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.tudai.dao.jpa.JPADAOEstudiante;
import edu.tudai.dao.jpa.JPADAOFactory;
import edu.tudai.pojo.Carrera;
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
	public Estudiante getEstudiante(@PathParam("id") int id) {
		Estudiante estudiante = JPADAOFactory.getInstance().getDAOEstudiante().findEstudiante(id);
		return estudiante;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Estudiante e) {
		if(JPADAOFactory.getInstance().getDAOEstudiante().insertEstudiante(e)) {
			return Response.status(Response.Status.OK).build();			
		} else {
			return Response.status(Response.Status.NOT_MODIFIED).build();	
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Estudiante e) {
		JPADAOFactory.getInstance().getDAOEstudiante().updateEstudiante(e);
		return "El estudiante fue modificado con exito";
	}
	
	@GET
	@Path("/lu/{nro_lu}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getEstudianteByLu(@PathParam("nro_lu") int nro_lu) {
		Estudiante estudiante = JPADAOFactory.getInstance().getDAOEstudiante().getEstudiante(nro_lu);
		return estudiante;
	}
	
	@GET
	@Path("/genero/{genero}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Estudiante> getEstudiantesByGenero(@PathParam("genero") String genero) {
		Collection<Estudiante> result = JPADAOFactory.getInstance().getDAOEstudiante().selectEstudiantesByGenero(genero);
		return result;
	}
	
	@GET
	@Path("/{carreraId}/{residencia}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Estudiante> getEstudiantesByResidencia(@PathParam("carreraId") int carreraId, @PathParam("residencia") String residencia) {
		Carrera carrera = JPADAOFactory.getInstance().getDAOCarrera().findCarrera(carreraId);
		Collection<Estudiante> result = JPADAOFactory.getInstance().getDAOEstudiante().selectEstudiantesByResidencia(carrera,residencia);
		return result;
	}
}
