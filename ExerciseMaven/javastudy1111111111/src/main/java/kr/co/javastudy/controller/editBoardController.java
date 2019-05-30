package kr.co.javastudy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.javastudy.common.MyAppSqlConfig;
import kr.co.javastudy.mapper.BoardMapper;
import kr.co.javastudy.vo.Board;

@WebServlet("/edit.do")
public class editBoardController extends HttpServlet {
	private BoardMapper mapper;
	
	public editBoardController() {
		mapper = MyAppSqlConfig.getSqlSession().getMapper(BoardMapper.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = new Board();
		
		board.setContent(request.getParameter("content"));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setNo(Integer.parseInt(request.getParameter("no")));
		
		mapper.editBoard(board);
		
		response.sendRedirect("list.do");
	}
}