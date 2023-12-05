package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String word = "CDK v2 applications for best practices using a combination on available rule packs";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();
		for (String str : words) {
			list.add(str);
		}

		boolean run = true;

		long start = System.currentTimeMillis();
		while (run) {
			// 목록출력하고....
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " / ");
			}
			System.out.println();
			word = scn.nextLine();
			// 입력값과 목록값을 비교해서 있으면 제거
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(word)) {
					list.remove(i);
					System.out.println("남은 단어수: " + list.size());
				}
			}
			if (list.size() == 0) {
				run = false;
			}
			// 시작시점부터 종료시점까지 걸린시간을 초단위로 계산
			// 완료하는데 35초가 걸렸습니다.
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린시간: " + (end - start) / 1000 + "초");
		System.out.println("end of game");
	}
}
