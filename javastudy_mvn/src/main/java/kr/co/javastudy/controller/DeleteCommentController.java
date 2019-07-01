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
		System.out.println("hello~");
		System.out.println(request.getParameter("no"));
		int no=Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		mapper.deleteComment(no);
	}
}
