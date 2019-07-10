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


@WebServlet("/comment.do") 
public class CommentController extends HttpServlet{
	private CommentMapper mapper;
	public CommentController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가져온 게시글의 번호를 통해 
		int no=Integer.parseInt(request.getParameter("no"));
		
		PrintWriter out =response.getWriter();
		//board no로 comment를 모두 받아온 후 해당 게시글의 모든 댓글을 ajax로 return한다.
		List<Comment> comment=mapper.selectCommentByBoardNo(no);
		String result=new Gson().toJson(comment);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();        
	} 
}

