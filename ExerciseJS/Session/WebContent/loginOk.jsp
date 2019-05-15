<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	session=request.getSession();//내장 객체 session
	out.print("memberId: "+session.getAttribute("memberId"));
%>

<form action="logoutCon" method="post">
	<input type="submit" value="logout">
</form>

</body>
</html>