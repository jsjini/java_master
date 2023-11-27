package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		//문제2 : 3의 배수 합
		int sum3 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum3 += i;
			}
		}
		System.out.println(sum3);

		//문제3
		int nun1=0;
		int nun2=0;
		while(nun1+nun2 != 5) {
			nun1 = (int)(Math.random()*6)+1;
			nun2 = (int)(Math.random()*6)+1;
			System.out.println("("+nun1+","+nun2+")");
		}
		
		//문제4
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				int he = 4*x + 5*y;
				if(he == 60) {
					System.out.printf("(%d, %d)\n",x,y);
				}
			}
		}
		
		//문제5
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//문제6
		for(int i = 1; i <= 4; i++) {
			for(int b = 4; b > i; b--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//문제7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int num = scanner.nextInt();
			switch(num) {
			case 1:
				System.out.print("예금액> ");
				balance += scanner.nextInt();
				break;
			case 2:
				System.out.print("출금액> ");
				int num2 = scanner.nextInt();
				if(balance < num2) {
					System.out.println("잔고가 부족합니다");
				}else {
				balance -= num2;
				}
				break;
			case 3:
				System.out.println("잔고> "+ balance);
				break;
			case 4:
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		
		
		
	}// end main

}//end class
