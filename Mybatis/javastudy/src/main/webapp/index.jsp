<p><%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@page import="com.test.sqlMap.SqlSessionManager"%>
	<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
	<%@page import="org.apache.ibatis.session.SqlSession"%>
	<%@page import="java.util.*"%>
	<%
		SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 단일 값 가져오기
			int cnt = sqlSession.selectOne("Test.getCount");
			// 단일행 가져오기
			HashMap hm = sqlSession.selectOne("Test.getConents");
			// 리스트 가져오기
			List list = sqlSession.selectList("Test.getList");
			// 가져온 리스트 사용하기
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					HashMap rs = (HashMap) list.get(i);
				}
			}
			// String parameter 넘겨서 단일 값 가져오기
			String name = "홍길동";
			int pCnt = sqlSession.selectOne("Test.getCountP", name);

			// HashMap parameter 넘겨서 단일 행 가져오기
			HashMap pHm = new HashMap();
			pHm.put("name", "홍길동");
			pHm.put("age", "28");

			HashMap pRs = sqlSession.selectOne("Test.getConentsP", pHm);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	%>
</p>
