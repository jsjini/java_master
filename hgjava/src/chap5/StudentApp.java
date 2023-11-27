package chap5;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		// 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료
		boolean run = true;
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료");
			int menu = scn.nextInt(); // 3 Enter
			scn.nextLine();
			
			switch(menu) {
			case 1 : 
				System.out.println("학생수 입력>>>");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
			case 2 : 
				System.out.println("점수 입력>>>");
				// for 반복문
				for(int i = 0; i < scores.length; i++) {
					System.out.print("names[" + i + "]>> ");
					names[i] = scn.nextLine();
					System.out.print("scores[" + i + "]>> ");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3 : 
				System.out.println("목록 출력>>>");
				for(int i = 0; i < scores.length; i++) {
					System.out.print("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;
			case 4 : 
				System.out.println("분석>>>");
				// 최고점수 출력 구현
				int maxScores = 0;
				int sum = 0;
				String maxName = "";
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(maxScores < scores[i]) {
						maxScores = scores[i];
						maxName = names[i];
					}
				}
				double avg = (double)sum / scores.length;
				System.out.println(maxName + "의 최고점수 : " + maxScores + ", 평균 : " + avg + ")");
				break;
			case 5 : 
				System.out.println("종료>>>");
				run = false;
				break;
			} // end of switch
		} // end of while
		System.out.println("end of prog.");
		
		
	}//end main

}//end class
