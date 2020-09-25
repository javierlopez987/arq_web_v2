package edu.tudai.dao.i;

import edu.tudai.dao.jpa.JPADAOFactory;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int JPA = 2;

	public static DAOFactory getDAOFactory(int whichFactory) {
		DAOFactory daoFactory = null;
		
		switch (whichFactory) {
		case MYSQL:
			daoFactory = null;
			break;
		case JPA:
			daoFactory = new JPADAOFactory();
			break;
		default:
			daoFactory = null;
			break;
		}
		return daoFactory;
	}
	
	// Debe haber un método por cada DAO que puede ser creado
	public abstract DAODog getDAODog();
	
}
