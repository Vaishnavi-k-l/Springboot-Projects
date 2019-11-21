<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" method="post" modelAttribute="employee">
	First name:<form:input path="firstName" /><br/><br/>
	Last name:<form:input path="lastName" /><br/><br/>
	Salary: <form:input path="salary" /><br/><br/>
	<form:button>Click</form:button>
	</form:form>
</body>
</html>