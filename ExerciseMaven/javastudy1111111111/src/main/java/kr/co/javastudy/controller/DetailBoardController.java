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

/**
 * Servlet implementation class DetailBoardController
 */
@WebServlet("/detail.do")
public class DetailBoardController extends HttpServlet {
	private BoardMapper mapper;

    public DetailBoardController() {
        //super();
		mapper = MyAppSqlConfig.getSqlSession().getMapper(BoardMapper.class);
        
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = new Board();
		int no=Integer.parseInt(request.getParameter("no"));
		
		board=mapper.detailBoard(no);
		request.setAttribute("board",board);
		request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);

	}

}
