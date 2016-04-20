<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<c:if test="fail">
		Invalid username or password!
	</c:if>
	<form method="post" action="j_security_check">
		Username:
		<input type="text" name="j_username">
		Password:
		<input type="password" name="j_password">
		<input type="submit">
	</form>
</body>
</html>