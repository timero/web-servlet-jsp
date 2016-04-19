<%@page import="com.epam.training.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	Hello ${user.username}!
	<br> Hello ${user["username"]}!
	<br> First number: ${list["0"]}!
	<br> "a" element of map: ${map["a"]}!
	<br> Version: ${version}
	<br>
	<a href='<c:url value="/test"/>'>Link</a>
	The length of list: ${fn:length(list)}
	
	<%
		User user = new User();
		out.write(user.toString());
	%>
</body>
</html>