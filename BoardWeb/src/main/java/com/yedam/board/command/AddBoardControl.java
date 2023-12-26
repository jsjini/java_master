package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 파라미터(3개) 받은 값으로 db에 인서트 후 목록페이지 출력
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		BoardService svc = new BoardServiceMybatis();

		boolean add = svc.addBoard(board);

		try {
			if (add) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("boardForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
