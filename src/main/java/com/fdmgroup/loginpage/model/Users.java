package com.fdmgroup.loginpage.model;

public interface Users {
	
	public abstract void registerUser(User user);
	
	public abstract User getUser(String username);

}
