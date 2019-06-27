<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- comment 추가 -->
<%@ include file="./comments.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>등록날짜</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
		<tr>
			<td>${board.no}</td>
			<td>${board.title}</td>
			<td><fmt:formatDate value="${board.regDate}" pattern="yy.MM.dd HH:mm:ss" /></td>
			<td>${board.content}</td>
			<td>${board.writer}</td>
		</tr>
	</table>
	<p>Comments</p>
	
	<a href="<c:url value='updateForm.do?no=${board.no}'/>">수정</a>
	<a href="<c:url value='delete.do?no=${board.no}'/>">삭제</a>
	<a href="<c:url value='list.do'/>">목록</a>
</body>
</html>