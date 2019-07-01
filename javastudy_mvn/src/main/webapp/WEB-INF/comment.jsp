<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">
                  <tr>
                    <td>
                        <textarea style="width:500px" rows="3" cols="30" id="comment" name="comment" placeholder="댓글을 입력하세요"></textarea>
                        <br>
                        <div>
                           <a onClick="commentEnroll()">등록</a>
                           <a href='#' >수정</a>
                           <a href='#' >삭제</a>
                        </div>
                     </td>
                  </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="b_code" name="b_code" value="${result.code}" />        
    </form>
</div>
<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>
    </form>
</div>
 
<script>
//댓글 등록
function commentEnroll(){
    $.ajax({
        type:'POST',
        url : "addComment.do",
        data:{
        	comment:$("#comment").val(),
        	board_no:window.location.href.split("no=")[1]
        },
        success : function(data){
        	alert("댓글 등록 완료");
            getCommentList();
            $("#comment").val("");
        },
        error:function(request,status,error){
       }
        
    });
}
 
//초기 로딩 시 댓글 불러오기
$(function(){
	alert("??");
    //getCommentList();
});
 
</script>
 
</body>
</html>
