package edu.tudai.dao.jpa;

import javax.persistence.EntityManager;

import edu.tudai.dao.i.*;

public class JPADAOFactory extends DAOFactory{
	private static JPADAOFactory instance;
	private EntityManager em;
	
	private JPADAOFactory() {
		em = EMF.createEntityManager();
	}
	
	public static JPADAOFactory getInstance() {
		if(instance == null) {
			instance = new JPADAOFactory();
		}
		return instance;
	}
	
	@Override
	public DAOEstudiante getDAOEstudiante() {
		return new JPADAOEstudiante(em);
	}

	@Override
	public DAOCarrera getDAOCarrera() {
		return new JPADAOCarrera(em);
	}

	@Override
	public DAOMatricula getDAOMatricula() {
		return new JPADAOMatricula(em);
	}

}
