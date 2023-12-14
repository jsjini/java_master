package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	private String bookNo;
	private String bookTitle;
	private String author;
	private String press;
	private int price;

	Book() {

	}

	public Book(String bookNo, String bookTitle, String author, String press, int price) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
		this.press = press;
		this.price = price;
	}

	// 메소드 정의.
	void showInfo() {
		System.out.println(bookNo + "   " + bookTitle + "   " + author + "   " + price);
	}

}
