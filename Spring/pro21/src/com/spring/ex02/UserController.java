package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		//String viewName=getViewName(request);//.do를 제외한 뷰이름을 가져온다.
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");//로그인 정보를 바인딩
		passwd = request.getParameter("passwd");
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName(viewName);
		//System.out.println("ViewName"+viewName);
		mav.setViewName("result");//포워딩 jsp 이름을 설정
		return mav;
	}
}
