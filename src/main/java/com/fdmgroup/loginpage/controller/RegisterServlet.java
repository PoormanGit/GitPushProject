package com.fdmgroup.loginpage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.loginpage.model.LoginDao;
import com.fdmgroup.loginpage.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private LoginDao loginDao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("registerUsername").trim();
		String pWord = request.getParameter("registerPassword").trim();
		String email = request.getParameter("registerEmailAddress").trim();
		String first = request.getParameter("registerFirstName").trim();
		String last = request.getParameter("registerLastName").trim();
		String confirm = request.getParameter("registerPasswordConfirm").trim();
		
		if(uName.isEmpty() || pWord.isEmpty() || email.isEmpty() || first.isEmpty() || last.isEmpty() || confirm.isEmpty()){
			request.setAttribute("passStatus", "Not all fields filled. Please try again.");

		}
		

		if(!uName.equals(uName.trim()) || !pWord.equals(pWord.trim()) || !email.equals(email.trim()) || !first.equals(first.trim()) || !last.equals(last.trim()) || !confirm.equals(pWord.trim()) || !confirm.equals(pWord.trim())){
			request.setAttribute("passStatus", "Invalid input. ");
		}
		
		else if(!loginDao.userExists(uName)){
			
			if(!pWord.equals(confirm)){
				request.setAttribute("passStatus", "Passwords do not match. Please try again.");
			}
			else{

				request.setAttribute("passStatus", "User Registered!");
				User user = new User();
				user.setFirstName(first);
				user.setLastName(last);
				user.setUserName(uName);
				user.setPassword(pWord);
				user.setEmailAddress(email);
				loginDao.registerUser(user);
			}
		}
		
		else{
			request.setAttribute("passStatus", "Username Already Registered. Please use a different Username.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("registrationPage");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);		
		loginDao = (LoginDao) config.getServletContext().getAttribute("ldao");
	}

}
