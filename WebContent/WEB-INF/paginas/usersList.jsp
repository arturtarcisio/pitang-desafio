<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usu�rios...</title>
</head>
<body>
	<h3>Lista de usu�rios</h3>
	<p style="color: red;">${errorMessage}</p>
	<table border="1" cellpadding="5" cellspacing="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>				
				<th>Telefone 1</th>
				<th>Telefone 2</th>
				<th>A��es</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${usersList}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.phone1}</td>
					<td>${user.phone2}</td>
					<td>
						<a href="${pageContext.request.contextPath}/edit?id=${user.id}">Editar</a> | 
						<a href="${pageContext.request.contextPath}/delete?id=${user.id}">Excluir</a>												
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/insert">Criar novo usu�rio</a>
</body>
</html>