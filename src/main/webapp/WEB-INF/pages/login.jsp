<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<link rel="stylesheet" href="css/style.css" ></link>


</head>
<body>
<div class="login-page">
<div class="form">  
<form action="/login" method="post" class="login-form">	
			<input type="text" name="username" placeholder="User Name">
			<input type="password" name="password" placeholder="password">
			<input type="submit" value="Login">
			<input type="reset" value="Reset">
			<p class="message"><a href="register" >Register</a>
		<p class="message">${param.register}</p>
		<c:if test="${!empty param.error}"><p class="message"><span>Invalid Credentials</span></p></c:if>
		<c:if test="${!empty param.logout}"><p class="message"><span>Logout Success</span></p></c:if>
		
</form>
</div>
</div>

</body>
</html>