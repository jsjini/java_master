package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	private String bookNo;
	private String bookName;
	private String writer;
	private String publisher;
	private int bookPrice;

	public Book(String bookNo, String bookName, String writer, String publisher, int bookPrice) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.bookPrice = bookPrice;
	}

	void showInfo() {
		System.out.printf("%-5s %-7s %-5s %-6d", bookNo, bookName, writer, bookPrice);
	}
}
