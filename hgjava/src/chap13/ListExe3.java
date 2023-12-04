package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Member> members = new ArrayList<>();
		boolean run = true;
		// 회원등록(회원번호, 이름, 포인트)
		// 1.등록 2.이름조회 3.포인트변경 4.삭제(회원번호 1건만가지고 삭제) 5.종료
		while (run) {
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.print("회원등록할 번호 입력>> ");
				String memberNo = scn.nextLine();
				System.out.print("회원등록할 이름 입력>> ");
				String memberName = scn.nextLine();
				System.out.print("포인트 입력>> ");
				int point = Integer.parseInt(scn.nextLine());
				members.add(new Member(memberNo, memberName, point));
				break;
			case 2:
				System.out.print("조회할 이름 입력>> ");
				memberName = scn.nextLine();
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberName().equals(memberName)) {
						System.out.println(members.get(i));
						break;
					}
				}
				break;
			case 3:
				System.out.print("포인트 변경할 회원이름>> ");
				memberName = scn.nextLine();
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberName().indexOf(memberName) != -1) {
						System.out.print("변경할 포인트 입력>> ");
						point = Integer.parseInt(scn.nextLine());
						members.get(i).setPoint(point);
						System.out.println("포인트 변경이 완료되었습니다.");
						break;
					} 
				}
				break;
			case 4:
				System.out.print("삭제할 회원번호 입력>> ");
				memberNo = scn.nextLine();
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberNo().indexOf(memberNo) != -1) {
						members.remove(i);
						System.out.println("삭제되었습니다.");
						break;
					}
				}
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
			}

		}

	}
}
