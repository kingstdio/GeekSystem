<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="config.staticConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=staticConfig.siteName %></title>
</head>
<body>
<form action="Login" method="post">
	<input type="text" name ="userName"></input>
	<input type="submit" value="提交"></input>
</form>
</body>
</html>