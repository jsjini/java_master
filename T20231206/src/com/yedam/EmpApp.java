package com.yedam;

import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		EmpDAO exe = new EmpDAO();

		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.print("사번입력>> ");
				String empNo = scn.nextLine();
				System.out.print("이름입력>> ");
				String empName = scn.nextLine();
				System.out.print("전화번호입력>> ");
				String empTel = scn.nextLine();
				System.out.print("입사일입력>> ");
				String empDate = scn.nextLine();
				System.out.print("급여입력>> ");
				try {
					int empPay = Integer.parseInt(scn.nextLine());
					Employee data = new Employee(empNo, empName, empTel, empDate, empPay);
					if (exe.addEmp(data)) {
						System.out.println("저장되었습니다.");
					} else {
						System.out.println("저장 중 오류발생!");
					}
				} catch (NumberFormatException e) {
					System.out.println("급여에는 숫자만 입력하세요.");
				}
				break;
			case 2:
				System.out.println("사번   이름   전화번호");
				exe.empList();
				break;
			case 3:
				System.out.print("사번 급여>> ");
				String input = scn.nextLine();
				if (exe.empModi(input)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 4:
				System.out.print("사번>> ");
				empNo = scn.nextLine();
				if (exe.removeEmp(empNo)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("일치하는 사번이 없습니다.");
				}
				break;
			case 5:
				System.out.print("입사일자>> ");
				empDate = scn.nextLine();
				System.out.println("사번   이름  입사일자");
				exe.empList1(empDate);
				break;
			case 6:
				System.out.println("종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog");
	}
}
