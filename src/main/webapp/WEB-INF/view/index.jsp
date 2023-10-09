<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulte Informações</title>
</head>
<body>
	<h2>Soma dos salarios dos Dependentes + Funcionario</h2>
	<form action="soma" method="POST">
		<label>Funcionario</label>
		<select name="codigo">
			<c:forEach var="funcionario" items="${funcionarios }">
				<option value="${funcionario.codigo }">
					<c:out value="${funcionario.nome }"></c:out>
				</option>
			</c:forEach>
		</select>
		<input type="submit" />
	</form>
	
	<h2>Relacao de Funcionarios e Dependentes</h2>
	
	<form action="relacao" method="POST">
		<label>Funcionario</label>
		<select name="codigo">
			<c:forEach var="funcionario" items="${funcionarios }">
				<option value="${funcionario.codigo }">
					<c:out value="${funcionario.nome }"></c:out>
				</option>
			</c:forEach>
		</select>
		<input type="submit" />
	</form>
</body>
</html>