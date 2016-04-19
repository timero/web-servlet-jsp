<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="epam" uri="http://epam.com/time" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jspf"></jsp:include>
	<%@ include file="menu.jspf" %>	
	<br/>	
	The value of a: ${a} <br/>
	<epam:time format="yyyy.MM.dd" />
</body>
</html>