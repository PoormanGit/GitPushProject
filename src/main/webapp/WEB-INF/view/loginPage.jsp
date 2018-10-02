<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${requestScope.logincon}" />
	<form action="login" method="post">
		<input type="text" placeholder="Username" name="loginusername" />
		<br>
		<input type="text" placeholder="Password" name="loginpassword" />
		<br>
		<input type="submit" value="${requestScope.log}" />
	</form>
	
	<a href="main">Return to home...</a>
	
	
	
	
	<a href="registrationPage">Register New User...</a>
	
</body>
</html>