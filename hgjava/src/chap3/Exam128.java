package chap3;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		// ����4
		int penNum = 534;
		int stuNum = 30;
		
		int ppsNum = penNum / stuNum;
		int rempNum = penNum % stuNum;
		System.out.printf("�л��� ���� �� : %d, ���� ���� �� : %d\n",ppsNum,rempNum);
		
		// ����5 -> ����Ÿ�Ժ�ȯ
		
		// ����6
		int value = 356;
		System.out.println(value/100*100); // -56�� ��
		
		// ����7 -> �ε��Ҽ��� ǥ�� ��� 0.1�� 0.1���� ū����
		// ����Ÿ�� ��ȯ (float)0.1   --- �����ε��غ���
		
		// ����8
		// ��ٸ��� �ʺ� = (���� + �Ʒ���) * ���� /2
		int lengthTop = 5;
		int lengthBotton = 10;
		int height = 7;
		double area = ((lengthTop+lengthBotton) * height / 2.0);
		System.out.println(area);
		
		// ����9
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ��: ");
		double num1 = sc.nextDouble();
		
		System.out.println("�� ��° ��: ");
		double num2 = sc.nextDouble();
		
		if(num2 == 0) {
			System.out.println("���:���Ѵ�");
		}else {
			System.out.println("���:"+ num1 / num2);
		}
		
		// ����10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * (Double.parseDouble(var2 + "." + var3));
		System.out.println("���� ����:" + var4);
		
		
		// ����11 : �⺻Ÿ�� ������ �� (==), ����Ÿ�� �� (equals())
		Scanner sc2 = new Scanner(System.in);
		System.out.println("���̵�:");
		String name = sc2.nextLine();
		
		System.out.println("�н�����:");
		String strPassword = sc2.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("�α��� ����");
			} else {
				System.out.println("�α��� ����:�н����尡 Ʋ��");
			}
		} else {
			System.out.println("�α��� ����:���̵� �������� ����");
		}
		
		
		
	}// end main

}// end class
