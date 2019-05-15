package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tsc")
public class TestServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 개발자만의 별도의 메소드를 생성
	@PostConstruct
	public void postConstruct() {
		System.out.println(" -- @postConstruct -- ");
	}

	// 실제 서비스를 기술, 실행 단계
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(" -- doGet() --");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 초기화, 서블릿 생성단계
	@Override
	public void init() throws ServletException {
		System.out.println(" -- init() --");
	}

	// 종료 단계, 자원 해제 등
	@Override
	public void destroy() {
		System.out.println(" -- destory() --");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(" -- @preDestory --");
	}

}
