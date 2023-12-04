package remind7;
// 추가/수정/삭제/목록/단건조회

import java.util.ArrayList;
import java.util.List;

import remind7.Student;

public class StudentExe {

	List<Student> students = new ArrayList<>();

//	 추가
//	boolean addStudent(Student std) {
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i) == null) {
//				students.get(i) = std;
//				return true; // 메소드에서 return문은 메소드의 끝.
//			}
//		}
//		return false;
//	}

	// 목록
	List<Student> getStudentList() {
		for (int i =0; i < students.size();i++) {
			return (List<Student>) students.get(i);
		}
		return students;
		
	}

	// 단건조회
	List<Student> getStudent(String studentNo) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentNo().equals(studentNo)) {
				return (List<Student>) students.get(i);
			}
		}
		return null;
	}

	// 수정
	boolean modifyStudent(String studentNo, int eng, int math) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentNo().equals(studentNo)) {
				students.get(i).setEng(eng);
				students.get(i).setMath(math);
				return true;
			}
		}
		return false;
	}

	// 삭제
	boolean removeStudent(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentName().equals(name)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}
}// end of class
