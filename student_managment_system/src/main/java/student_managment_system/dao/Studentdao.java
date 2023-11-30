package student_managment_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student_managment_system.dto.Student;

public class Studentdao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pratik");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//1-save
	public Student savestudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
		
	}
	//login
	public Student loginstudent(String email) {
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select s from Student s where s.email=?1");
		query.setParameter(1, email);
		 Student student=(Student) query.getSingleResult();
		return student;
	}
	public List<Student> getallStudent(){
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select a from Student a");
		List<Student>list=query.getResultList();
		return list;
	}
	public boolean deletestudent(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student= entityManager.find(Student.class,id);
		if (student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
			
		} else {
			return false;
		}
	}
	public Student updateStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	public Student getstudentbyid(int id) {
		EntityManager entityManager=getEntityManager();
		Student student= entityManager.find(Student.class,id);
		return student;
	}

}
