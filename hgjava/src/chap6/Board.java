package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	int boardNo;
	String boardName;
	String person;
	String content;
	String date;

	void showInfo() {
		System.out.println(boardNo + ". " + boardName + " " + person + " " + date);
	}

	void showDetail() {
		System.out.println(
				"번호: " + boardNo + " / 제목: " + boardName + "\n작성자: " + person + "\n내용: " + content + "\n일시: " + date);
	}

	void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	void setPerson(String person) {
		this.person = person;
	}

	void setContent(String content) {
		this.content = content;
	}

	void setDate(String date) {
		this.date = date;
	}

	int getBoardNo() {
		return boardNo;
	}

	String getBoardName() {
		return boardName;
	}

	String getPerson() {
		return person;
	}

	String getContent() {
		return content;
	}

	String getDate() {
		return date;
	}

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
		this.boardNo = boardNo;
		this.boardName = boardName;
		this.person = person;
		this.content = content;
		this.date = date;
	}
	
}// end of class
