package kr.co.javastudy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.javastudy.common.MyAppSqlConfig;
import kr.co.javastudy.mapper.CommentMapper;
import kr.co.javastudy.vo.Comment;

@WebServlet("/updateCommentForm.do")
public class UpdateCommentController extends HttpServlet {
	private CommentMapper mapper;//mapper 객체를 생성하고
	public UpdateCommentController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		PrintWriter out =response.getWriter();
		//no를 통해 select문을 쓴다.
		Comment comment=mapper.selectCommentByNo(no);
		//no를 통해 받아온 comment객체를 json으로 만들어서 다시 ajax의 result data로 보내준다.
		String result=new Gson().toJson(comment);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
	}
}