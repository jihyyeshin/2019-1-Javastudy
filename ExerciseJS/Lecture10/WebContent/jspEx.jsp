<%-- 지시어: 서버에서 jsp페이지를 처리하는 방법 정의 
1)page: 페이지 기본 설정<% page 속성="속성 값> - 항상 동일함
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
2)include: 다른 파일(jsp) 가져오고 싶을 때 include file 설정<%include file="파일명"> - 수 많은 페이지마다 공통적인 내용을 넣고 싶을 때
3)taglib: 외부 라이브러리, jsp에서 사용하지 않는! 라이브러리 태그 <%taglib uri="uri" prefix="namespace">
--%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<!-- 선언 태그: JSP 페이지에서 Java의 멤버변수, 메서드 선언!! -->
	<%!int num = 10;
	String str = "jsp";
	ArrayList<String> list = new ArrayList<String>();

	public void jspMethod() {
		System.out.println(" --jspMethod()");
	}%>
	<%-- jsp의 주석 태그 --%>

	<!-- 스크립트릿 태그: JSP페이지에서 Java코드(마음껏 넣을 수 있음)를 넣기 위한 태그 -->
	<%
		if (num > 0) {
	%>
	<p>num>0</p>
	<%
		} else {
	%>
	<p>num<=0</p>
	<%
		}
	%>

	<!-- 표현식 태그: 변수, 메서드 반환값을 출력! -->
	<p>num is<%=num%></p>
	<%@include file="footer.jsp" %>
	
</body>
</html>