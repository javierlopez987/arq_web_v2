package edu.tudai.rest;

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

@Path("/usuarios")
public class UsuarioREST {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		return IntStream.
				range(0, 20).
				mapToObj(i -> new Usuario(i, "Name_"+i, "Lastname_"+i)).
				collect(Collectors.toList());
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id") int id) {
		return new Usuario(id, "Name_"+id, "Lastname_"+id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String save(Usuario u) {
		System.out.println("Guardando usuario " + u);
		return "El usuario fue guardado con exito";
	}
}
