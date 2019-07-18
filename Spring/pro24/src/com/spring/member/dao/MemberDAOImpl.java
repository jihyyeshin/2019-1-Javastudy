package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> memberList=null;
		memberList=sqlSession.selectList("mapper.member.selectAllMemberList");
		return memberList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result=sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result=sqlSession.delete("mapper.member.deleteMembr", id);
		return result;
	}

}
