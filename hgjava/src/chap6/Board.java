package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

@Data

public class Board {
	private int boardNo; // boardNo, board_no
	private String boardName;
	private String person;
	private String content;
	private String date;
	
//	public Board() {
//		
//	}
	
	public void showInfo() {
		System.out.println(boardNo + ". " + boardName + " " + person + " " + date);
	}

	public void showDetail() {
		System.out.println(
				"번호: " + boardNo + " / 제목: " + boardName + "\n작성자: " + person + "\n내용: " + content + "\n일시: " + date);
	}

//	public void setBoardNo(int boardNo) {
//		this.boardNo = boardNo;
//	}
//
//	public void setBoardName(String boardName) {
//		this.boardName = boardName;
//	}
//
//	public void setPerson(String person) {
//		this.person = person;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public int getBoardNo() {
//		return boardNo;
//	}
//
//	public String getBoardName() {
//		return boardName;
//	}
//
//	public String getPerson() {
//		return person;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public String getDate() {
//		return date;
//	}

	public Board(int boardNo, String boardName, String person, String content) {
		Date today = new Date(); // 시스템 시간을 기준으로 생성
		// Date -> String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		this.boardNo = boardNo;
		this.boardName = boardName;
		this.person = person;
		this.content = content;
		this.date = sdf.format(today);
	}

	public Board(int boardNo, String boardName, String person, String content, String date) {
//		this(); // 기본 생성자
		this(boardNo, boardName, person, content);
		this.date = date;
	}
	
}// end of class
