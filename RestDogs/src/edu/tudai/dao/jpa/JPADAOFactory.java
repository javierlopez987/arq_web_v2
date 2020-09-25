package edu.tudai.dao.jpa;

import javax.persistence.EntityManager;
import edu.tudai.controller.EMF;
import edu.tudai.dao.i.DAOFactory;

public class JPADAOFactory implements DAOFactory {
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
	
	public DogDAO getDogDAO() {
		return DogDAO.getInstance(em);
	}

}
