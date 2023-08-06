package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Adto;

public class Adao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(Adto adto) {
		entityTransaction.begin();
		entityManager.persist(adto);
		entityTransaction.commit();

	}

	public List<Adto> fetchall() {

		return entityManager.createQuery("select x from Adto x").getResultList();
	}

	public String delete(String id) {
		Adto d1 = entityManager.find(Adto.class, id);
		if (d1 != null) {
			entityTransaction.begin();
			entityManager.remove(d1);
			entityTransaction.commit();
			return "<h1>DATA DELETED SUCCESSFULLY....</h1>";
		} else
			return "DATA NOT FOUND IN DATABASE....";
	}

	public Adto fetchById(int id) {
		Adto d1=entityManager.find(Adto.class, id);
		return d1;
	}

	public void mergeData(Adto adto) {
		entityTransaction.begin();
		entityManager.merge(adto);
		entityTransaction.commit();
	}

}
