package com.fdmgroup.loginpage.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginDao implements Users {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("loginPersistDao");

	public void registerUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
	}

	public User getUser(String username) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM User e WHERE username = :username");
		q.setParameter("username", username);
		List<User> users = q.getResultList();
		return users.get(0);
	}
	
	public boolean userLoginExists(String username, String password){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM User e WHERE username = :username");
		q.setParameter("username", username);
		List<User> users = q.getResultList();		
		if(!users.isEmpty()){
			if(users.get(0).getUserName().equals(username) && users.get(0).getPassword().equals(password)){
				return true;
			}
			else{
			return false;
			}
			
		}
		return false;
	}

	public boolean userExists(String username){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM User e WHERE username = :username");
		q.setParameter("username", username);
		List<User> users = q.getResultList();		
		if(!users.isEmpty()){
			if(users.get(0).getUserName().equals(username)){
				return true;
			}
			else{
			return false;
			}
			
		}
		return false;
	}


	public LoginDao(EntityManagerFactory emf){
		super();
		this.emf = emf;
	}
	

	public LoginDao(){
		super();
	}
	
}
