<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body style="background-color: powderblue">
	<h1>Signup Page</h1>
	<form action="${pageContext.request.contextPath}/HospitalController"
		method="post">
		<div>
			<p>${NOTIFICATION }</p>
		</div>

		<div class="form-method">
			<label>user name</label> <input type="text" class="form-control"
				name="uname" placeholder="name" value="${user.uname}">
		</div>

		<div class="form-method">
			<label>user password</label> <input type="password"
				class="form-control" name="upassword" placeholder="password"
				value="${user.upassword}">
		</div>
		<div class="form-method">
			<input type="hidden" class="form-control" name="action"
				value="ADDUSER">
		</div>


		<button type="submit" class="btn btn-primary">SignUp</button>
	</form>
	<div>
		<p>
			<a href="${pageContext.request.contextPath}/views/login_form.jsp">Login</a>
		</p>
	</div>
</body>
</html>