<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="add" method="post" modelAttribute="user">
		account :	<form:input path="account"/><form:errors path="account"></form:errors><br />
		pwd		:	<form:password path="pwd"/><form:errors path="pwd"></form:errors><br/>
		age		:	<form:input path="age" /><br/>
		gender	:	<form:radiobuttons path="gender" items="${genders }"/>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>