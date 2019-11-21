<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form to get Employee by Id</title>
</head>

<body>
	<form:form action="getOneEmployee" >
	Id:<form:input path="employeeId" /><br/><br/>
	<form:button>Click</form:button>
	</form:form>
</body>
</html>