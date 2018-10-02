package com.fdmgroup.loginpage.controller;

import javax.persistence.Persistence;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fdmgroup.loginpage.model.LoginDao;
import com.fdmgroup.loginpage.model.LoginLogger;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
public class LoginListener implements ServletContextListener {
	private LoginDao loginDao;
    /**
     * Default constructor. 
     */		
	
	
    public LoginListener() {
    	

    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	sce.getServletContext().removeAttribute("dao");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	
		loginDao = new LoginDao(Persistence.createEntityManagerFactory("loginPersistDao"));
		
    	sce.getServletContext().setAttribute("ldao", loginDao);
    	System.out.println(loginDao.toString());
    }
	
}
