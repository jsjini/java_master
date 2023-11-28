package chap6;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
//		Board[] boards = new Board[100];
		boolean run = true;
		
		Scanner scn = new Scanner(System.in);
		Board exe1 = new Board();
		while(run) {
			System.out.println("1.등록 / 2.목록 / 3.상세조회 / 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1 :
				System.out.print("등록할 계시글번호 입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				System.out.print("등록할 계시글제목 입력>> ");
				String name = scn.nextLine();
				System.out.print("계시글 작성자 입력>> ");
				String person = scn.nextLine();
				System.out.print("계시글 내용 입력>> ");
				String content = scn.nextLine();
				System.out.print("계시글 작성일시 입력>> ");
				String date = scn.nextLine();
				
				Board bod = new Board(no,name,person,content,date);
				if(exe1.addBoard(bod)) {
					System.out.println("게시글이 등록되었습니다.");
				} else {
					System.out.println("등록 실패!");
				}
				break;
			case 2 :
				for(Board boad : exe1.getBoardList()) {
					if(boad != null) {
						boad.showInfo();
					}
				}
				break;
			case 3 :
//				번호: 1 / 제목: 자바게시판입니다
//				작성자: user01
//				내용: 오늘은 숙제로 자바게시판을 만들어봅시다.
//				일시: 2023-11-28
				System.out.println("상세조회할 게시글번호를 입력하세요.");
				no = Integer.parseInt(scn.nextLine());
//				for(int i = 0; i < boards.length; i++) {
//					if(boards[i] != null && boards[i].getBoardNo() == no) {
//						boards[i].showDetail();
//					}
//				}
				Board bor = exe1.getBoard(no);
				if(bor != null) {
					bor.showDetail();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}//end of switch
		}//end of while
		System.out.println("end of prog");
	}//end of main

}//end of class
