<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %><!-- 에러 처리 페이지이다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
response.setStatus(200);
String msg=exception.getMessage();
%>
<h1>error message : <%=msg %></h1>
</body>
</html>