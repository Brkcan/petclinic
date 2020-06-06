<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<td>id</td>
				<td>first Name</td>
				<td>last Name</td>
			</tr>
		</thead>
		<c:forEach items="${owners}" var="owner">
			<tr>
				<td>${owner.id}</td>
				<td>${owner.firstName}</td>
				<td>${owner.lastname}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>