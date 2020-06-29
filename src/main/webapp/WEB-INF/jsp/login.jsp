<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>PetClinic Login Page</h1>
<form action="login" method="post">
	USERNAME: <input type="text" name="username"/><br />
	PASSWORD: <input type="password" name="password"/><br />
	Remember Me: <input name="remember-me" type="checkbox"/>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
	<input type="submit" value="Login"/>
	<font>
		<c:if test="${not empty param.loginFailed }">
			<c:out value="login Failed, Incorrect Username or Password"></c:out>
		</c:if>
	</font>
</form>
</body>
</html>