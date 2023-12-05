package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	// 사원정보: 사번/ 이름/ 전화번호/ 입사일자(오늘날짜)/ 급여
	private String empNo;
	private String empName;
	private String empTel;
	private Date empDate;
	private int empPay;

	public Emp(String empNo, String empName, String empTel, int empPay) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = new Date();
		this.empPay = empPay;
	}
	
	public Emp(String empNo, String empName, String empTel, Date empDate, int empPay) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.empPay = empPay;
	}
	
}
