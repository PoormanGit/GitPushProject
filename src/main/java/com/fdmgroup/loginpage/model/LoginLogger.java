package com.fdmgroup.loginpage.model;




import org.apache.log4j.*;

/**
 * 
 * Log4j logging file
 * 
 * @author thomas.poorman
 *
 */


public class LoginLogger {


	private static Logger allLog;
	private static Logger errorLog;
	
	
	
	static{
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	
	
	public static Logger getAllLogger(){
		if(allLog == null){
			allLog = Logger.getLogger("allLogger");
		}
		
		return allLog;
	}

	public static Logger getErrorLogger(){
		if(errorLog == null){
			errorLog = Logger.getLogger("errorLogger");
		}
		return errorLog;
	}
	
	
	
	
	
	
	
	
}
