<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<a href="index.jsp">home</a><br>
				<a href="SignUp.jsp">SignUp</a><br>
				<a href="SignIn.jsp">SignIn</a><br>
				<span style="color: white;">welcome:${userId}</span>
				<img src="download?fileName=${dtoPic}" height="50" width="80">
				
			</div>		
		</nav>
			
	<h1 style="color: green;" align="center">${addTechSuccess}</h1>
	<h5 style="color: red;" align="center">
		<c:forEach items="${errors}" var="e">
		<br>${e.message}</c:forEach>
	</h5>
		
		<h1>Add Technology Form</h1>
				<form action="addtechnology?signupId=${signupId}" method="post" >	
				<div align="center"> 
				<table>
				<tr>
				<td>techName</td>
				<td> <input type="text" name="techName" id="techName" class="form-outline mb-4">
				</td>
				</tr>
				<br>
				
				<tr>
				<td>language</td>
				<td> <input type="text" name="language" id="language" onchange="techName" class="form-outline mb-4">
				</td>
				</tr>
				<br>
				<tr>
				<td>version</td>
				<td> <input type="number" name="version" id="version" 
				onchange="number" class="form-outline mb-4">
				</td>
				</tr>
				<br>
				
				<tr>
				<td>owner</td>
				<td> <input type="text" name="owner" id="owner" class="form-outline mb-4">
				</td>
				</tr>
				<br>
				
				<tr>
				<td>supportFrom</td>
				<td> <input type="text"
				 name="supportFrom" id="supportFrom" class="form-outline mb-4">
				 </td>
				 </tr>
				<br>
				
				<tr>
				<td>supportTo</td> 
				<td><input type="text" name="supportTo" id="supportTo" class="form-outline mb-4">
				</tr>
				</td>
				<br>
				
				<tr>
				<td>license</td>
				<td> <input type="text"
				 name="license" id="license" class="form-outline mb-4">
				</td>
				</tr>
				<br>
				
				<tr>
				<td>osType</td>
				<td> <input type="text" name="osType" id="osType" class="form-outline mb-4">
				</td>
				</tr>
				<br>
				<tr>
				<td>openSource: (if yes, click on check box)</td>
				<td><input type="checkbox" id="openSource" name="openSource" class="form-outline mb-4">
				</td>
				</tr>
				</table>
				
				<div></div><button type="submit" class="btn btn-primary" >ADD</button></div>
				
		</form>
		</div>
		<!--  <script type="text/javascript">
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
		
		const techName=document.getElementById('techName');
		const language=document.getElementById('language');
		const version=document.getElementById('version');
		const owner=document.getElementById('owner');
		const supportFrom=document.getElementById('supportFrom');
		const supportTo=document.getElementById('supportTo');
		const license=document.getElementById('license');
		const openSource=document.getElementById('openSource');
		const osType=document.getElementById('osType');
		const submit=document.getElementById('submit');
		
		techName.addEventListener('input', checkfields);
		language.addEventListener('input', checkfields);
		version.addEventListener('input', checkfields);
		owner.addEventListener('input', checkfields);
		supportFrom.addEventListener('input', checkfields);
		supportTo.addEventListener('input', checkfields);
		license.addEventListener('input', checkfields);
		openSource.addEventListener('input', checkfields);
		osType.addEventListener('input', checkfields);
		name.addEventListener('input', checkfields);
		
		function checkfields() {
			if(techName.value !== '' && language.value !== '' && version.value !== ''
					&& owner.value !== '' && supportFrom.value !== '' && supportTo.value !== '' 
					&& license.value !== '' && openSource.value !== '' && osType.value !== '') {
				submit.disabled = false;
			} else {
				submit.disabled = true;
			}
			
		}
		
		</script> -->
			
				</body>
				</html>
				