package product_servlet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import product_servlet.dto.Product;

public class Productdao {
	//create the DB
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pratik");
		//to perform CRUD operation
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
			
	}
	//1-save C
	public void saveProduct(Product product) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		
		
	}

}
