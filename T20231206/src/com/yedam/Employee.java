package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Employee {
	Date date = new Date();
	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
	private int empPay;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Employee(String empNo, String empName, String empTel, int empPay) {

		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = sdf.format(date);
		this.empPay = empPay;
	}

	public Employee(String empNo, String empName, String empTel, String empDate, int empPay) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.empPay = empPay;
	}

	void showInfo() {
		System.out.println(empNo + " " + empName + " " + empDate + "\n");
	}
}
