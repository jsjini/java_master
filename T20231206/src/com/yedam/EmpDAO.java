package com.yedam;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	List<Employee> lists = new ArrayList<>();

	EmpDAO() {
		lists.add(new Employee("23-11", "홍길동", "943-1234", "2023-10-01", 300));
		lists.add(new Employee("23-12", "김길동", "943-1244", "2023-10-02", 400));
		lists.add(new Employee("23-13", "박길동", "943-1254", "2023-10-03", 500));
	}

	boolean addEmp(Employee data) {
		return lists.add(data);
	}

	void empList() {
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(
					lists.get(i).getEmpNo() + " " + lists.get(i).getEmpName() + " " + lists.get(i).getEmpTel());
		}
	}

	boolean empModi(String input) {
		try {
			String[] inpAry = input.split(" ");
			String empNo1 = inpAry[0];
			int empPay1 = Integer.parseInt(inpAry[1]);
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i).getEmpNo().equals(empNo1)) {
					lists.get(i).setEmpPay(empPay1);
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("수정메뉴얼에 따라 다시 입력하세요.");
		}
		return false;
	}

	boolean removeEmp(String empNo) {
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).getEmpNo().equals(empNo)) {
				lists.remove(i);
				return true;
			}
		}
		return false;
	}

	void empList1(String empDate) {
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).getEmpDate().equals(empDate)) {
				System.out.println(
						lists.get(i).getEmpNo() + " " + lists.get(i).getEmpName() + " " + lists.get(i).getEmpDate());
			}
		}
	}

}
