<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alteração do usuario ${user.name}</title>
</head>
<body>
	<h2>Alteração do usuario ${user.name}</h2>
	<form method="POST"
		action="${pageContext.request.contextPath}/edit">
		<input type="hidden" name="id" value="${user.id}">
		<p>Nome:</p>
		<p>
			<input type="text" name="name" value="${user.name}">
		</p>
		<p>Email:</p>
		<p>
			<input type="email" name="email" value="${user.email}">
		</p>
		<p>Senha:</p>
		<p>
			<input type="password" name="password" value="${user.password}">
		</p>
		<p>Telefone 1:</p>
		<p>
			<input type="text" name="phone1" value="${user.phone1}">
		</p>
		<p>Telefone 2:</p>
		<p>
			<input type="text" name="phone2" value="${user.phone2}">
		</p>
		<button type="submit">Salvar!</button>
	</form>
</body>
</html>