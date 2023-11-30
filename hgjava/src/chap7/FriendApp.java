package chap7;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
	static FriendExe exe = new FriendExe();
//	static Friend[] storage = new Friend[10];

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 / 2.목록 / 3.조회 / 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 등록
				addFriend();
				break;
			case 2: // 목록
				friendList();
				break;
			case 3: // 상세
				getFriend();
				break;
			default: // 종료
				System.out.println("종료합니다.");
				run = false;
			}
		}

	} // end of main

	private static void addFriend() {
		System.out.println("1.친구 / 2.학교 / 3.회사");
		int subMenu = Integer.parseInt(scn.nextLine());

		Friend friend = null;

//		case 1 : // 이름, 연락처
		System.out.println("이름>>> ");
		String name = scn.nextLine();
		System.out.println("연락처>>> ");
		String phone = scn.nextLine();
		if (subMenu == 1) {
			friend = new Friend(name, phone); // Friend 인스턴스
		} else if (subMenu == 2) {
//		case 2 : // 이름, 연락처, 학교, 전공
			System.out.println("학교>>> ");
			String univ = scn.nextLine();
			System.out.println("전공>>> ");
			String major = scn.nextLine();
			friend = new UnivFriend(name, phone, univ, major);
		} else if (subMenu == 3) {
//		case 3 : // 이름, 연락처, 회사, 부서
			System.out.println("회사>>> ");
			String comp = scn.nextLine();
			System.out.println("부서>>> ");
			String dept = scn.nextLine();
			friend = new CompFriend(name, phone, comp, dept);
		}
		// 배열에 추가
//		for (int i = 0; i < storage.length; i++) {
//			if (storage[i] == null) {
//				storage[i] = friend;
//				break;
//			}
//		}
		if (exe.addFriend(friend)) {
			System.out.println("저장완료~!");
		} else {
			System.out.println("저장실패ㅜㅜ");
		}
	}// 등록

	private static void friendList() {
//		for (Friend fnd : storage) {
//			if (fnd != null) {
//				System.out.println(fnd.showInfo());
//			}
//		}
		exe.friendList();
	}// 목록

	private static void getFriend() {
		// 이름조회, 연락처조회
		while (true) {
			System.out.println("1.이름 / 2.연락처");
			int subMenu = Integer.parseInt(scn.nextLine());
			String searchCond = "";
			if (subMenu == 1) {
				System.out.println("이름을 입력하세요>>> ");
				searchCond = scn.nextLine();
//				for (Friend fnd : storage) {
//					if (fnd != null && fnd.getName().equals(searchCond)) {
//						System.out.println(fnd.showInfo());
//					}
//				}
				Friend[] list = exe.searchFriend(searchCond);
				for (int i = 0; i < list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i].showInfo());
					}
				}
				break;
			} else if (subMenu == 2) {
				System.out.println("연락처를 입력하세요>>> ");
				searchCond = scn.nextLine();
//				for (Friend fnd : storage) {
//					if (fnd != null && fnd.getPhone().equals(searchCond)) {
//						System.out.println(fnd.showInfo());
//					}
//				}
				exe.searchPhone(searchCond);
				
				break;
			} else {
				System.out.println("'1' 또는 '2' 중에서 선택하세요.");
				continue;
			}
		}
	}// 조회

	void backup() {
		Friend parent = new Friend();
		parent.setName("홍길동");
		parent.setPhone("010-1111");
		System.out.println(parent.toString());

		UnivFriend child = new UnivFriend();
		child.setName("김철수");
		child.setPhone("010-2222");
		child.setUniv("구미대학교");
		child.setMajor("컴퓨터공학과");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10];
		friends[0] = parent;
		friends[1] = child;
	}

}// end of class
