<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${ requestScope.passStatus }" />
	<form action="register" method="post">
		<input type="text" placeholder="New Username" name="registerUsername">
		<br>
		<input type="text" placeholder="New Password" name="registerPassword">
		<br>		
		<input type="text" placeholder="Confirm Password" name="registerPasswordConfirm">
		<br>		
		<input type="text" placeholder="First Name" name="registerFirstName">
		<br>		
		<input type="text" placeholder="Last Name" name="registerLastName">
		<br>		
		<input type="text" placeholder="Email Address" name="registerEmailAddress">
	
		<input type="submit" value="Submit">
		
	</form>

	<a href="main">Return to home...</a>
	<a href="loginPage" >Login...</a>
	
</body>
</html>