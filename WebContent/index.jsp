<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<link  rel="stylesheet" href="resources/css/estilo.css">
<body>

		<div class="login-page">
			<div class="form">
				<form action="login" method="POST" class="login-form">
					Login: <input type="email" id="login" name="email"> <br />
					Senha: <input type="password" id="senha" name="password"> <br />
					<button type="submit" value="Logar">Logar</button>
				</form>
			</div>
		</div>
		
</body>
</html>