package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class serEx extends HttpServlet {
	//얘는 application역할을 해주는 애가 Context임. context parameter을 이용해서 전체 공유를 해준다.
	//config역할을 하는 애는 init param임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId=getServletConfig().getInitParameter("adminId");
		String adminPw=getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out=response.getWriter();
		out.print("<p>adminId: "+adminId+"</p>");
		out.print("<p>adminPw: "+adminPw+"</p>");

		String imgDir=getServletContext().getInitParameter("imgDir");
		
		out.print("<p>imgDir: "+imgDir+"</p>");
		
		getServletContext().setAttribute("connectedIP", "165.0.0.1");
		getServletContext().setAttribute("connectedUser", "jihye");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
