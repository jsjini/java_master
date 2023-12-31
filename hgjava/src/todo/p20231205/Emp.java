package todo.p20231205;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	// 사원정보: 사번/ 이름/ 전화번호/ 입사일자(오늘날짜)/ 급여
	Date date = new Date();
	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
	private int empPay;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Emp(String empNo, String empName, String empTel, int empPay) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = sdf.format(date);
		this.empPay = empPay;
	}
	
	public Emp(String empNo, String empName, String empTel, String empDate, int empPay) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.empPay = empPay;
	}
	
	void showInfo() {
		System.out.printf(empNo + " " + empName+ " "+ empTel+ " " + empDate + " " + empPay + "\n");
	}
	
}
