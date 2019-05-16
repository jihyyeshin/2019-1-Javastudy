<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.servlet.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info</title>
</head>
<body>
	<%
	Member m=(Member)request.getAttribute("m");
	%>
	아이디:<%=m.Id%><br>
	패스워드:<%=m.Pw %><br>
</body>
</html>
