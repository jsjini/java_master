package todo.p20231205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookExe {
	Scanner scn = new Scanner(System.in);
	List<Book> books = new ArrayList<>();

	BookExe() {
		books.add(new Book("B001", "이것이 자바다", "신용권", "이지스", 25000));
		books.add(new Book("C003", "자바 기초", "김재원", "퍼블리싱", 25000));
		books.add(new Book("D001", "자바마스터", "홍길동", "자바출판", 25000));
	}

	void getBookadd() {
		System.out.println("1번-선택");
		System.out.println("1)도서코드입력>> ");
		String bookNo = scn.nextLine();
		System.out.println("2)도서명입력>> ");
		String bookName = scn.nextLine();
		System.out.println("3)저자입력>> ");
		String writer = scn.nextLine();
		System.out.println("4)출판사입력>> ");
		String publisher = scn.nextLine();
		System.out.println("5)가격입력>> ");
		try {
			int bookPrice = Integer.parseInt(scn.nextLine());
			books.add(new Book(bookNo, bookName, writer, publisher, bookPrice));
		} catch (NumberFormatException e) {
			System.out.println("저장 실패");
			System.out.println("가격에는 숫자만 입력하세요!");
			return;
		}
		System.out.println("저장되었습니다");
	}

	void getBookList() {
		System.out.println("2번-선택");
		System.out.println("도서코드   도서명\t 저자\t가격");
		for (int i = 0; i < books.size(); i++) {
			books.get(i).showInfo();
			System.out.println();
		}
	}

	void getModify() {
		System.out.println("3번-선택");
		System.out.println("1)도서코드입력>> ");
		String bookNo = scn.nextLine();
		System.out.println("2)가격입력>> ");
		try {
			int bookPrice = Integer.parseInt(scn.nextLine());
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getBookNo().equals(bookNo)) {
					books.get(i).setBookPrice(bookPrice);
					System.out.println("수정되었습니다");

				}
			}
		} catch (NumberFormatException e) {
			System.out.println("가격은 숫자로만 입력하세요!");
		}
	}

	void getRemove() {
		System.out.println("4번-선택");
		System.out.println("1)도서코드입력>> ");
		String bookNo = scn.nextLine();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNo().equals(bookNo)) {
				books.remove(i);
				System.out.println("삭제되었습니다");
			}
		}
	}
}
