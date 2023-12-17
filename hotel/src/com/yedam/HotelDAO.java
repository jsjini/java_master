package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	HotelRoom room = new HotelRoom();

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

	void reserveExe() {
		getConn();
		String sql = "insert into test1 (test_1) values ('No_' || reserve_seq.nextval)";
		try {
			psmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	String reserveNo() {
		getConn();
		String sql = "select test_1 from test1";
		String reserveNo = "";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				reserveNo = rs.getString("test_1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserveNo;

	}

	int RoomGrade1() {
		getConn();
		String sql = "select count(room_state)\r\n" + "from room\r\n" + "where room_grade = '스탠다드'\r\n"
				+ "and room_state = 'empty'";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_state)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gradeCnt;
	}

	int RoomGrade2() {
		getConn();
		String sql = "select count(room_state)\r\n" + "from room\r\n" + "where room_grade = '프리미어'\r\n"
				+ "and room_state = 'empty'";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_state)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gradeCnt;
	}

	int RoomGrade3() {
		getConn();
		String sql = "select count(room_state)\r\n" + "from room\r\n" + "where room_grade = '스위트'\r\n"
				+ "and room_state = 'empty'";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_state)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gradeCnt;
	}

	int RoomGrade4() {
		getConn();
		String sql = "select count(room_state)\r\n" + "from room\r\n" + "where room_grade = '로열 스위트'\r\n"
				+ "and room_state = 'empty'";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_state)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gradeCnt;
	}

	ArrayList<HotelRoom> getRoomList1() {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade= '스탠다드'\r\n" + "and room_state = 'empty'";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HotelRoom room = new HotelRoom();
				room.setRoomNo(rs.getString("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	ArrayList<HotelRoom> getRoomList2() {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade= '프리미어'\r\n" + "and room_state = 'empty'";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HotelRoom room = new HotelRoom();
				room.setRoomNo(rs.getString("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	ArrayList<HotelRoom> getRoomList3() {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade= '스위트'\r\n" + "and room_state = 'empty'";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HotelRoom room = new HotelRoom();
				room.setRoomNo(rs.getString("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	ArrayList<HotelRoom> getRoomList4() {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade= '로열 스위트'\r\n" + "and room_state = 'empty'";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HotelRoom room = new HotelRoom();
				room.setRoomNo(rs.getString("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	void roomShowInfo() {
		System.out.println("1.스탠다드 " + RoomGrade1());
		System.out.println("2.프리미어 " + RoomGrade2());
		System.out.println("3.스위트 " + RoomGrade3());
		System.out.println("4.로열 스위트 " + RoomGrade4());
	}

//	HotelRoom getRoom(String roomNo) {
//		getConn();
//		String sql = "select room_grade\r\n" + "from room\r\n" + "where room_no = ?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, roomNo);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				HotelRoom room = new HotelRoom();
//				room.setRoomNo(rs.getString("room_no"));
//				room.setRoomGrade(rs.getString("room_grade"));
//				return room;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	String payment(String roomNo) {

		return "";
	}

	boolean addReserve(HotelReserve res) {
		getConn();
		String sql = "insert into reserve\r\n" + "values(?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, res.getReserveNo());
			psmt.setString(2, res.getCustomerName());
			psmt.setString(3, res.getCheckIn());
			psmt.setString(4, res.getCheckOut());
			psmt.setInt(5, res.getPayment());
			psmt.setString(6, res.getRoomNo());

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

	void complete() {
		System.out.println("객실예약이 완료되었습니다.");
		getConn();
		String sql = "select members_grade, members_discount,\r\n" + "room_price + (room_price*members_discount)\r\n"
				+ "from reserve\r\n" + "where reserve_no = (select testSeq.currval from reserve)";

	}

}
