package edu.tudai.dao.i;

import edu.tudai.dao.jpa.DogDAO;

public interface DAOFactory {
	
	// Debe haber un m�todo por cada DAO que puede ser creado
	DogDAO getDogDAO();
	
}
