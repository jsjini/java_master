package chap5;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("학생 정보 입력>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student();
			System.out.println("학생의 이름을 입력하세요>> ");
			student.name = scn.nextLine();
			System.out.println("학생의 점수를 입력하세요>> ");
			student.score = Integer.parseInt(scn.nextLine());
			System.out.println("학생의 성별을 입력하세요>> ");
			student.gender = scn.nextLine();
			students[i] = student;
		}
	} // end of addStudent()
	
	public static void searchStudent() {
		System.out.println("조회할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		// 학생이름 - 점수 출력
		for(Student i : students) {
			if(name.equals(i.name)) {
			System.out.println("학생이름: " + i.name + "\t점수: " + i.score);
			exists = true;
			}
		}
		// 찾는 이름의 존재여부: exists 를 확인
		if(!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}
	} // end of searchStudent()
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student stn : students) {
			if(stn.gender.equals("남")) {
				sumOfMen += stn.score;
				cntOfMen++;
			}else if(stn.gender.equals("여")) {
				sumOfWomen += stn.score;
				cntOfWomen++;
			}
		}
		System.out.println("남학생의 평균: " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("여학생의 평균: " + (sumOfWomen * 1.0 / cntOfWomen));
		
	}//end of analysis()
	
	public static void modify() {
		// 이름입력 -> 변경 점수
		System.out.println("수정할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < students.length; i++) {
			// 조건추가 => 변경점수 입력
			if(name.equals(students[i].name)){
				System.out.println("수정할 점수 입력하세요");
				students[i].score = scn.nextInt();
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("해당 이름 없음!");
		}
		// 찾는 이름 없음
		
	}//end of modify()

	public static void main(String[] args) {
		boolean run = true;
		
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.학생 수 2.학생 정보 입력 3.조회 4.분석(최고점수, 평균) 5.수정 6.종료");
			int menu = scn.nextInt(); // 3 Enter
			scn.nextLine();
			
			switch(menu) {
			case 1 : 
				System.out.println("학생 수 입력>> ");
				studentNum = Integer.parseInt(scn.nextLine()); // "3" -> 3 (형변환)
				students = new Student[studentNum];
				break;
			case 2 : 
				addStudent();
				break;
			case 3 :
				searchStudent();
				break;
			case 4 : // 분석
				analysis();
				break;
			case 5 : // 수정
				modify();
				break;
			case 6 : 
				System.out.println("종료합니다,");
				run = false;
			}
		}//end of while
	}//end of main
}//end of class
