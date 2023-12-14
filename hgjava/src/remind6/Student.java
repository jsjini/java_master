package remind6;

public class Student {
	private String studentNo; // student_no
	private String studentName;
	private int eng;
	private int math;
	Student(){
		
	}
	
	void showInfo() {
		System.out.println("이름은 " + studentName + "  영어점수는 " + eng + "  수학점수는 " + math + "입니다.");
	}
	
	void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	void setMath(int math) {
		this.math = math;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	String getStudentName() {
		return studentName;
	}
	int getEng() {
		return eng;
	}
	int getMath() {
		return math;
	}
	Student(String studentNo, String studentName,int eng,int math){
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.eng = eng;
		this.math = math;
	}
	
}//end of class
