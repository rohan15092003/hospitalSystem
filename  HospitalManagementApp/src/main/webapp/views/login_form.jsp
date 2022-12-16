<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-color: powderpink">
<h1>Login Page</h1>
<div>
<form action="${pageContext.request.contextPath}/HospitalController" method="post">
<div>
		<p>${NOTIFICATION }</p>
	</div>

 <div class="form-group"><label>user name</label>
 <input type="text" name="uname" class="form-control" value="${user.uname}">
 </div>
 <div class="form-group"><label>user password</label>
 <input type="password" name="upassword" class="form-control" value="${user.upassword}">
 </div>
 <div class="form-group">
 <input type="hidden" name="action" class="form-control" value="LOGIN">
 </div>
 
 		<button type="submit" class="btn btn-primary">loginUser</button>
			
</form>
</div>
<div>
		<p>
			<a href="${pageContext.request.contextPath}/views/user_signup.jsp">Signup</a>
		</p>
	</div>
</body>
</html>