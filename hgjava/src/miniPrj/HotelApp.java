package miniPrj;

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
				String reserveNo = dao.reserveNo();
				System.out.println("예약자명 입력>> ");
				String customerName = scn.nextLine();
				System.out.println("체크인날짜 입력>> ");
				String checkIn = scn.nextLine();
				System.out.println("체크아웃날짜 입력>> ");
				String checkOut = scn.nextLine();
				
				System.out.println("이용가능한 객실 현황");
				ArrayList<HotelRoom> roomAry = dao.getRoomList();
				for (HotelRoom room : roomAry) {
					if (room != null) {
						room.roomShowInfo();
					}
				}
				System.out.println("희망하는 객실의 번호를 입력>> ");
				String roomNo = scn.nextLine();
				int submenu = Integer.parseInt(scn.nextLine());
				switch (submenu) {
				
				}
				
				int payment = dao.payment();

				HotelReserve std = new HotelReserve(reserveNo, customerName, checkIn, checkOut, payment);
				
				
			}
		}
	}

	
}
