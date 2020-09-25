package edu.tudai.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.tudai.dao.i.DAOFactory;
import edu.tudai.dao.i.DAODog;

public class JPADAOFactory extends DAOFactory {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public JPADAOFactory() {
		emf = Persistence.createEntityManagerFactory("RestDogs");
		em = emf.createEntityManager();
	}
	@Override
	public DAODog getDAODog() {
		// TODO Auto-generated method stub
		return new JPADAODog(em);
	}
}
