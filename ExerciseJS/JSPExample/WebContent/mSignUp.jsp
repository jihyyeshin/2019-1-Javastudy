<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	웹 컨테이너에서 정보를 받을 때 사용하는 것: request 객체
	뭔가 응답을 할 것이다, 는 반응을 보이는 것이기 때문에 : response 객체
	
	jsp에서 요청한 정보를 저장하는 쪽이 request이고,(많이 쓰이는 것 - form으로 보내는 것)
	서버에 뭔가 요청만 함.
	jsp에서 응답의 정보를 저장하는 쪽이 response이다.(많이 쓰이는 것 - 리다이렉트 기능) 
	서버에서 뭔가 응답을 보냄.
	 -->
	<%
		String m_name;
		String m_pass;
		String[] m_hobby;
	%>
	<%
		m_name = request.getParameter("m_name");
		m_pass = request.getParameter("m_pass");
		m_hobby = request.getParameterValues("m_hobby");
	%>
	
	m_name : <%= m_name %> <br>
	m_passwd : <%= m_pass %> <br>
	<%
	for(int i=0;i<m_hobby.length;i++){
	%>
	<%=m_hobby[i] %>
	<% }%><br>

</body>
</html>