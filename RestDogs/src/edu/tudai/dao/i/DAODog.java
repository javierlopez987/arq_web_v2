package edu.tudai.dao.i;

import java.util.Collection;

import edu.tudai.pojo.Dog;

public interface DAODog {
	
	boolean insert(Dog d);

	boolean delete(Dog d);

	Dog find(int id);

	boolean update(Dog d);

	Collection<Dog> selectAll();
}
