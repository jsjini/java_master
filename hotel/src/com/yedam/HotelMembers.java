package com.yedam;

import lombok.Data;

@Data
public class HotelMembers {
	private String membersNo;
	private String membersGrade;
	private String membersName;
	private String membersTel;
	private String membersArea;
	private double membersDiscount;
	
	HotelMembers(){
		
	}
	
	public HotelMembers(String membersNo, String membersGrade, String membersName, String membersTel, String membersArea, double membersDiscount) {
		this.membersNo = membersNo;
		this.membersGrade = membersGrade;
		this.membersName = membersName;
		this.membersTel = membersTel;
		this.membersArea = membersArea;
		this.membersDiscount = membersDiscount;
	}

	void showInfo() {
		System.out.println("------ [나의 등급] ----------");
		System.out.println("회원님은 ["+membersGrade+"] 등급입니다.\n적용되는 할인율은 [ "+(int)(membersDiscount*100)+" % ]입니다.");
		System.out.println("------------------------------------------------");
	}
	
}
