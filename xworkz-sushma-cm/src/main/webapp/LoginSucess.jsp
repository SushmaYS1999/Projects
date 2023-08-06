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
							src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
							alt="" width="88" height="48">
						</a>
					</div>
					
				</nav>
			<div>
				<a href="index.jsp">Home</a><br>
				<a href="SignUp.jsp">SignUp</a><br>
				<a href="SignIn.jsp">SignIn</a><br>
				<span style="color: white;">welcome:${userId}</span>
				<img src="download?fileName=${dtoPic}" height="50" width="80">
				
			</div>		
		</nav>
			<div align="center"> 
		User Name:${userId}
		
		
	<h1 style="color: green;">LOGIN SUCESSFULLY</h1>
	<a href="profileUpdate.jsp">Update profile</a><br>
	<a href="addtechnology?signupId=${dto.signupId}">AddTechnology</a><br>
	<a href="listtechnology?signupId=${dto.signupId}">ListTechnology</a><br>
	Search<input type="search">
	</div>
</body>
</html>