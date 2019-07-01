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
                           <input type="button" value="등록" onclick="commentEnroll();"/>
                           <input type="button" value="수정" onclick="commentEnroll();"/>
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
    <!--<form id="commentListForm" name="commentListForm" method="post">-->
        <div id="commentList">
        </div>
    <!-- </form>-->
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
        	//alert("댓글 등록 완료");
            getCommentList();
            $("#comment").val("");
        },
        error:function(request,status,error){
       }
        
    });
}
 
//초기 로딩 시 댓글 불러오기
$(function(){
    getCommentList();
});

//댓글 불러오기 ajax
function getCommentList(){
 //alert("??");
 $.ajax({
	 type:'GET',
	 url:"comment.do",
	 data:{
		 no:window.location.href.split("no=")[1]
	 },
	 dataType:"json",
	 error : function(request, status, error){
		alert("code:"+request.status+"\n"+"error:"+error);
	},
	 success:function(data){
		 var html="";
	     if(data.length>0){
	    	html+="<div>";
	        html+="<div><table class='table'>";
	        for(i=0;i<data.length;i++){
	            html+="<tr><td>"+i+"</td><td>"+data[i].content+"</td></tr>";
	        }
	        html+="</table></div>";
            html+="</div>";
	      }else{
	         html+="<div>";
	         html+="<div><table class='table'>";
	         html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
	         html+="</table></div>";
	         html+="</div>";
	      }
	      $("#commentList").html(html);
	 }
 });
}
 
</script>
 
</body>
</html>
