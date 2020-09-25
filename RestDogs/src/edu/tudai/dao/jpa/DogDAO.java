package edu.tudai.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.tudai.pojo.Dog;

public class DogDAO {

	private static DogDAO instance;
	private EntityManager em;
	
	private DogDAO(EntityManager em) {
		this.em = em;
	}
	
	public static DogDAO getInstance(EntityManager em) {
		if(instance == null) {
			instance = new DogDAO(em);
		}
		
		return instance;
	}
	
	public boolean insert(Dog d) {
		boolean inserted;
		try {
			em.getTransaction().begin();
			em.persist(d);
			em.getTransaction().commit();
			inserted = true;
		} catch (Exception exc) {
			em.getTransaction().rollback();
			System.out.println(exc);
			inserted = false;
		}
		return inserted;
	}

	public boolean delete(Dog d) {
		boolean deleted;
		String jpql = "DELETE FROM Dog d WHERE d = ?1";
		
		try {
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter(1, d);
			query.executeUpdate();
			em.getTransaction().commit();
			deleted = true;
		} catch (Exception exc) {
			em.getTransaction().rollback();
			System.out.println(exc);
			deleted = false;
		}
		
		
		return deleted;
	}

	public Dog find(int id) {
		return em.find(Dog.class, id);
	}

	public boolean update(Dog d) {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<Dog> selectAll() {
		Collection<Dog> result = null;
		String jpql = "SELECT d FROM Dog d";
		
		try {
			TypedQuery<Dog> query = em.createQuery(jpql, Dog.class);
			result = query.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

}
