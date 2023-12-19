package com.yedam;

import lombok.Data;

@Data
public class HotelRoom {
	private int roomNo;
	private String roomGrade;
	private int roomFloor;
	private String roomView;
	private String roomPrice;
	private String roomState;

	HotelRoom() {

	}

	public HotelRoom(int roomNo, String roomGrade, int roomFloor, String roomView, String roomPrice, String roomState) {
		this.roomNo = roomNo;
		this.roomGrade = roomGrade;
		this.roomFloor = roomFloor;
		this.roomView = roomView;
		this.roomPrice = roomPrice;
		this.roomState = roomState;
	}

	void roomShowInfo1() {
		System.out.println("  " + getRoomNo() + "\t  " + getRoomFloor() + "층\t " + getRoomView()
				+ "  " + getRoomPrice());
	}
//	void roomShowInfo2() {
//		System.out.println("객실번호: " + getRoomNo() + " / 객실등급: " + getRoomGrade()+ "\n객실이 선택되었습니다.");
//	}
	
	
}
