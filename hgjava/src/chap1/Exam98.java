package chap1;

import java.util.Scanner;

public class Exam98 {

	public static void main(String[] args) {
		//1��
		String name = "���ڹ�";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		System.out.println("�̸�: " + name);
		System.out.print("����: " + age + "\n");
		System.out.printf("��ȭ: %s-%s-%s\n",tel1,tel2,tel3);
		
		//2��
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("ù��° ��:");
		String strNum1 = scanner.nextLine();
		
		System.out.print("�ι�° ��:");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("���� ���:" + result);
		
		//3��
		System.out.print("�̸�?");
		String u_name = scanner.nextLine();
		System.out.print("�ֹι�ȣ �� 6�ڸ�?");
		String u_num = scanner.nextLine();
		System.out.print("��ȭ��ȣ?");
		String u_tel = scanner.nextLine();
		
		System.out.println("1. �̸�: " + u_name);
		System.out.println("2. �ֹι�ȣ �� 6�ڸ�: " + u_num);
		System.out.println("3. ��ȭ��ȣ: " + u_tel);
		
		scanner.close();
		
	}// end main

}// end class
