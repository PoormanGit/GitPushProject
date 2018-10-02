package com.fdmgroup.loginpage.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.fdmgroup.loginpage.model.LoginDao;



/**
 * Servlet Filter implementation class LoginAuthenticationFilter
 */
public class LoginAuthenticationFilter implements Filter {	
	private LoginDao login;


    /**
     * Default constructor. 
     */
    public LoginAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uName = request.getParameter("loginusername");
		String pWord = request.getParameter("loginpassword");

		if(login.userLoginExists(uName, pWord) && !uName.trim().isEmpty() && !pWord.trim().isEmpty()){
			
			request.setAttribute("logincon", "Welcome!");
			request.setAttribute("log", "Log Out");
			
		}
		
		else{

			request.setAttribute("logincon", "Unable to Login." );
			request.setAttribute("log", "Log In");
		}

		chain.doFilter(request, response);
		
		
		
		RequestDispatcher requestD = request.getRequestDispatcher("loginPage");
		requestD.forward(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String con = fConfig.getInitParameter("log");
		
		login = (LoginDao) fConfig.getServletContext().getAttribute("ldao");
	}

}
