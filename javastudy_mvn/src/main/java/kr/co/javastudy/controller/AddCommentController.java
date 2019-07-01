package kr.co.javastudy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.javastudy.common.MyAppSqlConfig;
import kr.co.javastudy.mapper.CommentMapper;
import kr.co.javastudy.vo.Comment;

@WebServlet("/addComment.do")
public class AddCommentController extends HttpServlet {
	
	private CommentMapper mapper;
	
	public AddCommentController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Comment comment =new Comment();
		comment.setContent(request.getParameter("comment"));
		comment.setBoardNo(Integer.parseInt(request.getParameter("board_no")));
		
		mapper.insertComment(comment);
		PrintWriter out =response.getWriter();

		String result=new Gson().toJson(comment);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
	}
}
