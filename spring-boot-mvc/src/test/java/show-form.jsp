<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>

<body>
	<form:form action="processForm" method="POST" modelAttribute="employee">
		First Name<form:input path="firstName"/><br/><br/>
		Last Name<form:input path="lastName"/><br/><br/>
		Salary<form:input path="salary"/><br/><br/>
		
		<input type="submit">
	</form:form>
</body>
</html>