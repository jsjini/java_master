package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		// 사원정보: 사번/ 이름/ 전화번호/ 입사일자(공백이면 -> 오늘날짜)/ 급여
		// 메뉴: 등록/ 목록/ 수정(급여)/ 삭제/ 조회(조건:입사일자)
		Scanner scn = new Scanner(System.in);
		List<Emp> lists = new ArrayList<>();

		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.println("사번을 입력하세요");
				String empNo = scn.nextLine();
				System.out.println("이름을 입력하세요");
				String empName = scn.nextLine();
				System.out.println("전화번호를 입력하세요");
				String empTel = scn.nextLine();
				System.out.println("입사일자를 입력하세요");
//				Date empDate = scn.nextLine();
				System.out.println("급여를 입력하세요");
				int empPay = Integer.parseInt(scn.nextLine());
//				lists.add(new Emp(empNo, empName, empTel, empDate, empPay));
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("종료합니다");
				run = false;
			}
		}
		System.out.println("end of prog");
	}
}
