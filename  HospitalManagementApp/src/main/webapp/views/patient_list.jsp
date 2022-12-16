<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient list</title>
</head>
<body >
	<div class="container">
		<h1>Patient list</h1>
		<hr />
		<p>${NOTIFICATION}</p>
		<p>
			<button class="btn btn-primary"
				onclick="window.location.href='views/patient_form.jsp'">Add
				Patient</button>
		</p>

		<table class="table table-striped table-bordered">
			<tr class="thead-dark">
				<th>S.No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Contact</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${list}" var="hospital">

				<tr>
					<td>${hospital.id}</td>
					<td>${hospital.name}</td>
					<td>${hospital.email}</td>
					<td>${hospital.address}</td>
					<td>${hospital.contact}</td>
					<td><a><a
							href="${pageContext.request.contextPath}/HospitalController?action=EDIT&id=${hospital.id}">Edit</a>
							| <a
							href="${pageContext.request.contextPath}/HospitalController?action=DELETE&id=${hospital.id}"
							onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
				</tr>



			</c:forEach>

		</table>
	</div>

</body>
</html>