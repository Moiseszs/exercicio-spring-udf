<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funcionarios e seus Dependentes</title>
</head>
<body>
	<table>
		<tr>
			<th>Funcionario</th>
			<th>Dependente</th>
			<th>Salario do Dependente</th>
			<th>Salario do Funcionario</th>
		</tr>
		
		<c:forEach var="dependente" items="${funcionario.getDependentes() }">
			<tr>
			<td><c:out value="${funcionario.nome }"></c:out>
			<td><c:out value="${dependente.nome }"></c:out>
			<td><c:out value="${dependente.salario }"></c:out>
			</td>
		</c:forEach>
	</table>
</body>
</html>