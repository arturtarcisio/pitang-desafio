<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inclusão de Usuario</title>
</head>
<body>
	<h2>Inclusão de usuario</h2>
	<form method="post" action="${pageContext.request.contextPath}/insert">
		
		<p>Nome</p>
		<p><input type="text" name="name"></p>
		<p>Email</p>
		<p><input type="email" name="email"></p>
		<p>Senha</p>
		<p><input type="password" name="password"></p>
		<p>Telefone 1:</p>
		<p><input type="text" name="phone1" placeholder="DDD + numero"></p>		
		<p>Telefone 2:</p>
		<p><input type="text" name="phone2" placeholder="DDD + numero"></p>		
		
		<button type="submit">Salvar!</button>
	</form>

</body>
</html>