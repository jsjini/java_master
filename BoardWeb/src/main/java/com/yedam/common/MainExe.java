package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

public class MainExe {
	public static void main(String[] args) {
		
		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		
		BoardVO vo = new BoardVO();
		vo.setContent("더 열심히 공부해라");
		vo.setBoardNo(3);
		
		if(mapper.updateBoard(vo) == 1) {
			System.out.println("수정성공");
		} else {
			System.out.println("수정실패");
		}
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO vo : list) {
//			System.out.println(vo.toString());
//		}
		
		
		
		
		
	}
}
