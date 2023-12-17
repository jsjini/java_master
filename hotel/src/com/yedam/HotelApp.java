package com.yedam;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelApp {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		HotelDAO dao = new HotelDAO();

		while (run) {
			System.out.println("1.예약 / 2.예약 변경 / 3.객실정보 / 4.프리미엄회원 / 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				dao.reserveExe();
				String reserveNo = dao.reserveNo();
				System.out.println("예약자명 입력>> ");
				String customerName = scn.nextLine();
				System.out.println("체크인날짜 입력>> ");
				String checkIn = scn.nextLine();
				System.out.println("체크아웃날짜 입력>> ");
				String checkOut = scn.nextLine();
				System.out.println("이용가능한 객실 현황");
				dao.roomShowInfo();
				System.out.println("희망하는 객실등급번호 입력>> ");
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
				System.out.println("희망하는 객실번호 입력>> ");
				String roomNo = scn.nextLine();
//				(dao.getRoom(roomNo)).roomShowInfo2();
				int payment = Integer.parseInt(dao.payment(roomNo));
				
				HotelReserve res = new HotelReserve(reserveNo, customerName, checkIn, checkOut, payment, roomNo);
				if(dao.addReserve(res)) {
					dao.complete();
				} else {
					System.out.println("예약이 실패하였습니다.\n다시 시도해주세요.");
				}
				break;
				
			}
		}
	}

}
