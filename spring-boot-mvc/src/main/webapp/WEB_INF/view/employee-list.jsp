<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of employees</title>
</head>

<body>
	<h2>Employyes</h2>
	<c:forEach items="${employeelist}" var="item">
		<p>FirstName : ${item.firstName}</p>
		<p>LastName : ${item.lastName}</p>
		<p>Salary : ${item.salary}</p>
		<p>********************</p>
	</c:forEach>
</body>
</html>