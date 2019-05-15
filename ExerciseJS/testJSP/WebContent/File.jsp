<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!-- 페이지 지시어에서, 에러가 났을 때 어떤 페이지에서 처리해줄 것이다, 라는 것을 명시하는 것임 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
	String adminId;
	String adminPw;
	
	String imgDir;
	String testServerIP;
	%>
	<!-- 서블릿을 초기화 시키는 admin의 id, pw를 만드는 것이 config내장객체임! 
	이 서블릿에서만 사용할 수 있다.-->
	<% 
	adminId=config.getInitParameter("adminId");
	adminPw=config.getInitParameter("adminPw");
	%>
	
	<p>adminId: <%=adminId %></p>
	<p>adminPw: <%=adminPw %></p>
	
	<!-- 어플리케이션 전체에서 공유할 수 있는 데이터를 만들려면 application객체를 만든다. -->
	<%
	imgDir=application.getInitParameter("imgDir");
	testServerIP=application.getInitParameter("testServerIP");
	%>
	
	<p>imgDir: <%=imgDir %></p>
	<p>testServerIP: <%=testServerIP %></p>
	<!-- 어플리케이션 객체의 경우는 어플리케이션 전체에 적용되기 때문에 속성을 정하는데에도 사용될 수 있다. -->
	<%
	application.setAttribute("connetedIP", "127.0.0.1");
	application.setAttribute("connetedUser", "admin");
	//이를 다른 jsp파일에서 getAttribute("connetedIP")로 가져오면 된다. 이 때 String으로 가져와야 하기 때문에 캐스팅 연산자를 사용할 것
	%>
	
	<!-- out객체는 out.print할 떄, 즉 출력할 때 사용한다. -->
	<!-- exception은 에러 처리를 해준다. -->
	<%
	String str;
	//out.print(str.toString());
	%>
</body>
</html>