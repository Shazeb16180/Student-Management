<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here here</title>
<link rel="stylesheet" href="css/style.css"></link> 
</head>
<body>
<div class="login-page">
<div class="form">  

	<form action="register" method="post" class="login-form">
		<input type="text" name="username" placeholder="User Name">
			<input type="password" name="password" placeholder="password">
			<div>Role
			<input type="checkbox" name="role" value="ADMIN" >ADMIN<input
					type="checkbox" name="role" value="USER" >USER</div>
				<input type="submit" value="Register">
				<input type="reset" value="Reset">	
	</form>
	</div>
	</div>


</body>
</html>