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
	
	/*
	 일단, CommentMapper 객체를 생성한다.
	이 인터페이스의 구현은 comment.xml에서! 데이터베이스에 접근
	 */
	private CommentMapper mapper;
	
	public AddCommentController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(CommentMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*comment 객체를 만들어서 댓글과 board_no를 set해준다.*/
		Comment comment =new Comment();
		comment.setContent(request.getParameter("comment"));
		comment.setBoardNo(Integer.parseInt(request.getParameter("board_no")));
		/*그 후 데이터베이스에 comment를 insert*/
		/*이 때 select key를 이용하여 key값을 받아옴 comment.xml참고
		 이 과정을 통하여 auto_increment되어 알 수 없었던 no값 까지 함께 comment에 넣어진다.*/
		mapper.insertComment(comment);
		PrintWriter out =response.getWriter();
		/* result는 json형태로 jsp파일에 return 된다.*/
		String result=new Gson().toJson(comment);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
	}
}
