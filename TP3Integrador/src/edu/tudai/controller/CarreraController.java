package edu.tudai.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.tudai.dao.jpa.JPADAOCarrera;
import edu.tudai.dao.jpa.JPADAOFactory;
import edu.tudai.dao.jpa.JPADAOMatricula;
import edu.tudai.dto.CarreraDTO;
import edu.tudai.pojo.Carrera;


@Path("/carreras")
public class CarreraController {

	
	@GET
	@Path("/reporte")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<CarreraDTO> getCarreraReport() { 
		List<Object[]> info = (List<Object[]>) ((JPADAOCarrera) JPADAOFactory.getInstance().getDAOCarrera()).selectCarrerasInscriptosPorAnio();

		Collection<CarreraDTO> resultado = new ArrayList<CarreraDTO>();
		CarreraDTO dto = null; 
		for(Object[] o: info) {	
			dto = new CarreraDTO();
			Carrera c = (Carrera) o[0];
			Long insc = (Long) o[1];
			Integer anio = (Integer) o[2];
			dto.setCarrera(c.getTitulo());
			dto.setCiclo(anio);
			dto.setInscriptos(insc.intValue());
			Integer egresos = ((JPADAOMatricula) JPADAOFactory.getInstance().getDAOMatricula()).selectNroEgresados(c, anio);
			if(egresos != 0) {
				dto.setEgresados(egresos);
			} else {
				dto.setEgresados(0);
			}
			resultado.add(dto);
		}
		return resultado;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Carrera> getCarreras() {
		return JPADAOFactory.getInstance().getDAOCarrera().selectCarreras();
	}
	
	@GET
	@Path("/coninscriptos")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<CarreraDTO> getCarrerasConInscriptos() {
		List<Object[]> info = (List<Object[]>) ((JPADAOCarrera) JPADAOFactory.getInstance().getDAOCarrera()).selectCarrerasConInscriptos();;
		Collection<CarreraDTO> resultado = new ArrayList<CarreraDTO>();
		CarreraDTO dto = null; 
		for(Object[] o: info) {
			dto = new CarreraDTO();
			Carrera c = (Carrera) o[0];
			Long insc = (Long) o[1];
			dto.setCarrera(c.getTitulo());
			dto.setInscriptos(insc.intValue());
			resultado.add(dto);
		}
		return resultado;
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
