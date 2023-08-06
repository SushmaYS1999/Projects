<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${data}</h1>
	<table border="1">
		<tr>
			<th>FIRST NAME:</th>
			<th>LAST NAME:</th>
			<th>STREET:</th>
			<th>ADDRESS:</th>
			<th>CITY:</th>
			<th>STATE:</th>
			<th>COUNTRY:</th>
			<th>EMAIL:</th>
			<th>PHONE:</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.firstname}</td>
				<td>${dto.lastname}</td>
				<td>${dto.street}</td>
				<td>${dto.address}</td>
				<td>${dto.city}</td>
				<td>${dto.state}</td>
				<td>${dto.country}</td>
				<td>${dto.email}</td>
				<td>${dto.phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>