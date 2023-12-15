package miniPrj;

import lombok.Data;

@Data
public class HotelRoom {
	private String roomNo;
	private String roomGrade;
	private int roomFloor;
	private String roomView;
	private int roomPrice;
	private String roomState;

	HotelRoom() {

	}

	public HotelRoom(String roomNo, String roomGrade, int roomFloor, String roomView, int roomPrice, String roomState) {
		this.roomNo = roomNo;
		this.roomGrade = roomGrade;
		this.roomFloor = roomFloor;
		this.roomView = roomView;
		this.roomPrice = roomPrice;
		this.roomState = roomState;
	}
	
	void roomShowInfo() {
		System.out.println();
		System.out.println("이용가능한 객실 현황");
		System.out.println("1. "+ roomGrade + "이용가능한 객실 현황");
		System.out.println(bookNo + "   " + bookTitle + "   " + author + "   " + price);
	}
}
