package edu.tudai.dao.jpa;

import java.io.Closeable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.tudai.dao.i.DAOFactory;

public class JPADAOFactory implements DAOFactory, Closeable {
	private static JPADAOFactory instance;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private JPADAOFactory() {
		emf = Persistence.createEntityManagerFactory("RestDogs");
		em = emf.createEntityManager();
	}
	
	public static JPADAOFactory getInstance() {
		if(instance == null) {
			instance = new JPADAOFactory();
		}
		return instance;
	}
	
	public DogDAO getDogDAO() {
		return DogDAO.getInstance(em);
	}

	@Override
	public void close() {
		emf.close();
		instance = null;
	}
}
