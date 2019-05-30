<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 폼</h1>
	<form action="edit.do" method="post">
		<div>제목 : <input type="text" name="title" value="${board.title}"/></div>
		<div>내용 : <input type="text" name="content" value="${board.content}" /></div>
		<div>글쓴이 : <input type="text" name="writer" value="${board.writer}"/></div>
		<input type="hidden" name="no" value="${board.no}"> 
		<button>수정</button>
	</form>
</body>
</html>