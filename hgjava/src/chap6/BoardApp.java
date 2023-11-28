package chap6;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Board[] boards = new Board[100];
		System.out.println("1.등록 / 2.목록 / 3.상세조회 / 4.종료");
		int menu = Integer.parseInt(scn.nextLine());
		while(run) {
			switch(menu) {
			case 1 :
				System.out.print("등록할 계시글번호 입력>> ");
				String no = scn.nextLine();
				System.out.print("등록할 계시글제목 입력>> ");
				String name = scn.nextLine();
				System.out.print("계시글 작성자 입력>> ");
				String person = scn.nextLine();
				System.out.print("계시글 내용 입력>> ");
				String content = scn.nextLine();
				System.out.print("계시글 작성일시 입력>> ");
				String date = scn.nextLine();
				
				Board bod = new Board(no,name,person,content,date);
				
				
			}//end of switch
		}//end of while
	}//end of main

}//end of class
