package com.yedam.student.vo;

public class Student {
	// db 칼럼명과 이름 맞춰야함.
	private String studentNo; // student_no
	private String studentName;
	private int eng;
	private int math;
	
	public Student(){
	}
	
	public void showInfo() {
		System.out.println("이름은 " + studentName + "  영어점수는 " + eng + "  수학점수는 " + math + "입니다.");
	}
	
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public Student(String studentNo, String studentName,int eng,int math){
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.eng = eng;
		this.math = math;
	}
	
}//end of class
