package kr.co.javastudy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.javastudy.common.MyAppSqlConfig;
import kr.co.javastudy.mapper.CommentMapper;

@WebServlet("/comment.do") 
public class CommentController extends HttpServlet{
	private CommentMapper mapper;
	public CommentController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("comment", mapper.selectComment());
		request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);
	}
}

