<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>

	fieldset{
			width: 250px;
            margin: 50px auto;
            font-family: sans-serif;
            margin-top: 10px;
            display: block;
	}

</style>
<body>

	<form action="login" method="POST">
		<fieldset>
		<legend>Login</legend>
		<label for="login">Email:</label> 
		<input type="email" id="login" name="email"> 
		<label for="senha">Senha:</label> 
		<input type="password" id="senha" name="password"> 
		<input type="submit" value="Enviar">
	 	</fieldset>
	</form>
	
</body>
</html>