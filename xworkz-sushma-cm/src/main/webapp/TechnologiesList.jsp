<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xworkz</title>
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
				<a href="index.jsp">home</a><br> <a href="SignUp.jsp">SignUp</a><br>
				<a href="SignIn.jsp">SignIn</a><br> <span style="color: white;">welcome:${userId}</span>
				<img src="download?fileName=${dtoPic}" height="50" width="80">

			</div>
	</nav>


	<main>
		<h1 style="color: navy;" align="center">Technology(s) List</h1>
		<h2>
			Name: <a style="color: gray;">${dto.userId}</a>
		</h2>
		<h2>
			Email: <a style="color: gray;">${dto.email}</a>
		</h2>
		<h2>
			Total no. of technologies: <a style="color: gray;">${dtos.size()}</a>
		</h2>
		<div class="container"></div>
		<table style="width: 100%" class="table table-striped">
			<thead>
				<tr>
					<th>TechName</th>
					<th>Language</th>
					<th>Version</th>
					<th>Owner</th>
					<th>SupportFrom</th>
					<th>SupportTo</th>
					<th>License</th>
					<th>OsType</th>
					<th>OpenSource</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dtos}" var="d">
					<tr>
						<td>${d.techName}</td>
						<td>${d.language}</td>
						<td>${d.version}</td>
						<td>${d.owner}</td>
						<td>${d.supportFrom}</td>
						<td>${d.supportTo}</td>
						<td>${d.license}</td>
						<td>${d.osType}</td>
						<td>${d.openSource}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>


	<!-- 	<script type="text/javascript">
		var pic = localStorage.getItem("pic");
		console.log("localStorage:" +pic);
		if(pic == null) {
			var profilePicUrl = "";
			document.getElementById("profilePic").src = profilePicUrl;
		}
		
		var ppic = document.getElementById("profilePic");
		console.log(ppic.src);
		ppic.src = "downloadPic?profilePic=" +pic;
		console.log(ppic.src);
		
		
		
		</script> -->
</body>
</html>
