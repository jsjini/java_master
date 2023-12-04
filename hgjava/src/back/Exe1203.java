package back;

import java.util.Scanner;

public class Exe1203 {
	public static void main(String[] args) {
		byte b = 5;
		int c = -b;
//		b = -b;
		int result = 10 / c;
		System.out.println(result);

		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);

		boolean stop = true;
		while (!stop) {

		}

		int pencils = 534;
		int students = 30;
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);

		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);

		int var1 = 5;
		int var2 = 2;
		double var3 = (double) var1 / var2;
		int var4 = (int) (var3 * var2);
		System.out.println(var4);

		int value = 356;
		System.out.println(value / 100 * 100);

		double var10 = 10f;
		double var20 = var10 / 100;
		if (var20 == 0.1) {
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}

		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println(area);

		Scanner scn = new Scanner(System.in);
//		System.out.print("첫 번째 수: ");
//		double aa = scn.nextDouble();
//		System.out.print("두 번째 수: ");
//		double bb = scn.nextDouble();
//		System.out.println("--------------");
//		if (bb != 0 || bb != 0.0) {
//			System.out.println("결과:" + (aa / bb));
//		} else {
//			System.out.println("결과:무한대");
//		}

		int var11 = 10;
		int var22 = 3;
		int var33 = 14;
		double var44 = var11 * var11 * Double.parseDouble(var22 + "." + var33);
		System.out.println("원의 넓이" + var44);

//		System.out.print("아이디:");
//		String name = scn.nextLine();
//		System.out.print("패스워드:");
//		String strPassword = scn.nextLine();
//		int password = Integer.parseInt(strPassword);
//		if (name.equals("java")) {
//			if (password == 12345) {
//				System.out.println("로그인 성공");
//			} else {
//				System.out.println("로그인 실패:패스워드가 틀림");
//			}
//		} else {
//			System.out.println("로그인 실패:아이디가 존재하지 않음");
//		}

		int num = (int) (Math.random() * 6) + 1;
		System.out.println(num);
	}
}
