package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1 ~ 50 : 369����
		
		// 3,6,9 ���� üũ ����
		
		// ���� 1~50 �ݺ���
		System.out.print(" ");
		for(int i = 1; i <= 50; i++) {
			if((int)(i / 10) == 3 && i % 10 == 3){
				System.out.print("����");
			}else if((int)i / 10 == 3) {
				System.out.print("��");
			}else if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print("��");
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
			case 1 : System.out.print("��\t"); break;
			case 2 : System.out.print("����\t");
			}
			
			if(i%10 == 0) System.out.println();
		}
			// ���� �ڸ��� 3,6,9 ���� üũ
		
			// ���� �ڸ��� 3,6,9 ���� üũ
		// ������ 0 -> ����
		// ������ 1 -> ��
		// ������ 2 -> ����
		
		// ���� ��ȯ
		Scanner sc = new Scanner(System.in);
//		System.out.print("##��ȯ�� �ݾ� : ");
//		int money = sc.nextInt();
//		System.out.println("500�� ¥�� : " + money / 500 + "��");
//		int remoney = money % 500;
//		System.out.println("100�� ¥�� : " + remoney / 100 + "��");
//		remoney %= 100;
//		System.out.println("50�� ¥�� : " + remoney / 50 + "��");
//		remoney %= 50;
//		System.out.println("10�� ¥�� : " + remoney / 10 + "��");
//		remoney %= 10;
//		System.out.println("��ȯ �ݾ� : " + (money-remoney) + "��");
//		System.out.println("���� �ݾ� : " + remoney + "��");
//
//		
//		// ���� ���� ����
//		int com = ((int)(Math.random()*100)+1);
//		while(true) {
//			System.out.print("���� �Է� : ");
//			int mynum = sc.nextInt();
//			if(mynum == com) {
//				System.out.println("�����մϴ�!!^^");
//				break;
//			}else if(mynum > com){
//				System.out.println("down�ϼ���!!!");
//			}else {
//				System.out.println("up�ϼ���!!!");
//			}
//		}
		
		// ���� ��� ���α׷�
		System.out.println("##�⵵ �Է� : ");
		int year = sc.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "���� �����Դϴ�.");
		}else {
			System.out.println(year + "���� ����Դϴ�.");
		}
		
		
	}// end main

}// end class
