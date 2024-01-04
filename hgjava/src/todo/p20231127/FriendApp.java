package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends = null;

	public static void addFriend() {
		System.out.println("ģ�� ���� �Է�>> ");
		for(int i = 0; i < friends.length; i++) {
			Friend friend = new Friend();
			System.out.println("ģ���� �̸��� �Է��ϼ���>> ");
			friend.name = scn.nextLine();
			System.out.println("ģ���� ��ȭ��ȣ�� �Է��ϼ���>> ");
			friend.tel = scn.nextLine();
			System.out.println("ģ���� �������� �Է��ϼ���>> ");
			friend.blood = scn.nextLine();
			friends[i] = friend;
		}
	}
	
	public static void modify() {
		System.out.println("������ �̸� �Է�>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < friends.length; i++) {
			if(name.equals(friends[i].name)){
				System.out.println("������ ��ȭ��ȣ�� �Է��ϼ���");
				friends[i].tel = scn.nextLine();
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("�ش� �̸� ����!");
		}
	}
	
	public static void main(String[] args) {
		boolean run = true;
		int friendNum = 0;
		while(run) {
			System.out.println("1.ģ���� 2.�Է� 3.��� 4.���� 5.����");
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
			case 1 :
				System.out.println("ģ�� �� �Է�>> ");
				friendNum = scn.nextInt();
				friends = new Friend[friendNum];
				break;
			case 2 :
				addFriend();
				break;
			case 3 :
				System.out.println("��� ���>>>");
				for(Friend i : friends) {
					System.out.print("�̸�: " + i.name  + "\t ��ȭ��ȣ: " + i.tel + "\t������: " + i.blood + "\n");
				}
				break;
			case 4 : 
				modify();
				break;
			case 5 : 
				System.out.println("�����մϴ�.");
				run = false;
			}
		}
	}

}
