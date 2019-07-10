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

@WebServlet("/updateComplete.do")

public class updateCompleteController extends HttpServlet{
	private CommentMapper mapper;//mapper객체를 생성하고
	
	public updateCompleteController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Comment comment =new Comment();
		//comment객체를 생성하여 update할 댓글의 내용과, 댓글의 번호를 set한다.
		comment.setContent(request.getParameter("comment"));
		comment.setNo(Integer.parseInt(request.getParameter("no")));
		//set한 내용을 바탕으로 update를 진행한다.
		mapper.updateComment(comment);
		//update 완료된 내용을 ajax에 return한다.
		PrintWriter out =response.getWriter();
		String result=new Gson().toJson(comment);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
	}
}
