package chap6;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
//		Student[] students = new Student[100];
		boolean run = true;
		
		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1 : // 등록하기
				System.out.print("학생번호를 입력하세요>> ");
				String no = scn.nextLine();
				System.out.print("학생이름을 입력하세요>> ");
				String name = scn.nextLine();
				System.out.print("영어점수를 입력하세요>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수를 입력하세요>> ");
				int math = Integer.parseInt(scn.nextLine());
				
				Student std = new Student(no, name, eng, math);
				// students 배열에 한건 저장
//				for (int i = 0; i < students.length; i++) {
//					if(students[i] == null) {
//						students[i] = std;
//						break;
//					}
//				}
				if(exe.addStudent(std)) {
					System.out.println("저장되었습니다.");
				} else {
					System.out.println("저장 중 오류발생!");
				}
				
				break;
			case 2 : // 목록보기
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null) {
//						students[i].showInfo();
//					}
//				}
				for(Student stdnt : exe.getStudentList()) {
					if(stdnt != null) {
						stdnt.showInfo();
					}
				} // Student[] 타입
				break;
			case 3 : // 단건조회.
				System.out.print("조회할 학생번호를 입력하세요>> ");
				no = scn.nextLine();
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStudentNo().equals(no)) {
//						students[i].showInfo();
//					}
//				}
				Student stnt = exe.getStudent(no);
				if(stnt != null) {
					stnt.showInfo();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
			case 4 : // 수정
				System.out.print("수정할 학생번호를 입력하세요>> ");
				no = scn.nextLine();
				System.out.print("수정할 영어점수를 입력하세요>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("수정할 수학점수를 입력하세요>> ");
				math = Integer.parseInt(scn.nextLine());
				if(exe.modifyStudent(no, eng, math)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 5 : // 삭제 학생이름으로 찾기 /해당위치 null로 하기.
				System.out.print("삭제할 학생이름을 입력하세요>> ");
				name = scn.nextLine();
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStudentName().equals(name)) {
//						students[i] = null;
//					}
//				}
				if(exe.removeStudent(name)) {
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
