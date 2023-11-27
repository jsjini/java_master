package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1 ~ 50 : 369게임
		
		// 3,6,9 갯수 체크 변수
		
		// 숫자 1~50 반복문
		System.out.print(" ");
		for(int i = 1; i <= 50; i++) {
			if((int)(i / 10) == 3 && i % 10 == 3){
				System.out.print("♥♥");
			}else if((int)i / 10 == 3) {
				System.out.print("♥");
			}else if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print("♥");
			}else {	
				System.out.print(i);
			}
		    if(i%10 == 0) {
		    	System.out.println();
		    }
		    System.out.print(" ");
		}
		
		int cnt = 0;
		for(int i = 1; i <= 50; i++) {
			cnt = 0;
			if(i%10 == 3 || i%10 == 6 || i%10 == 9) cnt++;
			if(i/10 == 3 || i/10 == 6 || i/10 == 9) cnt++;
			
			switch(cnt) {
			case 0 : System.out.print(i + "\t"); break;
			case 1 : System.out.print("♥\t"); break;
			case 2 : System.out.print("♥♥\t");
			}
			
			if(i%10 == 0) System.out.println();
		}
			// 일의 자리에 3,6,9 갯수 체크
		
			// 십의 자리에 3,6,9 갯수 체크
		// 갯수가 0 -> 숫자
		// 갯수가 1 -> ♥
		// 갯수가 2 -> ♥♥
		
		// 동전 교환
		Scanner sc = new Scanner(System.in);
//		System.out.print("##교환할 금액 : ");
//		int money = sc.nextInt();
//		System.out.println("500원 짜리 : " + money / 500 + "개");
//		int remoney = money % 500;
//		System.out.println("100원 짜리 : " + remoney / 100 + "개");
//		remoney %= 100;
//		System.out.println("50원 짜리 : " + remoney / 50 + "개");
//		remoney %= 50;
//		System.out.println("10원 짜리 : " + remoney / 10 + "개");
//		remoney %= 10;
//		System.out.println("교환 금액 : " + (money-remoney) + "원");
//		System.out.println("남은 금액 : " + remoney + "원");
//
//		
//		// 숫자 추측 게임
//		int com = ((int)(Math.random()*100)+1);
//		while(true) {
//			System.out.print("숫자 입력 : ");
//			int mynum = sc.nextInt();
//			if(mynum == com) {
//				System.out.println("축하합니다!!^^");
//				break;
//			}else if(mynum > com){
//				System.out.println("down하세요!!!");
//			}else {
//				System.out.println("up하세요!!!");
//			}
//		}
		
		// 윤달 계산 프로그램
		System.out.println("##년도 입력 : ");
		int year = sc.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "년은 윤년입니다.");
		}else {
			System.out.println(year + "년은 평년입니다.");
		}
		
		
	}// end main

}// end class
