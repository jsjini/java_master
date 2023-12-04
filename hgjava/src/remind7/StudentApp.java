package remind7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1 : // 등록하기
				System.out.print("학생번호를 입력하세요>> ");
				String studentNo = scn.nextLine();
				System.out.print("학생이름을 입력하세요>> ");
				String studentName = scn.nextLine();
				System.out.print("영어점수를 입력하세요>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수를 입력하세요>> ");
				int math = Integer.parseInt(scn.nextLine());
				students.add(new Student(studentNo, studentName, eng, math));
				System.out.println("저장되었습니다.");
//				if(exe.addStudent(students) {
//					System.out.println("저장되었습니다.");
//				} else {
//					System.out.println("저장 중 오류발생!");
//				}
				break;
			case 2 : // 목록보기
				for(Student stdnt : exe.getStudentList()) {
					if(stdnt != null) {
						stdnt.showInfo();
					}
				} 
				break;
			case 3 : // 단건조회.
				System.out.print("조회할 학생번호를 입력하세요>> ");
				studentNo = scn.nextLine();
				Student stnt = (Student) exe.getStudent(studentNo);
				if(stnt != null) {
					stnt.showInfo();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
			case 4 : // 수정
				System.out.print("수정할 학생번호를 입력하세요>> ");
				studentNo = scn.nextLine();
				System.out.print("수정할 영어점수를 입력하세요>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("수정할 수학점수를 입력하세요>> ");
				math = Integer.parseInt(scn.nextLine());
				if(exe.modifyStudent(studentNo, eng, math)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 5 : // 삭제 학생이름으로 찾기 / 해당위치 null 로 하기.
				System.out.print("삭제할 학생이름을 입력하세요>> ");
				studentName = scn.nextLine();
				if(exe.removeStudent(studentName)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 6 :
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}//end of switch
			
		}//end of while
		System.out.println("end of prog");
		
		
	}//end of main

}//end of class
