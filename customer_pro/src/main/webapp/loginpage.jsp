<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login.jsp" onsubmit="return validatePassword()">
<label>Login ID:</label>
<input type="text" name="id" placeholder="Login ID"><br>
<label>Password:</label>
<input type="password" name="pswd" placeholder="Password"><br>
<button type="submit">Submit</button>
</form>
</body>
<script type="text/javascript">
function validatePassword(){
	var id=document.getElementById("id").value;
	var password=document.getElementById("pswd").value;
	
	 if (id!="test@sunbasedata.com" && password!="Test@123") {
	        alert("ID and Passwords do not match.");
	        return false;
	      }
	      return true;
}

</script>
</html>