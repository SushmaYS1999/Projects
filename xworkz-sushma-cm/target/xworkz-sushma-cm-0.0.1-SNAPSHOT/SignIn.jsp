<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<div class="container-fluid">
				<nav class="navbar navbar-light bg-light">
					<div class="container">
						<a class="navbar-brand" href="#"> <img
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmA1eBxtqpZSrUECdRXqK1TpV0bHmUXGkOiR9Mtr7aKFkbSzcROt-TNMLBK-XlaOIJSFw&usqp=CAU"
							alt="" width="88" height="48">
						</a>
					</div>
					
				</nav>
			<div>
				<a href="index.jsp">Home</a><br>
				<a href="SignUp.jsp">SignUp</a><br>
				<a href="SignIn.jsp">SignIn</a><br>
				
			</div>		
		</nav>
			<div align="center"> 
		<h5 style="color: red;">${match}</h5>
		<form action="signin" method="post">
			<table>
				<tr>
					<td>User ID</td>
					
					<td><input type="text" name="userId" id="userName" onchange="ValidateName()">
							<span id="nameError" style="color: red;"></span>
							<span id="displayUserName" style="color: red;"></span>				
					</td>
					</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="userPassword" onblur="validatePassword()">
						<span id="passwordError" style="color: red;"></span>
						<input type="checkbox" onclick="myFunction()">Show password
					</td>
					</tr>
			</table>
			<div>
			<button type="submit">SignIn</button>
			</div>
		</form>
		<a href="SignUp.jsp">Register as new user</a>
		
		</div>
	<script>
	function ValidateName() {
		var user = document.getElementById('userName');
		var uservalue = user.value;
		console.log(uservalue);
		if(uservalue != null && uservalue !="" && uservalue.length > 3 && uservalue.length < 30)
		{
			console.log('validate name');
			document.getElementById('nameError').innerHTML = '';
		}
		else {
			console.log('invalidate name');
			document.getElementById('nameError').innerHTML = 'Please enter valid name min 4 and max 29 chars';
		}
	}
		function myFunction() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		</script>
		</body>
		</html>
		