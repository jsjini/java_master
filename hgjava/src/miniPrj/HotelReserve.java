package miniPrj;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class HotelReserve {
	private String reserveNo;
	private String customerName;
	private String checkIn;
	private String checkOut;
	private int payment;
	
	HotelReserve() {

	}

	public HotelReserve(String reserveNo, String customerName, String checkIn, String checkOut, int payment) {
		this.reserveNo = reserveNo;
		this.customerName = customerName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.payment = payment;
	}

	
}
