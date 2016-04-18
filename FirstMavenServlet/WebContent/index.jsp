<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
Hello ${user.username}!<br>
Hello ${user["username"]}!<br>
First number: ${list["0"]}!<br>
"a" element of map: ${map["a"]}!<br>
Version: ${version}<br>
</body>
</html>