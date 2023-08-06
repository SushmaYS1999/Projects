<%@page import="dto.Adto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="merge">
<%Adto adto=(Adto)request.getAttribute("obj"); %>
FIRST NAME:<input type="text" name="first_name" value="<%=adto.getFirst_name()%>"><br><br>
LAST NAME:<input type="text" name="last_name" value="<%=adto.getLast_name()%>"><br><br>
STREET:<input type="text" name="street" value="<%=adto.getStreet()%>"><br><br>
ADDRESS:<input type="text" name="address" value="<%=adto.getAddress()%>"><br><br>
CITY:<input type="text" name="city" value="<%=adto.getCity()%>"><br><br>
STATE:<input type="text" name="state" value="<%=adto.getState()%>"><br><br>
EMAIL:<input type="text" name="email" value="<%=adto.getEmail()%>"><br><br>
PHONE:<input type="text" name="phone" value="<%=adto.getPhone()%>"><br><br>
<button type="submit">UPDATE</button>
</form>
</body>
</html>