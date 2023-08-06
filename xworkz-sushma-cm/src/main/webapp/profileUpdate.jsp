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
			<form action="upload" method="post" enctype="multipart/form-data">
			
			<table>
				<tr>
					
					
					<tr>
					<td>Email</td> 
					<td><input type="email" name="email" id="emailId" 
						onchange="validateEmail()" value="${dto.email}" readonly="readonly"> 
						<span id="emailError" style="color: red"></span>
						<span id="display" style="color: red"></span>
					</td>
					</tr>
					<tr>
					<td>User ID</td>
					
					<td><input type="text" name="userId" id="userName" onchange="ValidateName()" value="${dto.userId}">
							<span id="nameError" style="color: red;"></span>
							<span id="displayUserName" style="color: red;"></span>				
					</td>
					</tr>
					
					<tr>
					<td>Mobile</td>
					<td><input type="number" name="mobile" id="userMobile"
						onchange="validateMobile()" value="${dto.mobile}"> <span id="mobileError"
						style="color: red"></span>
						<span id="displayUserMobile" style="color: red"></span>
						</td>
					</tr>
					</table>
					
					Set Profie pic: <input type="file" name="sushma">
					 <div> <button type="submit" class="btn btn-success">Update</button> </div>
					 </form>
			</div>
			<script>
			
			function ValidateName() {
				var user = document.getElementById('userName');
				var uservalue = user.value;
				console.log(uservalue);
				if(uservalue != null && uservalue !="" && uservalue.length > 3 && uservalue.length < 30)
				{
					console.log("valide name");
				const xhttp = new XMLHttpRequest();
				console.log("Running in ajax");
				console.log(user);
				console.log(uservalue);
				xhttp.open("GET","http://localhost:8888/xworkz-sushma-cm/userName/" +uservalue);
				xhttp.send();
				
				xhttp.onload = function () {
					console.log(this);
					document.getElementById("displayUserName").innerHTML = this.responseText
					
				}
				
				var agree = document.getElementById("agreementConfirm");
				console.log(agree.checked);
				
				document.getElementById('nameError').innerHTML = '';
				} else {
					console.log('invalid name');
					document.getElementById('submitId').disabled='disabled';
					document.getElementById('nameError').innerHTML = 'please enter valid name min 4 and max 30 character';
				}
				
			}
			
			function validateEmail() {
				var userEmail=document.getElementById('emailId');
				var userEmailvalue = userEmail.value; 
				console.log(userEmailvalue);
				if(userEmailvalue != null && userEmailvalue !="" && userEmailvalue.length > 4 && userEmailvalue.length < 40)
				{
					console.log('validate email');
					const xhttp = new XMLHttpRequest();
					console.log("Running in ajax");
					console.log(userEmailvalue);
					xhttp.open("GET","http://localhost:8888/xworkz-sushma-cm/userName/" +userEmailvalue);
					xhttp.send();
					
					xhttp.onload = function () {
						console.log(this);
						document.getElementById("display").innerHTML = this.responseText
						
					}
					
					
					document.getElementById('emailError').innerHTML = '';
					} else {
						console.log('invalid email');
						document.getElementById('emailError').innerHTML = 'please enter valid email min 4 and max 40 character';
					}
					
				}
		
			function validateMobile() {
				var userMobile=document.getElementById('userMobile');
				var userMobilevalue = userMobile.value; 
				console.log(userMobilevalue);
				if(userMobilevalue != null && userMobilevalue !="" && userMobilevalue.length == 10)
				{
					console.log('validate mobile');
					const xhttp = new XMLHttpRequest();
					console.log("Running in ajax");
					console.log(userMobilevalue);
					xhttp.open("GET","http://localhost:8888/xworkz-sushma-cm/userName/" +userEmailvalue);
					xhttp.send();
					
					xhttp.onload = function () {
						console.log(this);
						document.getElementById("displayUserMobile").innerHTML = this.responseText
						
					}
					
					
					document.getElementById('mobileError').innerHTML = '';
					} else {
						console.log('invalid mobile');
						document.getElementById('mobileError').innerHTML = 'please enter valid mobile number digits must be 10';
					}
					
				}
			
			</script>
			</body>
			</html>
			