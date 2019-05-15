<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>first</title>
</head>
<body>
	<p>
	first page
	</p>
	
	<%
		response.sendRedirect("secondPage.jsp");
	%>
	</body>
</html>