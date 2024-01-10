package com.yedam.member.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;
import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String id, String pw);
	public List<MemberVO> memberList();
	public MemberVO getMember(String id);
	public boolean addMember(MemberVO vo);
	// 등록, 삭제
	public boolean addMember2(MemberVO vo);
	public boolean removeMember(String id);
	
}
