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
		String sql = "insert into test1 (test_1) values ('HRN' || reserve_seq.nextval)";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	String reserveNo() {
		reserveExe();
		getConn();
		String sql = "select test_1\r\n" + "FROM(\r\n" + "    SELECT \r\n" + "        test_1 \r\n"
				+ "    FROM test1\r\n" + "    ORDER BY ROWNUM DESC)\r\n" + "WHERE ROWNUM = 1";
		String reserveNo = "";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				reserveNo = rs.getString("test_1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reserveNo;
	}

	String memberGrade(String customerName) {
		String grade = "일반";
		getConn();
		String sql = "select members_grade, members_name\r\n" + "from members\r\n" + "where members_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, customerName);
			rs = psmt.executeQuery();
			if (rs.next()) {
				grade = rs.getString("members_grade"); // 수정함 return rs.getString("members_grade")
			}
		} catch (SQLException e) {
			return grade;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return grade;
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
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomFloor(rs.getInt("room_floor"));
				room.setRoomView(rs.getString("room_view"));
				room.setRoomPrice(rs.getString("room_price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rooms;
	}

	void roomShowInfo() {
		System.out.println("1.스탠다드 " + RoomGrade1());
		System.out.println("2.프리미어 " + RoomGrade2());
		System.out.println("3.스위트 " + RoomGrade3());
		System.out.println("4.로열 스위트 " + RoomGrade4());
	}

	int roomPrice(int roomNo) {
		getConn();
		String sql = "select room_price\r\n" + "from room\r\n" + "where room_no = ?";
		int roomPrice = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, roomNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				roomPrice = rs.getInt("room_price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roomPrice;
	}

	double payment(int roomPrice, String memberGrade) {
		double paymemt = 0;
		if (memberGrade == "일반") {
			paymemt = roomPrice;
		} else if (memberGrade == "브라운") {
			paymemt = roomPrice * 1.03;
		} else if (memberGrade == "실버") {
			paymemt = roomPrice * 1.05;
		} else if (memberGrade == "골드") {
			paymemt = roomPrice * 1.07;
		} else if (memberGrade == "다이아몬드") {
			paymemt = roomPrice * 1.10;
		}
		return paymemt;
	}

	boolean addReserve(HotelReserve res) {
		getConn();
		String sql = "insert into reserve\r\n" + "values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, res.getReserveNo());
			psmt.setString(2, res.getCustomerName());
			psmt.setString(3, res.getCheckIn());
			psmt.setString(4, res.getCheckOut());
			psmt.setDouble(5, res.getPayment());
			psmt.setInt(6, res.getRoomNo());
			psmt.setString(7, res.getMemberGrade());
			int r = psmt.executeUpdate();
			if (r > 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	void complete() {
		System.out.println("객실예약이 완료되었습니다.");
		System.out.println("----------  [예약정보]  -----------------");
		getConn();
		String sql = "select members_grade, members_discount,\r\n" + "room_price + (room_price*members_discount)\r\n"
				+ "from reserve\r\n" + "where reserve_no = (select testSeq.currval from reserve)";

	}

	void membersExe() {
		getConn();
		String sql = "insert into test2 (test_2) values ('HMN' || members_seq.nextval)";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	String memberNo() {
		membersExe();
		getConn();
		String sql = "select test_2\r\n" + "from(select test_2 \r\n" + "    from test2\r\n"
				+ "    order by rownum desc)\r\n" + "where rownum = 1";
		String membersNo = "";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				membersNo = rs.getString("test_2");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return membersNo;
	}

	boolean addMembers(HotelMembers mem) {
		getConn();
		String sql = "insert into members\r\n" + "values(?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMembersNo());
			psmt.setString(2, mem.getMembersGrade());
			psmt.setString(3, mem.getMembersName());
			psmt.setString(4, mem.getMembersTel());
			psmt.setString(5, mem.getMembersArea());
			psmt.setDouble(6, mem.getMembersDiscount());
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

	void complete2() {
		System.out.println("회원가입이 완료되었습니다.\n감사합니다 ^_^");
		System.out.println("------------------------------------------------");
	}

	void information() {
		System.out.println(" [등급]\t\t   [조건]\t\t     [혜택]");
		System.out.println("------------------------------------------------");
		System.out.println(" 일반\t\t비회원\t\t   없음");
		System.out.println(" 브라운\t\t회원가입시\t\t   객실 3% 할인");
		System.out.println(" 실버\t\t연간 1박 숙박시\t   객실 5% 할인");
		System.out.println(" 골드\t\t연간 10박 숙박시\t   객실 7% 할인");
		System.out.println(" 다이아몬드\t\t연간 50박 숙박시\t   객실 10% 할인");
		System.out.println("------------------------------------------------");
	}

	HotelMembers getCheck(String membersTel) {
		getConn();
		String sql = "select * from members where members_tel = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, membersTel);
			rs = psmt.executeQuery();
			if (rs.next()) {
				HotelMembers members = new HotelMembers();
				members.setMembersNo(rs.getString("members_no"));
				members.setMembersGrade(rs.getString("members_grade"));
				members.setMembersName(rs.getString("members_name"));
				members.setMembersTel(rs.getString("members_tel"));
				members.setMembersArea(rs.getString("members_area"));
				members.setMembersDiscount(rs.getDouble("members_discount"));
				return members;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	void nonmember() {
		System.out.println("-------- [회원정보] ------------");
		System.out.println("회원님은 [일반] 등급입니다.\n적용되는 할인율은 [ 0 % ]입니다.\n회원가입시 [브라운] 등급으로 상승됩니다.");
		System.out.println("------------------------------------------------");
	}

}
