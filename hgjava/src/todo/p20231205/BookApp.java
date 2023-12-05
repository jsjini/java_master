package todo.p20231205;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BookExe exe = new BookExe();

		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			System.out.println("============================");
			try {
				int menu = Integer.parseInt(scn.nextLine());
				switch (menu) {
				case 1:
					exe.getBookadd();
					break;
				case 2:
					exe.getBookList();
					break;
				case 3:
					exe.getModify();
					break;
				case 4:
					exe.getRemove();
					break;
				case 5:
					System.out.println("종료합니다");
					run = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자 1, 2, 3, 4, 5 중 하나만 입력하세요");
				continue;
			}
		}
	}
}
