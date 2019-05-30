package kr.co.javastudy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.javastudy.common.MyAppSqlConfig;
import kr.co.javastudy.mapper.BoardMapper;

@WebServlet("/delete.do")
public class DeleteBoardController extends HttpServlet {

   private BoardMapper mapper;
   public DeleteBoardController() {
      mapper = MyAppSqlConfig.getSqlSession().getMapper(BoardMapper.class);
   }
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int no=Integer.parseInt(request.getParameter("no"));
      mapper.deleteBoard(no);
      response.sendRedirect("list.do");
   }
}