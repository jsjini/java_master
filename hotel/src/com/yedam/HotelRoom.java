package com.yedam;

import lombok.Data;

@Data
public class HotelRoom {
	private String roomNo;
	private String roomGrade;
	private int roomFloor;
	private String roomView;
	private String roomPrice;
	private String roomState;

	HotelRoom() {

	}

	public HotelRoom(String roomNo, String roomGrade, int roomFloor, String roomView, String roomPrice, String roomState) {
		this.roomNo = roomNo;
		this.roomGrade = roomGrade;
		this.roomFloor = roomFloor;
		this.roomView = roomView;
		this.roomPrice = roomPrice;
		this.roomState = roomState;
	}

	void roomShowInfo1() {
		System.out.println("객실번호: " + getRoomNo() + " / 층수: " + getRoomFloor() + " / 전망: " + getRoomView()
				+ " / 가격:" + getRoomPrice());
	}
	void roomShowInfo2() {
		System.out.println("객실번호: " + getRoomNo() + " / 객실등급: " + getRoomGrade()+ "예약 완료되었습니다.\t기타문의사항은 유선으로 연락주세요.");
	}
	
	
}
