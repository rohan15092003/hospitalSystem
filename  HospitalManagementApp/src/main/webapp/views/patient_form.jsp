<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient Form</title>
</head>
<body style="background-color: powderblue">
	<h1 align="center">New Patient Form</h1>
	<div>
		<p>${NOTIFICATION }</p>
	</div>
<div>
	<p>${session}</p>
	</div>

	<form align="center"
		action="${pageContext.request.contextPath}/HospitalController"
		method="post">

		<div class="form-group">
			<input type="text" class="form-control" name="name"
				placeholder="NAME" value="${hospital.name}" required>
		</div>

		<div class="form-group">
			<input type="email" class="form-control" name="email"
				placeholder="xyz@emial.com" value="${hospital.email}"required>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="address"
				placeholder="Address" value="${hospital.address}" required>
		</div>
		<div class="form-group">
			<input type="number" class="form-control" name="contact"
				placeholder="1243563" value="${hospital.contact}"required>
		</div>

		<input type="hidden" name="id" value="${hospital.id}" /> <input
			type="hidden" name="action" value="ADD" />

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	<div align="center">
		<p>
			<a href="${pageContext.request.contextPath}/HospitalController">Hospital
				List</a>
		</p>
	</div>


</body>
</html> 