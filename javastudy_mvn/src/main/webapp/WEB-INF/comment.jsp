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
                <span><strong>Comments</strong></span>
            </div>
            <div>
                <table class="table">
                  <tr>
                    <td>
                        <textarea style="width:500px" rows="3" cols="30" id="comment" name="comment" placeholder="댓글을 입력하세요"></textarea>
                        <br>
                        <div>
                           <input type="button" value="등록" onclick="commentEnroll();"/>
                        </div>
                     </td>
                  </tr>
                </table>
            </div>
        </div>
    </form>
</div>
<div class="container">
	<div id="commentList">
	</div>
</div>
 
<script>

/*
 ajax는 ajax 자체를 브라우저로 생각하고, ajax내부에서 xmlhttprequest통신을 통해 서버를 연결시켜주고, 데이터들을 ajax가 다시 받는 방식.
 url을 통해 서버와 연결을 해주고, 이 때 해당 data를 함께 보냄.
 ajax통신에 성공했을 때 success로 간다. 실패했을 때는 error로 간다.
 */
 
/*
댓글을 등록할 때에는 
1. 화면이 새로고침 되지 않아야 하고
2. url을 새로고침 했을 때 계속적으로 등록되는 형태이면 안됨
따라서 ajax를 사용하고, type은 Post방식을 사용한다.

url을 통해 서블릿으로 간다. 이 때 댓글 데이터와 댓글이 작성되는 게시물 번호를 함께 가지고 간다.
addCommentController으로 간다!
 */
function commentEnroll(){
    $.ajax({
        type:'POST',
        url : "addComment.do",
        data:{
        	comment:$("#comment").val(),
        	board_no:window.location.href.split("no=")[1]//${param.no} 얘랑 똑같음 ~~~ param은 jsp 내부 객체
        },
        success : function(data){
        	/*
        	addComment.do가 성공적으로 되어 data가 받아져오면, 해당 데이터를 통해 등록된 댓글을 추가할 수 있게 한다.
        	기존 테이블에서 하나 더 생성하여 등록된 댓글을 보여주게 된다.
        	*/
        	let html="";
        	const no=data.no;
        	const last=no+1;
        	/*if($("#comment").length){
        		$("#comment").html(html);
        	}*/
        	
            html+="<td>"+data.no+"</td><td>"+data.content+"</td>";
            html+="<td><input type='button' value='수정' onclick='commentEditForm("+data.no+")'/></td>";
        	html+="<td><input type='button' value='삭제' onclick='commentDelete("+data.no+")'/></td>";
        	$("#"+no).html(html);
        	$("#"+no).parent().append("<tr id='"+last+"'></tr>");
        	document.getElementById("comment").value='';
        }, 
        error:function(request,status,error){
       } 
    });
}


/*
댓글을 수정할 때에는 두 가지의 단계가 필요하다.
1. 댓글 수정 form생성
2. 댓글 수정 작업

따라서 댓글 수정 버튼을 눌렀을 때 form을 생성하고, 수정 완료 버튼을 누르면 수정이 된 값이 보여지는 순서를 가져야 한다.
*/

/* 1. 댓글 수정 form 생성
댓글 수정 form을 생성하는 것은, 댓글 수정 버튼을 눌렀을 때 form을 생성하고 그 form안에 기존의 댓글이 select되어 들어가 있어야 한다.
updateCommentForm.do의 url을 따라가면 UpdateCommentController으로 간다. 이 때 select문에서는 primary key인 no만 필요하므로 data는 no만 가지고 간다.
*/
function commentEditForm(no){
	$.ajax({
		type:'GET',
		url:"updateCommentForm.do",
		data:{
		 no:no//no만 써줘도된다
		},
		dataType:"json",
		error : function(request, status, error){//.fail
			alert("code:"+request.status+"\n"+"error:"+error);
		},
		success:function(data){//.done
			//댓글 등록할 때와 동일한 방식으로 html파일을 수정한다.
		 	var html="";
			//js파일로 나누기
            html+="<tr id='"+data.no+"'><td>"+data.no+"</td>";
            html+="<td><input type='text' id='update' name='update' value='"+data.content+"'></input></td>";
        	html+="<td><input type='button' value='수정완료' onclick='updateComplete("+data.no+");'/></td>";
        	$("#"+no).html(html);
		}
	});
}
/* 2. 댓글 수정 작업

댓글 수정의 경우도 댓글 등록과 마찬가지의 이유로 post방식을 사용해야 하고, 
updateComplete.do url을 따라가면 UpdateCompleteController로 간다.
 */
function updateComplete(no){
	$.ajax({
        type:'POST',
        url : "updateComplete.do",
        data:{
        	comment:$("#update").val(),
        	no:no,
        },
        success : function(data){
			//댓글 등록할 때와 동일한 방식으로 html파일을 수정한다.
        	var html="";
        	html+="<td>"+data.no+"</td><td>"+data.content+"</td>";
        	html+="<td><input type='button' value='수정' onclick='commentEditForm("+data.no+");'/></td>";
        	html+="<td><input type='button' value='삭제' onclick='commentDelete("+data.no+")'/></td>";
			$("#"+no).html(html);
        },
        error:function(request,status,error){
       }  
    });
}

/* 댓글 삭제

댓글 삭제의 경우도 댓글 등록과 마찬가지의 이유로 post방식을 사용해야 하고, 
deleteComplete.do url을 따라가면 DeleteCommentController로 간다. 이 때 삭제를 위해 no를 가지고 간다.
*/
function commentDelete(no){
	$.ajax({
        type:'POST',
        url : "deleteComment.do",
        data:{
        	no:no
        },
        success : function(data){
        	/* 데이터베이스에서는 삭제되었으나, html에서는 삭제되지 않았기 때문에 해당 태그를 가진 부분을 삭제해준다. */
        	$("#"+no).remove();//삭제
        },
        error:function(request,status,error){
       }
        
    });
}
//익명함수로, 초기 로딩 시 댓글을 모두 불러오는 역할
$(function(){
    getCommentList();//$(document).ready(이 안에 함수);
});

/*
모든 댓글을 데이터베이스에서 가져와주는 메소드이다.
comment.do의 url을 따라가면 CommentController클래스이다.
이 때 게시글의 번호를 알아야 하기 때문에 url에서 no를 split하여 가져간다.
*/
function getCommentList(){
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
		 /*
		  해당 게시글의 모든 댓글을 data에 넣어 return 시켰기 때문에
		 data의 length만큼을 html로 붙여준다.
		 이 때 data length가 없는 경우를 구분하여 처리해준다.*/
		 var html="";
	     if(data.length>0){
			var last=data[data.length-1].no+1;
	        html+="<div><table class='table'>";
	        for(i=0;i<data.length;i++){
	            html+="<tr id='"+data[i].no+"'><td>"+data[i].no+"</td><td>"+data[i].content+"</td>";
	        	html+="<td><input type='button' value='수정' onclick='commentEditForm("+data[i].no+");'/></td>";
	        	html+="<td><input type='button' value='삭제' onclick='commentDelete("+data[i].no+")'/></td></tr>";
	        }
	        html+="<tr id='"+last+"'></tr>";
	        html+="</table></div>";
	      }else{
	         html+="<div><table class='table'>";
	         html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
	         html+="</table></div>";
	      }
	      $("#commentList").html(html);
	 }
 });
}
 
</script>
 
</body>
</html>
