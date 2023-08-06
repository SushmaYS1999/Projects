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
				
			</div>		
		</nav>
			<div align="center">User Name:${userId}</div>
			<div align="center">
		<form action="passwordUpdate" method="post">
			<table>
				<tr>
					<td>User ID</td>
					
					<td><input type="text" name="userId" value="${userId}" ></td>
					</tr>
					
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="userPassword" >
						<span id="passwordError" style="color: red;"></span>
						<input type="checkbox" onclick="myFunction1()">Show Password
					</td>
					</tr>
					<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmPassword" id="userConfirmPassword"
					onblur="validatePassword()"><span id="passwordCompare" style="color: red"></span> 
					<input type="checkbox" onclick="myFunction2()">Show Confirm Password</td>
					</tr>
			</table>
			
			<button type="submit">Update</button>
			
		</form>
		</div>
		<script>
		function myFunction1(){
						var x = document.getElementById("userPassword");
						if(x.type === "password")
						{
							x.type = "text";
						}
						else{
							x.type = "password";
						}
					}
					
		function myFunction2(){
						var x = document.getElementById("userConfirmPassword");
						if(x.type === "password")
						{
							x.type = "text";
						}
						else{
							x.type = "password";
						}
					}
					
		function validatePassword() {
						var userPassword=document.getElementById('userPassword');
						var userConfirmPassword=document.getElementById('userConfirmPassword');
						var userPasswordvalue = userPassword.value; 
						var userConfirmPasswordvalue = userConfirmPassword.value; 
						console.log(userPasswordvalue);
						if(userPasswordvalue != null && userPasswordvalue !="" && userPasswordvalue.length > 4 && userPasswordvalue.length < 12)
						{
							if(userPasswordvalue == userConfirmPasswordvalue)
							{
								console.log('validate both password are same');
								document.getElementById('passwordCompare').innerHTML = '';
						}
						else {
 							console.log('validate both password are not same');
 							document.getElementById('passwordCompare').innerHTML = 'password and confirm password are not same';
						}
							console.log('validate password');
 							document.getElementById('passwordError').innerHTML = '';
					}
						else {
							console.log('invalid  password');
 							document.getElementById('passwordError').innerHTML = 'please enter valid password length must be greater then 4 and less  then 12';
						}
						}
		</script>
		</body>
		</html>
		