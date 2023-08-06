<%@page import="dto.Adto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="">
<tr>
<th>FIRST NAME:</th>
<th>LAST NAME:</th>
<th>ADDRESS:</th>
<th>CITY:</th>
<th>STATE:</th>
<th>EMAIL:</th>
<th>PHONE:</th>
<th>DELETE:</th>
<th>UPDATE:</th>
</tr>
<%List<Adto> d1=(List<Adto>)request.getAttribute("list");%>
<%for(Adto l1:d1){%>
<tr>
<td><%=l1.getFirst_name()%></td>
<td><%=l1.getLast_name()%></td>
<td><%=l1.getAddress()%></td>
<td><%=l1.getCity()%></td>
<td><%=l1.getState()%></td>
<td><%=l1.getEmail()%></td>
<td><%=l1.getPhone()%></td>
<td><a href="delete?id=<%=l1.getFirst_name()%>">DELETE</a></td>
<td><a href="update?id=<%=l1.getFirst_name()%>">UPDATE</a></td>
</tr>
<%} %>
</table>
</body>
</html>