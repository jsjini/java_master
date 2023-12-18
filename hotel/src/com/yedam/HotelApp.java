package com.yedam;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelApp {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		HotelDAO dao = new HotelDAO();

		System.out.println("저희 호텔에 오신것을 환영합니다^^\n희망하시는 메뉴를 선택해주세요.");
		System.out.println("------------------------------------------------");
		while (run) {
			System.out.println("1.예약 / 2.예약 변경 / 3.객실정보 / 4.프리미엄회원 / 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				String reserveNo = dao.reserveNo();
				System.out.print("예약자 성함 입력>> ");
				String customerName = scn.nextLine();
				String memberGrade = dao.memberGrade(customerName);
				System.out.print("체크인 날짜 입력>> ");
				String checkIn = scn.nextLine();
				System.out.print("체크아웃 날짜 입력>> ");
				String checkOut = scn.nextLine();
				System.out.print("이용가능한 객실 현황");
				dao.roomShowInfo();
				System.out.print("희망하는 객실등급번호 입력>> ");
				int subMenu = Integer.parseInt(scn.nextLine());
				switch (subMenu) {
				case 1:
					ArrayList<HotelRoom> roomAry = dao.getRoomList1();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					break;
				case 2:
					roomAry = dao.getRoomList2();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					break;
				case 3:
					roomAry = dao.getRoomList3();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					break;
				case 4:
					roomAry = dao.getRoomList4();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					break;
				}
				System.out.print("희망하는 객실번호 입력>> ");
				int roomNo = Integer.parseInt(scn.nextLine());
				int roomPrice = dao.roomPrice(roomNo);
				double payment = dao.payment(roomPrice, memberGrade);
				HotelReserve res = new HotelReserve(reserveNo, customerName, checkIn, checkOut, payment, roomNo,
						memberGrade);
				if (dao.addReserve(res)) {
					dao.complete();
				} else {
					System.out.println("예약이 실패하였습니다.\n다시 시도해주세요.");
				}
				break;

			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("프리미엄 회원 메뉴입니다.\n희망하시는 메뉴를 선택해주세요.");
				System.out.println("-------------------------------------");
				boolean run2 = true;
				while (run2) {
					System.out.println("1.회원가입 / 2.회원등급별 정보 / 3.나의 등급조회 / 4.뒤로가기");
					subMenu = Integer.parseInt(scn.nextLine());
					switch (subMenu) {
					case 1:
						System.out.print("회원가입할 고객명 입력>> ");
						String membersName = scn.nextLine();
						System.out.print("전화번호 입력>> ");
						String membersTel = scn.nextLine();
						System.out.print("거주지역 입력>> ");
						String membersArea = scn.nextLine();
						String membersNo = dao.memberNo();
						String membersGrade = "브라운";
						double membersDiscount = 0.03;
						HotelMembers mem = new HotelMembers(membersNo, membersGrade, membersName, membersTel,
								membersArea, membersDiscount);
						if (dao.addMembers(mem)) {
							dao.complete2();
						} else {
							System.out.println("가입이 실패하였습니다.\n다시 시도해주세요.");
						}
						continue;
					case 2:
						dao.information();
						continue;
					case 3:
						System.out.print("조회할 회원의 전화번호 입력>> ");
						membersTel = scn.nextLine();
						try {
						(dao.getCheck(membersTel)).showInfo();
						} catch (NullPointerException e) {
							dao.nonmember();
						}
						continue;
					case 4:
						run2 = false;
					}
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		}
	}

}
