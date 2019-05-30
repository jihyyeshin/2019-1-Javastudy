<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 example</title>
<style>
th, td {
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<h1>글 목록</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>${board.no}</td>
			<td>${board.title}</td>
			<td>${board.content}</td>
			<td>${board.writer}</td>
		</tr>
	</table>
	<form action="editForm.do" method="post">
		<input type="hidden" name="no" value="${board.no}"> 
		<input type="submit" value="글 수정">
	</form>
	
	<form action="delete.do" method="post">
		<input type="hidden" name="no" value="${board.no}"> 
		<input type="submit" value="글 삭제">
	</form>
</body>
</html>