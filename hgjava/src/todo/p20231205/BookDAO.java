package todo.p20231205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	ArrayList<Book> getBookList() {
		getConn();
		String sql = "select * from book order by 1";
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookNo(rs.getString("book_no"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	boolean addBook(Book std) {
		getConn();
		String sql = "insert into book values(?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getBookNo());
			psmt.setString(2, std.getBookTitle());
			psmt.setString(3, std.getAuthor());
			psmt.setString(4, std.getPress());
			psmt.setInt(5, std.getPrice());

			int r = psmt.executeUpdate();
			if (r > 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	Book getBook(String no) {
		getConn();
		String sql = "select * from book where book_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Book book = new Book();
				book.setBookNo(rs.getString("book_no"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	boolean modifyBook(String no, int price) {
		getConn();
		String sql = "update book\r\n" + "set price = ?\r\n" + "where  book_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setString(2, no);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean removeBook(String bookCode) {
		getConn();
		String sql = "delete from book where book_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
