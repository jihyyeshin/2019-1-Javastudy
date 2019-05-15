package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String mId=request.getParameter("mID");
		String mPw=request.getParameter("mPw");
		
		out.print("ID: "+mId);
		//쿠키는 클라이언트 쪽이므로, 요청한 정보이므로 request
		Cookie[] cookies=request.getCookies();
		Cookie cookie=null;
		
		for(Cookie c : cookies) {//쿠키를 조회한다.
			System.out.println("name:"+c.getName()+"value"+c.getValue());
		
			if(c.getName().equals("memberId")) {
				cookie=c;
			}
		}
		if(cookie==null) {//쿠키를 새로 생성
			System.out.println("cookie is null");
			cookie = new Cookie("memberId", mId);
		}
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);//쿠키의 기한은 1시간
		
		response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
