package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends = null;

	public static void addFriend() {
		System.out.println("친구 정보 입력>> ");
		for(int i = 0; i < friends.length; i++) {
			Friend friend = new Friend();
			System.out.println("친구의 이름을 입력하세요>> ");
			friend.name = scn.nextLine();
			System.out.println("친구의 전화번호를 입력하세요>> ");
			friend.tel = scn.nextLine();
			System.out.println("친구의 혈액형을 입력하세요>> ");
			friend.blood = scn.nextLine();
			friends[i] = friend;
		}
	}
	
	public static void modify() {
		System.out.println("수정할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < friends.length; i++) {
			if(name.equals(friends[i].name)){
				System.out.println("수정할 전화번호를 입력하세요");
				friends[i].tel = scn.nextLine();
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("해당 이름 없음!");
		}
	}
	
	public static void main(String[] args) {
		boolean run = true;
		int friendNum = 0;
		while(run) {
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5.종료");
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
			case 1 :
				System.out.println("친구 수 입력>> ");
				friendNum = scn.nextInt();
				friends = new Friend[friendNum];
				break;
			case 2 :
				addFriend();
				break;
			case 3 :
				System.out.println("목록 출력>>>");
				for(Friend i : friends) {
					System.out.print("이름: " + i.name  + "\t 전화번호: " + i.tel + "\t혈액형: " + i.blood + "\n");
				}
				break;
			case 4 : 
				modify();
				break;
			case 5 : 
				System.out.println("종료합니다.");
				run = false;
			}
		}
	}

}
