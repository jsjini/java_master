package chap5;

import java.util.Scanner;

public class WhileExe1 {

	public static void main(String[] args) {
		// for: 반복횟수가 정해져 있는 경우
		
		// while: 조건을 만족하는 동안 반복
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("문자값을 입력>>>");
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("종료합니다.");
				break;
			}
			System.out.println("입력값은 " + txt);
		}
		System.out.println("end of prog.");
		
			
	}//end main

}//end class
