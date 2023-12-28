package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class GetMemberControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 글번호 조회
				String id = req.getParameter("id");

				MemberService svc = new MemberServiceImpl();
				MemberVO vo = svc.getMember(id);

				req.setAttribute("vo", vo);

				// 페이지 이동(forward)
				RequestDispatcher rd = req.getRequestDispatcher("admin/getMember.tiles");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
	}

}
