package com.yedam;


import lombok.Data;

@Data
public class HotelReserve {
	private String reserveNo;
	private String customerName;
	private String checkIn;
	private String checkOut;
	private int payment;
	private int roomNo;
	private String memberGrade;
	
	HotelReserve() {

	}

	public HotelReserve(String reserveNo, String customerName, String checkIn, String checkOut, int payment, int roomNo, String memberGrade) {
		this.reserveNo = reserveNo;
		this.customerName = customerName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.payment = payment;
		this.roomNo = roomNo;
		this.memberGrade = memberGrade;
	}

	
}
