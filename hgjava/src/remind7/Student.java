package remind7;

import lombok.Data;

@Data
public class Student {
	String studentNo;
	String studentName;
	int eng;
	int math;

	public Student(String studentNo, String studentName, int eng, int math) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.eng = eng;
		this.math = math;
	}

	void showInfo() {
		System.out.println("이름은 " + studentName + "  영어점수는 " + eng + "  수학점수는 " + math + "입니다.");
	}

}// end of class
