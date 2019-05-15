<% 
//post방식일 때 jsp에서도 동일하게 처리하면 된다.
request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name;
	String nick;
	%>
	<%
		name=request.getParameter("m_name");
	%>
	이름 : <%=name %>
</body>
</html>