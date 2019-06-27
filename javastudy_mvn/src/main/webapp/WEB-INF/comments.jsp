<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-border w3-padding">댓글</div>
		<div class="w3-border w3-padding">
			<c:if test="${ id == null }">
				<textarea rows="5" cols="50" class="w3-input w3-border newLogin" readonly>로그인 후 댓글 달기</textarea>
			</c:if>
			<c:if test="${ id != null }">
				<i class="fa fa-user w3-padding-16"></i> ${ content.id }
				<form>
					<input type="hidden" name="no" id="no" value="${ content.board_no }"> 
					<input type="hidden" name="id" id="id" value="${ id }">
					<textarea rows="5" cols="50" class="w3-input w3-border" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>						<input type="button" class="w3-button w3-border" id="reply_btn" value="댓글 등록">
				</form>
			</c:if>
	</div>
<script>
$("#reply_btn").click(function(){
	if($("#reply_content").val().trim() === ""){
		alert("댓글을 입력하세요.");
		$("#reply_content").val("").focus();
	}else{
		$.ajax({
			url: "/expro/ReplyWriteAction.do",
            type: "POST",
            data: {
                no : $("#no").val(),
                id : $("#id").val(),
                reply_content : $("#reply_content").val()
            },
            success: function () {
            	alert("댓글 등록 완료");
            	$("#reply_content").val("");
            	getReply();
            },
		})
	}
})
</script>
</body>

</html>
