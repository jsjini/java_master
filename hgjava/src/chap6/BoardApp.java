package chap6;

import java.util.Scanner;

// M(odel) V(iew) C(ontrol)
public class BoardApp {
	// static BoardExe exe = new BoardExe();
	// 데이터마다 다른 정보를 담을 필요가 없는 클래스는 static 멤버로 선언
	private Scanner scn = new Scanner(System.in);
	private String id = null;
	
	// 싱글톤 방식의 인스턴스 생성 p279
	private static BoardApp instance = new BoardApp();
	
	// 생성자
	private BoardApp() {
	}
	
	public static BoardApp getInstance() {
		return instance;
	}
	
	private void boardAdd(){
		System.out.print("등록할 계시글제목 입력>> ");
		String name = scn.nextLine();
		System.out.print("계시글 내용 입력>> ");
		String content = scn.nextLine();
//		System.out.print("계시글 작성일시 입력>> ");
//		String date = scn.nextLine();

		Board board = new Board(BoardExe.getSequence(), name, id, content);
		if (BoardExe.addBoard(board)) {
			System.out.println("게시글이 등록되었습니다.");
		} else {
			System.out.println("등록 실패!");
		}
	}// end of boardAdd
	
	private void boardList(){
		Board[] boardAry = BoardExe.BoardList();
		showList(boardAry, 1);
		while (true) {
			int page = Integer.parseInt(scn.nextLine());
			if (page == 0) {
				break;
			}
			showList(boardAry, page);
		}
	}// end of boardList
	
	private void getBoard() {
		System.out.println("조회할 게시글번호를 입력하세요.");
		int no = Integer.parseInt(scn.nextLine());
		Board result = BoardExe.getBoard(no);
		if (result != null) {
			result.showDetail();
		} else {
			System.out.println("존재하지 않는 정보");
		}
	}// end of getBoard
	
	private void boardEdit(){
		System.out.println("수정할 게시글번호를 입력하세요.");
		int no = Integer.parseInt(scn.nextLine());
		System.out.println("수정할 내용을 입력하세요.");
		String content = scn.nextLine();
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("수정 권한이 없습니다.");
//			continue;
			return;
		}
		if (BoardExe.modBoard(no, content)) {
			System.out.println("게시글이 수정되었습니다.");
		} else {
			System.out.println("수정 실패!");
		}
	}// end of boardEdit
	
	private void boardDel(){
		System.out.println("삭제할 게시글번호를 입력하세요.");
		int no = Integer.parseInt(scn.nextLine());
		// 권한 체크...
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("삭제 권한이 없습니다.");
//			continue;
			return;
		}

		if (BoardExe.remBoard(no)) {
			System.out.println("게시글이 삭제되었습니다.");
		} else {
			System.out.println("삭제 실패!");
		}
	}// end of boardDel
	
	public void start() {
		
		boolean run = true;
		

		UserExe uexe = new UserExe();

		while (true) { //로그인 처리
			System.out.println("아이디를 입력하세요.");
			id = scn.nextLine();
			System.out.println("패스워드를 입력하세요.");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다!!");
				break;
			} else {
				System.out.println("id, pw를 재확인하세요.");
			}
		}

		// 초기값 생성
		BoardExe.initData();

		while (run) {
			System.out.println("1.등록 / 2.목록 / 3.상세조회 / 4.수정 / 5.삭제 / 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 글등록
				boardAdd();
				break;
			case 2: // 목록보기 -> 페이지보기.
				boardList();
				break;
			case 3: // 단건조회
				getBoard();
				break;
			case 4: // 수정
				boardEdit();
				break;
			case 5: // 삭제
				boardDel();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}// end of switch

		} // end of while
		System.out.println("end of prog");
	}// end of main

	private void showList(Board[] boardAry, int page) {
		// 페이징처리
		Board[] pageAry = BoardExe.pageList(boardAry, page);
		for (Board brd : pageAry) {
			if (brd != null) {
				brd.showInfo();
			}
		}
		// 전체페이지 계산하고 출력
		int cnt = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);
		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지를 선택하세요. (종료: 0 입력)");
	}

}// end of class
