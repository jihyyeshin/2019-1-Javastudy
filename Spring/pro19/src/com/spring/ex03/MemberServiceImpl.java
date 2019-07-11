package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;//주입되는 빈을 저장할 속성 선언

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;//속성 주입
	}

	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
}
