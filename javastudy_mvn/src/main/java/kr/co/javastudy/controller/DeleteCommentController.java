package kr.co.javastudy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.javastudy.common.MyAppSqlConfig;
import kr.co.javastudy.mapper.CommentMapper;
import kr.co.javastudy.vo.Comment;

@WebServlet("/deleteComment.do")
public class DeleteCommentController extends HttpServlet {
	
	private CommentMapper mapper;
	
	public DeleteCommentController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 가져온 no를 이용하여 데이터베이스에서 해당 no를 가진 댓글을 삭제한다. */
		int no=Integer.parseInt(request.getParameter("no"));
		mapper.deleteComment(no);
	}
}
