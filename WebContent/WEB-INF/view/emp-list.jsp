<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Record</title>
</head>
<body>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>company</th>
			<th>Email</th>
			<th>Action</th>

		</tr>
		<c:forEach var="tempemp" items="${emp}">
			<c:url var="updateLink" value="/employee/showFormForUpdate">
				<c:param name="employeeId" value="${tempemp.id}"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="/employee/employeeDelete">
				<c:param name="employeeId" value="${tempemp.id}"></c:param>
			</c:url>
			
			<tr>
				<td>${tempemp.id}</td>
				<td>${tempemp.name}</td>
				<td>${tempemp.company}</td>
				<td>${tempemp.email}</td>
				<td><a href="${updateLink}">update</a>
				    <a href="${deleteLink}">| delete</a>
				</td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<input type="button" value="Add Employee"
		onclick="window.location.href='showFormForAdd';return false" />
</body>
</html>