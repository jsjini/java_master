package com.yedam;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelApp {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		HotelDAO dao = new HotelDAO();

		System.out.println("저희 호텔에 오신것을 환영합니다^^\n희망하는 메뉴번호를 입력해주세요.");
		System.out.println("-------------------------------------------------------");
		while (run) {
			System.out.println("1.예약 / 2.예약 변경 / 3.객실 / 4.프리미엄 회원 / 5.종료");
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
				dao.roomShowInfo();
				System.out.print("희망하는 객실등급번호 입력>> ");
				int subMenu = Integer.parseInt(scn.nextLine());
				switch (subMenu) {
				case 1:
					System.out.println();
					System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
					ArrayList<HotelRoom> roomAry = dao.getRoomList1();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
					roomAry = dao.getRoomList2();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					System.out.println();
					break;
				case 3:
					System.out.println();
					System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
					roomAry = dao.getRoomList3();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
					roomAry = dao.getRoomList4();
					for (HotelRoom room : roomAry) {
						room.roomShowInfo1();
					}
					System.out.println();
					break;
				}
				System.out.print("희망하는 객실번호 입력>> ");
				int roomNo = Integer.parseInt(scn.nextLine());
				double roomPrice = dao.roomPrice(roomNo);
				double payment = dao.payment(roomPrice, memberGrade);
				HotelReserve res = new HotelReserve(reserveNo, customerName, checkIn, checkOut, payment, roomNo,
						memberGrade);
				if (dao.addReserve(res)) {
					dao.complete(res.getReserveNo());
				} else {
					System.out.println("예약이 실패하였습니다.\n다시 시도해주세요.");
				}
				break;
			case 2:
				boolean run2 = true;
				while (run2) {
					System.out.print("변경하실 예약번호 입력>> ");
					reserveNo = scn.nextLine();
					
					dao.reserveCheck(reserveNo);
					System.out.println("1.체크인&아웃 날짜 변경 / 2.객실 변경 / 3.예약 취소 / 4.뒤로 가기");
					System.out.print("희망하는 메뉴 번호 입력>> ");
					subMenu = Integer.parseInt(scn.nextLine());
					switch (subMenu) {
					case 1:
						System.out.print("변경할 체크인 날짜 입력>> ");
						checkIn = scn.nextLine();
						System.out.print("변경할 체크아웃 날짜 입력>> ");
						checkOut = scn.nextLine();
						if (dao.modifyCheck(checkIn, checkOut, reserveNo)) {
							System.out.println();
							System.out.println("날짜 변경이 완료되었습니다.");
							System.out.println();
						} else {
							System.out.println("변경 실패. 다시 시도해주세요.");
						}
						break;
					case 2:
						dao.roomShowInfo();
						System.out.print("희망하는 객실등급번호 입력>> ");
						subMenu = Integer.parseInt(scn.nextLine());
						switch (subMenu) {
						case 1:
							System.out.println();
							System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
							ArrayList<HotelRoom> roomAry = dao.getRoomList1();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							System.out.println();
							break;
						case 2:
							System.out.println();
							System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
							roomAry = dao.getRoomList2();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							System.out.println();
							break;
						case 3:
							System.out.println();
							System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
							roomAry = dao.getRoomList3();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							System.out.println();
							break;
						case 4:
							System.out.println();
							System.out.println("[객실번호]\t [층수]\t[전망]\t[객실가격]");
							roomAry = dao.getRoomList4();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							System.out.println();
							break;
						}
						System.out.print("희망하는 객실번호 입력>> ");
						roomNo = Integer.parseInt(scn.nextLine());
						roomPrice = dao.roomPrice(roomNo);
						memberGrade = dao.memberGrade2(reserveNo);
						payment = dao.payment(roomPrice, memberGrade);
						if (dao.modifyRoom(roomNo, reserveNo, payment)) {
							System.out.println();
							System.out.println("객실 변경이 완료되었습니다.");
							System.out.println();
						} else {
							System.out.println("변경 실패. 다시 시도해주세요.");
						}
						break;
					case 3:
						System.out.println("정말로 예약 취소하시겠습니까??");
						System.out.println("1.네 / 2.아니오");
						String answer = scn.nextLine();
						if (answer.equals("네") || answer.equals("1")) {
							if (dao.removeReserve(reserveNo)) {
								System.out.println();
								System.out.println("예약 취소가 완료되었습니다.");
								System.out.println();
							} else {
								System.out.println("취소 실패. 다시 시도해주세요.");
							}
						} else {
							System.out.println("메인메뉴로 돌아갑니다.");
							break;
						}
						break;
					case 4:
						run2 = false;
					}
					break;
				}
				break;
			case 3:
				System.out.println("객실 메뉴입니다.\n희망하는 메뉴번호를 입력해주세요.");
				System.out.println("-----------------------------------------------------------");
				boolean run3 = true;
				while (run3) {
					System.out.println("1.객실등급별 정보 / 2.예약가능한 객실조회 / 3.뒤로 가기");
					subMenu = Integer.parseInt(scn.nextLine());
					switch (subMenu) {
					case 1:
						System.out.println("[객실등급]");
						System.out.println("1.스탠다드 / 2.프리미어 / 3.스위트 / 4.로열 스위트");
						System.out.print("희망하는 객실등급번호 입력>> ");
						subMenu = Integer.parseInt(scn.nextLine());
						switch (subMenu) {
						case 1:
							dao.roomInpo1();
							continue;
						case 2:
							dao.roomInpo2();
							continue;
						case 3:
							dao.roomInpo3();
							continue;
						case 4:
							dao.roomInpo4();
							continue;
						}
						break;
					case 2:
						System.out.print("[예약가능한 객실 현황]");
						dao.roomShowInfo();
						System.out.print("희망하는 객실등급번호 입력>> ");
						subMenu = Integer.parseInt(scn.nextLine());
						switch (subMenu) {
						case 1:
							ArrayList<HotelRoom> roomAry = dao.getRoomList1();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							continue;
						case 2:
							roomAry = dao.getRoomList2();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							continue;
						case 3:
							roomAry = dao.getRoomList3();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							continue;
						case 4:
							roomAry = dao.getRoomList4();
							for (HotelRoom room : roomAry) {
								room.roomShowInfo1();
							}
							continue;
						}
					case 3:
						run3 = false;
					}
				}
				break;
			case 4:
				System.out.println("프리미엄 회원 메뉴입니다.\n희망하는 메뉴번호를 입력해주세요.");
				System.out.println("-------------------------------------------------------");
				boolean run4 = true;
				while (run4) {
					System.out.println("1.회원가입 / 2.회원등급별 정보 / 3.나의 등급조회 / 4.뒤로 가기");
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
						run4 = false;
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
