<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmA1eBxtqpZSrUECdRXqK1TpV0bHmUXGkOiR9Mtr7aKFkbSzcROt-TNMLBK-XlaOIJSFw&usqp=CAU"
							alt="" width="88" height="48">
						</a>
					</div>
				</nav>
				<div>
				<a href="index.jsp">home</a><br>
				<a href="SignUp.jsp">SignUp</a><br>
				<a href="SignIn.jsp">SignIn</a><br>
				
				</div>
			</div>
		</nav>
		
		<h1>Welcome to signUp page</h1>
		
		<c:forEach items="${error}" var="e">
		<h6 style="color:red;">${e.message}</h6>
		</c:forEach>
				<form   action="display" method="post" >
				
				
				UserId <input type="text" name="userId"  id="userName"
						onchange="ValidateName()" > <span id="nameError"
						style="color: red"></span>
						<span id="displayUserName" style="color: red"></span>
						 <br>
				Email<input type="text" name="email" id="emailId"
						onchange="validateEmail()" > <span id="emailError"
						style="color: red"></span>
						<span id="display" style="color: red"></span>
						<br>
				Mobile<input type="number" name="mobile" id="userMobile"
						onchange="validateMobile()" > <span id="mobileError"
						style="color: red"></span>
						<span id="displayUserMobile" style="color: red"></span>
						<br>
				Password<input type="password" name="password" id="userPassword">
						 <span id="passwordError" style="color: red"></span>
						 <input type="checkbox" onclick="myFunction()"> Show Password
						 <br>
						 
				Confirm Password<input type="password" name="confirmPassword" id="userConfirmPassword"
								onblur="validatePassword()">
						 <span id="passwordCompare" style="color: red"></span> <br>
						 
				Accept Agreement<input type="checkbox" name="acceptAgreement" id="agreementConfirm"
								onclick="ValidateName()"> <br>
								
								<button type="submit"  class="btn btn-success" id="submitId" 
								disabled="true">SignUp</button>
				</form>
				
				<input type="submit" value="ShowDto" onclick="DisplayDTO()">
				<span id="ShowDTO"></span>
				<h4 style="color: red;">${password}</h4>
				<script>
				
				
				function DisplayDTO() {
					console.log("running in DisplayDTO");
					const xhttp = new XMLHttpRequest();
					xhttp.open("GET","http://http://localhost:8888/xworkz-sushma-cm/userName/" +uservalue);
					xhttp.send();
					
					xhttp.onload = function() {
						console.log(this);
						document.getElementById("showDTO").innerHTML = this.responseText
						
						var json=JSON.parse(this.responseText);
					
				}
				}
				
					function myFunction(){
						var x = document.getElementById("userPassword");
						if(x.type === "password")
						{
							x.type = "text";
						}
						else{
							x.type = "password";
						}
					}
				
					/*function onconfirm() {
						var agree = document.getElementById("agreementConfirm");
						console.log(agree.checked);
						if(agree.checked) {
							document.getElementById('submitId').disabled=false;
						}
						else {
							document.getElementById('submitId').disabled='disabled';
						}
					} */
				
					function ValidateName() {
						var user = document.getElementById('userName');
						var uservalue = user.value;
						console.log(uservalue);
						if(uservalue != null && uservalue !="" && uservalue.length > 3 && uservalue.length < 30)
						{
							console.log('validate name');
							var agree = document.getElementById('agreementConfirm');
							console.log(agree.checked);
							if(agree.checked)
							{
								document.getElementById('submitId').disabled=false;
							}
							document.getElementById('nameError').innerHTML = '';
						}
						else {
							console.log('invalidate name');
							document.getElementById('submitId').disabled='disabled';
							document.getElementById('nameError').innerHTML = 'Please enter valid name min 4 and max 29 chars';
						}
						const xhttp = new XMLHttpRequest();
						console.log("Running in ajax");
						console.log(uservalue);
						xhttp.open("GET","http://localhost:8888/xworkz-sushma-cm/userName/" +uservalue);
						xhttp.send();
						
						xhttp.onload = function () {
							console.log(this);
							document.getElementById("displayUserName").innerHTML = this.responseText
						}
					}
					
					function validateEmail() {
						var userEmail=document.getElementById('emailId');
						var userEmailvalue = userEmail.value; 
						console.log(userEmailvalue);
						if(userEmailvalue != null && userEmailvalue !="" && userEmailvalue.length > 4 && userEmailvalue.length < 40)
						{
							console.log('validate email');
							document.getElementById('emailError').innerHTML = '';
						}
						else {
							console.log('invalidate email');
							document.getElementById('emailError').innerHTML = 'Please enter valid email';
						}
						const xhttp = new XMLHttpRequest();
						console.log("Running in ajax");
						console.log(userEmailvalue);
						xhttp.open("GET","http://localhost:8888/xworkz-sushma-cm/email/" +userEmailvalue);
						xhttp.send();
						
						xhttp.onload = function () {
							console.log(this);
							document.getElementById("display").innerHTML = this.responseText
						}
					}
				
					function validateMobile() {
						var userMobile=document.getElementById('userMobile');
						var userMobilevalue = userMobile.value; 
						console.log(userMobilevalue);
						if(userMobilevalue != null && userMobilevalue !="" && userMobilevalue.length == 10)
						{
							console.log('validate mobile');
							document.getElementById('mobileError').innerHTML = '';
						}
						else {
							console.log('invalidate mobile');
							document.getElementById('mobileError').innerHTML = 'Please enter valid mobile number';
						}
						const xhttp = new XMLHttpRequest();
						console.log("Running in ajax");
						console.log(userMobilevalue);
						xhttp.open("GET","http://localhost:8888/xworkz-sushma-cm/mobile/" +userMobilevalue);
						xhttp.send();
						
						xhttp.onload = function () {
							console.log(this);
							document.getElementById('displayUserMobile').innerHTML = this.responseText
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
 							document.getElementById('passwordCompare').innerHTML = 'password and confirm password must be same';
						}
							console.log('validate password');
 							document.getElementById('passwordError').innerHTML = '';
					}
						else {
							console.log('invalid  password');
 							document.getElementById('passwordError').innerHTML = 'please enter valid password';
						}
						}		
	
				</script>
	</body>
</html>