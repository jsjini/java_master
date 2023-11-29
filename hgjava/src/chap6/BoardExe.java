package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;

// 저장소: boards
public class BoardExe {
	private Board[] boards;

	BoardExe() {
		boards = new Board[100];
	}

	// 초기값 생성
	void initData() {
		boards[0] = new Board(1, "첫번째 글", "user01", "오늘은 숙제로 자바게시판을 만들어봅시다.", "2023-11-28");
		boards[1] = new Board(2, "두번째 글", "user02", "오늘은 숙제로 자바게시판을 만들면서 공부합니다.", "2023-11-29");
		// boards[2] <---- 5번글.
		boards[3] = new Board(4, "네번째 글", "user03", "기대되는구만!", "2023-11-30");
		boards[2] = new Board(3, "세번째 글", "user03", "기대되는구만!");
		boards[4] = new Board(5, "다섯번째 글", "user03", "기대되는구만!");
		boards[5] = new Board(6, "여섯번째 글", "user03", "기대되는구만!");
		boards[6] = new Board(7, "일곱번째 글", "user03", "기대되는구만!");
		boards[7] = new Board(8, "여덟번째 글", "user03", "기대되는구만!");
		
	}

	// 등록
	boolean addBoard(Board board) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				return true; // 메소드에서 return문은 메소드의 끝.
			}
		}
		return false;
	}

	// 목록 - 반환값: 배열
	Board[] BoardList() {
//		 boards => 새로운 배열에 정렬된 값으로 반환.
		Board temp = null;
		for (int i = 0; i < boards.length - 1; i++) {
			for (int j = 0; j < boards.length - 1; j++) {
				if (boards[j] != null && boards[j + 1] != null) {
					if (boards[j].getBoardNo() > boards[j + 1].getBoardNo()) {
						temp = boards[j];
						boards[j] = boards[j + 1];
						boards[j + 1] = temp;
					}
				}
			}
		}
		return boards;
	}// end of BoardList()

	//배열, 페이지 => 페이지의 5건을 반환
	Board[] pageList(Board[] ary, int page) {
		Board[] resultAry = new Board[5];
		int start = (page - 1) * 5;
		int end = page * 5;
		int j = 0;
		for(int i = 0; i<ary.length; i++) {
			if(i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}
	
	// 단건조회 - 매개변수: 글번호, 반환값: Board
	Board getBoard(int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				return boards[i];
			}
		}
		return null;
	}

	// 신규번호: 현재글번호+1
	int getSequence() {
		int seqNo = 1;
		// 배열에서 글번호의 max값 가져오기
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() > max) {
				max = boards[i].getBoardNo();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}

	// 수정 - 매개값(글번호, 내용) => boolean
	boolean modBoard(int no, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i].setContent(content);
				boards[i].setDate(sdf.format(today));
				return true;
			}
		}
		return false;
	}

	// 삭제 - 매개값(글번호) => boolean
	boolean remBoard(int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 사용자가 해당글번호의 수정, 삭제권한 체크 = 권한있으면 true, 없으면 false
	boolean checkResponsibility(String id, int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == no && boards[i].getPerson().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	// 게시글을 담고 있는 배열에서 값이 있는 건수를 반환
	int getBoardCount() {
		int realCnt = 0;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}

}// end of class
