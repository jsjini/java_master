package chap6;

public class Board {
	int boardNo;
	String boardName;
	String person;
	String content;
	String date;

	// 이 부분이 변경되었습니다.
	
	void showInfo() {
		System.out.println(boardNo + ". " + boardName + " " + person);
	}
	void showDetail() {
		System.out.println("번호: " + boardNo + " / 제목: " + boardName + "\n작성자: " + person + "\n내용: " + content + "\n일시: " + date);
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

	Board(int boardNo, String boardName, String person, String content, String date){
		this.boardNo = boardNo;
		this.boardName = boardName;
		this.person = person;
		this.content = content;
		this.date = date;
	}
	
	
	private Board[] boards;
	
	Board() {
		boards = new Board[3];
		
		boards[0] = new Board(1,"자바게시판입니다","user01","오늘은 숙제로 자바게시판을 만들어봅시다.","2023-11-28");
		boards[1] = new Board(2,"공부합니다","user02","오늘은 숙제로 자바게시판을 만들면서 공부합니다.","2023-11-28");
	}
	
	

	boolean addBoard(Board bod) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = bod;
				return true; // 메소드에서 return문은 메소드의 끝.
			}
		}
		return false;
	}
	
	Board[] getBoardList() {
		return boards;
	}
	
	Board getBoard(int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == no) {
				return boards[i];
			}
		}
		return null;
	}
	
}//end of class
