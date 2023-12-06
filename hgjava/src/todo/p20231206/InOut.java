package todo.p20231206;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class InOut {
	Date date = new Date();
	private String prodCode;
	private String date2;
	private int prodQuan;
	private String buySell;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public InOut(String proCode, String buySell, int prodQuan2, String date2) {
		this.prodCode = prodCode;
		this.prodQuan = prodQuan;
		this.buySell = buySell;
		this.date2 = date2;
	}

	public InOut(String proCode, String proNum, String buySell) {
		this.prodCode = prodCode;
		this.prodQuan = prodQuan;
		this.buySell = buySell;
		this.date2 = sdf.format(date);
	}

	void showInfo2() {
		System.out.printf("%6s %8s %9d %3s\n", prodCode, date2, prodQuan, buySell);
	}
}
