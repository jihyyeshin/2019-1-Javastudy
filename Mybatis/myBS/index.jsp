<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 삽입 -->

<%@page import="com.test.sqlMap.SqlSessionManager"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
    SqlSession sqlSession = sqlSessionFactory.openSession();
	int cnt=0;
    try{

        // 단일 값 가져오기

        cnt = sqlSession.selectOne("Test.getCount") ;
        System.out.println("전체 Cnt : " + cnt);
        // 단일행 가져오기
        HashMap hm = sqlSession.selectOne("Test.getContents") ;
        // 리스트 가져오기
        List list = sqlSession.selectList("Test.getList") ;
        // 가져온 리스트 사용하기
        if(list.size() > 0){
            for(int i=0; i < list.size(); i++){
                HashMap rs = (HashMap)list.get(i) ;
            }
        }
        // String parameter 넘겨서 단일 값 가져오기
        String name = "신지혜";
        int pCnt = sqlSession.selectOne("Test.getCountP", name) ;
        // HashMap parameter 넘겨서 단일 행 가져오기
        HashMap pHm = new HashMap();
        pHm.put("name", "홍길동") ;
        pHm.put("age", "28") ;       
        HashMap pRs = sqlSession.selectOne("Test.getContentsP", pHm) ;
    }catch(Exception e){
        e.printStackTrace() ;
    }finally{
        sqlSession.close() ;
    }
%>
	<h1>hello world</h1>
	<h1><%=cnt %></h1>
</body>
</html>