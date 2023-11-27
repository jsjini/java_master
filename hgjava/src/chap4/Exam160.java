package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		//����2 : 3�� ��� ��
		int sum3 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum3 += i;
			}
		}
		System.out.println(sum3);

		//����3
		int nun1=0;
		int nun2=0;
		while(nun1+nun2 != 5) {
			nun1 = (int)(Math.random()*6)+1;
			nun2 = (int)(Math.random()*6)+1;
			System.out.println("("+nun1+","+nun2+")");
		}
		
		//����4
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				int he = 4*x + 5*y;
				if(he == 60) {
					System.out.printf("(%d, %d)\n",x,y);
				}
			}
		}
		
		//����5
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//����6
		for(int i = 1; i <= 4; i++) {
			for(int b = 4; b > i; b--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//����7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("----------------------------");
			System.out.print("����> ");
			int num = scanner.nextInt();
			switch(num) {
			case 1:
				System.out.print("���ݾ�> ");
				balance += scanner.nextInt();
				break;
			case 2:
				System.out.print("��ݾ�> ");
				int num2 = scanner.nextInt();
				if(balance < num2) {
					System.out.println("�ܰ� �����մϴ�");
				}else {
				balance -= num2;
				}
				break;
			case 3:
				System.out.println("�ܰ�> "+ balance);
				break;
			case 4:
				System.out.println("���α׷� ����");
				run = false;
			}
		}
		
		
		
	}// end main

}//end class
