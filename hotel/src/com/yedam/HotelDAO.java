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
		String url = "jdbc:oracle:thin:@192.168.0.25:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("연결성공!!");
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
				grade = rs.getString("members_grade");
			} else {
				return grade;
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
		return grade;
	}

	int RoomGrade1(String checkIn, String checkOut) {
		getConn();

		String sql = "select count(room_no)\r\n" + "from room\r\n" + "where room_grade = '스탠다드'\r\n"
				+ "and room_no NOT IN (select room_no\r\n" + "                     from reserve \r\n"
				+ "                     where check_in >= ? \r\n" + "                     and check_out <= ?)";

		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_no)");
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

	int RoomGrade2(String checkIn, String checkOut) {
		getConn();
		String sql = "select count(room_no)\r\n" + "from room\r\n" + "where room_grade = '프리미어'\r\n"
				+ "and room_no NOT IN (select room_no\r\n" + "                     from reserve \r\n"
				+ "                     where check_in >= ? \r\n" + "                     and check_out <= ?)";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_no)");
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

	int RoomGrade3(String checkIn, String checkOut) {
		getConn();
		String sql = "select count(room_no)\r\n" + "from room\r\n" + "where room_grade = '스위트'\r\n"
				+ "and room_no NOT IN (select room_no\r\n" + "                     from reserve \r\n"
				+ "                     where check_in >= ? \r\n" + "                     and check_out <= ?)";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_no)");
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

	int RoomGrade4(String checkIn, String checkOut) {
		getConn();
		String sql = "select count(room_no)\r\n" + "from room\r\n" + "where room_grade = '로열 스위트'\r\n"
				+ "and room_no NOT IN (select room_no\r\n" + "                     from reserve \r\n"
				+ "                     where check_in >= ? \r\n" + "                     and check_out <= ?)";
		int gradeCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
			rs = psmt.executeQuery();
			if (rs.next()) {
				gradeCnt = rs.getInt("count(room_no)");
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

	ArrayList<HotelRoom> getRoomList1(String checkIn, String checkOut) {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade = '스탠다드'\r\n" + "and room_no NOT IN (select room_no\r\n"
				+ "                     from reserve \r\n" + "                     where check_in >= ?\r\n"
				+ "                     and check_out <= ?)\r\n" + "order by room_no";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
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

	ArrayList<HotelRoom> getRoomList2(String checkIn, String checkOut) {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade = '프리미어'\r\n" + "and room_no NOT IN (select room_no\r\n"
				+ "                     from reserve \r\n" + "                     where check_in >= ?\r\n"
				+ "                     and check_out <= ?)\r\n" + "order by room_no";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
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

	ArrayList<HotelRoom> getRoomList3(String checkIn, String checkOut) {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade = '스위트'\r\n" + "and room_no NOT IN (select room_no\r\n"
				+ "                     from reserve \r\n" + "                     where check_in >= ?\r\n"
				+ "                     and check_out <= ?)\r\n" + "order by room_no";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
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

	ArrayList<HotelRoom> getRoomList4(String checkIn, String checkOut) {
		getConn();
		String sql = "select room_no, room_floor, room_view, to_char(room_price, '9,999,999') room_price\r\n"
				+ "from room\r\n" + "where room_grade = '로열 스위트'\r\n" + "and room_no NOT IN (select room_no\r\n"
				+ "                     from reserve \r\n" + "                     where check_in >= ?\r\n"
				+ "                     and check_out <= ?)\r\n" + "order by room_no";
		ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
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

	void roomShowInfo(String checkIn, String checkOut) {
		System.out.println();
		System.out.println("[예약가능한 객실 현황]");
		System.out.println("1.스탠다드 등급 [" + RoomGrade1(checkIn, checkOut) + "개] 객실");
		System.out.println("2.프리미어 등급 [" + RoomGrade2(checkIn, checkOut) + "개] 객실");
		System.out.println("3.스위트 등급 [" + RoomGrade3(checkIn, checkOut) + "개] 객실");
		System.out.println("4.로열 스위트 등급 [" + RoomGrade4(checkIn, checkOut) + "개] 객실");
		System.out.println();
	}

	void roomShowInfo1() {
		System.out.println("1.스탠다드");
		System.out.println("2.프리미어");
		System.out.println("3.스위트");
		System.out.println("4.로열 스위트");
	}

	double roomPrice(int roomNo) {
		getConn();
		String sql = "select room_price\r\n" + "from room\r\n" + "where room_no = ?";
		double roomPrice = 0;
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

	double payment(double roomPrice, String memberGrade) {
		double paymemt = 0;
		if (memberGrade.equals("일반")) {
			paymemt = roomPrice;
		} else if (memberGrade.equals("브라운")) {
			paymemt = roomPrice - (roomPrice * 0.03);
		} else if (memberGrade.equals("실버")) {
			paymemt = roomPrice - (roomPrice * 1.05);
		} else if (memberGrade.equals("골드")) {
			paymemt = roomPrice - (roomPrice * 1.07);
		} else if (memberGrade.equals("다이아몬드")) {
			paymemt = roomPrice - (roomPrice * 1.10);
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

	void complete(String reserveNo) {
		getConn();
		String sql = "select re.reserve_no, re.customer_name, to_char(re.check_in, 'yy/mm/dd') as \"check_in\", to_char(re.check_out,'yy/mm/dd') as \"check_out\", re.room_no, r.room_grade, r.room_price, \r\n"
				+ "m.members_grade, m.members_discount, re.payment\r\n" + "from reserve re join room r\r\n"
				+ "on r.room_no = re.room_no\r\n" + "join members m\r\n" + "on re.members_grade = m.members_grade\r\n"
				+ "where re.reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reserveNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				System.out.println("객실예약이 완료되었습니다.");
				System.out.println();
				System.out.println("-------------  [예약 정보]  ---------------------");
				System.out
						.println("예약번호: " + rs.getString("reserve_no") + " | 예약자 성함: " + rs.getString("customer_name"));
				System.out.println();
				System.out.println("체크인 날짜: " + rs.getString("check_in") + " | 체크아웃 날짜: " + rs.getString("check_out"));
				System.out.println();
				System.out.println("객실 번호: " + rs.getString("room_no") + " | 객실 등급: " + rs.getString("room_grade")
						+ " | 객실 가격: " + rs.getInt("room_price"));
				System.out.println();
				System.out.println("회원 등급: " + rs.getString("members_grade") + " | 객실 할인율: "
						+ (int) ((rs.getDouble("members_discount")) * 100) + " % | 결제 금액: "
						+ (int) (rs.getDouble("payment")));
				System.out.println("-----------------------------------------------");
				System.out.println("감사합니다 ^_^");
				System.out.println();
			} else {
				sql = "select re.reserve_no, re.customer_name, to_char(re.check_in, 'yy/mm/dd') as \"check_in\", to_char(re.check_out,'yy/mm/dd') as \"check_out\", re.room_no, r.room_grade, r.room_price,\r\n"
						+ "re.payment\r\n" + "from reserve re join room r\r\n" + "on r.room_no = re.room_no\r\n"
						+ "where re.reserve_no = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, reserveNo);
				rs = psmt.executeQuery();
				if (rs.next()) {
					System.out.println();
					System.out.println("---------  [고객님의 현재 예약정보]  -----------------");
					System.out.println(
							"예약번호: " + rs.getString("reserve_no") + " | 예약자 성함: " + rs.getString("customer_name"));
					System.out.println();
					System.out.println(
							"체크인 날짜: " + rs.getString("check_in") + " | 체크아웃 날짜: " + rs.getString("check_out"));
					System.out.println();
					System.out.println("객실 번호: " + rs.getString("room_no") + " | 객실 등급: " + rs.getString("room_grade")
							+ " | 객실 가격: " + rs.getInt("room_price"));
					System.out.println();
					System.out.println("회원 등급: 일반 | 객실 할인율: 0 % | 결제 금액: " + (int) (rs.getDouble("payment")));
					System.out.println("------------------------------------------------");
					System.out.println();
				}
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
		System.out.println("-------------------------------------------------------");
	}

	void information() {
		System.out.println("================================================");
		System.out.println(" [등급]\t\t   [조건]\t\t     [혜택]");
		System.out.println("================================================");
		System.out.println(" 일반\t\t비회원\t\t   없음");
		System.out.println("");
		System.out.println(" 브라운\t\t회원가입시\t\t   객실 3% 할인");
		System.out.println("");
		System.out.println(" 실버\t\t연간 1박 숙박시\t   객실 5% 할인");
		System.out.println("");
		System.out.println(" 골드\t\t연간 10박 숙박시\t   객실 7% 할인");
		System.out.println("");
		System.out.println(" 다이아몬드\t\t연간 50박 숙박시\t   객실 10% 할인");
		System.out.println("-------------------------------------------------");
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
		System.out.println("-------------------------------------------------------");
	}

	void roomInpo1() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("스탠다드 - [호텔의 고품격 서비스를 만나볼 수 있는 가장 기본 객실]");
		System.out.println();
		System.out.println("스튜디오 타입의 파스텔 톤 객실에 휴식을 취할 수 있는 테이블과 체어,");
		System.out.println("그리고 라탄 타입의 아늑한 체어를 완비한 호텔의 가장 기본적인 룸입니다.");
		System.out.println();
		System.out.println("<위치> 1~3층 | <전망> 산 | <침대> 더블, 트윈 | <크기> 40㎡");
		System.out.println("<룸구성> 침실 1, 욕실 1");
		System.out.println("-----------------------------------------------------------");
	}

	void roomInpo2() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("프리미어 - [이국적인 리조트 느낌의 화사한 인테리어로 스탠다드 룸보다 넓은 객실]");
		System.out.println();
		System.out.println("스튜디오 타입 객실에 블루 패턴의 카페트와 화이트 패브릭 소파가 세련된 느낌을");
		System.out.println("자아내며, 휴식을 취할 수 있는 다이닝 테이블과 체어를 완비한 룸입니다.");
		System.out.println();
		System.out.println("<위치> 4~6층 | <전망> 정원, 바다 | <침대> 더블, 트윈 | <룸구성> 46㎡");
		System.out.println("<룸구성> 침실 1, 욕실 1");
		System.out.println("-----------------------------------------------------------");
	}

	void roomInpo3() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("스위트 - [여유있는 침실과 안락한 거실로 편안한 휴식을 만끽할 수 있는 객실]");
		System.out.println();
		System.out.println("침실과 거실, 욕실이 분리되어 있으며 침실과 거실 사이는 루버도어로 장식이 되어");
		System.out.println("있습니다. 벽지, 카페트 등에 전체적으로 화이트, 제이드 그린, 블루 톤을");
		System.out.println("사용했으며, 클래식한 화장대로 스위트의 우아한 느낌을 더욱 살린 룸입니다.");
		System.out.println();
		System.out.println("<위치> 1~4층 | <전망> 산, 바다 | <침대> 더블, 트윈 | <룸구성> 66㎡");
		System.out.println("<룸구성> 침실 1, 거실 1, 욕실 1, 옷장, 욕조, 샤워 부스");
		System.out.println("-----------------------------------------------------------");
	}

	void roomInpo4() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("로열 스위트 - [블루와 화이트톤의 리조트 분위기와 세련미가 녹아있는 최고급 객실]");
		System.out.println();
		System.out.println("가구는 짙은 톤의 월넛을 사용하여 고급스러움을 더했으며, 침실에서 환상적인 바다");
		System.out.println("풍경을 감상할 수 있는 룸 구성을 가지고 있습니다. 고급 라탄과 수입 패브릭을 사용한");
		System.out.println("가구와 실크벽지 등으로 꾸며져 럭셔리한 인테리어를 느끼실 수 있습니다.");
		System.out.println();
		System.out.println("<위치> 5~6층 | <전망> 바다 | <침대> 더블 | <룸구성> 158㎡");
		System.out.println("<룸구성> 침실 2, 거실 1, 욕실 1, 옷장, 욕조, 샤워 부스");
		System.out.println("-----------------------------------------------------------");
	}

	void reserveCheck(String reserveNo) {
		getConn();
		String sql = "select re.reserve_no, re.customer_name, to_char(re.check_in, 'yy/mm/dd') as \"check_in\", to_char(re.check_out, 'yy/mm/dd') as \"check_out\", re.room_no, r.room_grade, r.room_price,\r\n"
				+ "m.members_grade, m.members_discount, re.payment\r\n" + "from reserve re join room r \r\n"
				+ "on r.room_no = re.room_no\r\n" + "join members m\r\n" + "on re.members_grade = m.members_grade\r\n"
				+ "where re.reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reserveNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				System.out.println("---------  [고객님의 현재 예약정보]  -----------------");
				System.out
						.println("예약번호: " + rs.getString("reserve_no") + " | 예약자 성함: " + rs.getString("customer_name"));
				System.out.println();
				System.out.println("체크인 날짜: " + rs.getString("check_in") + " | 체크아웃 날짜: " + rs.getString("check_out"));
				System.out.println();
				System.out.println("객실 번호: " + rs.getString("room_no") + " | 객실 등급: " + rs.getString("room_grade")
						+ " | 객실 가격: " + rs.getInt("room_price"));
				System.out.println();
				System.out.println("회원 등급: " + rs.getString("members_grade") + " | 객실 할인율: "
						+ (int) ((rs.getDouble("members_discount")) * 100) + " % | 결제 금액: "
						+ (int) (rs.getDouble("payment")));
				System.out.println("------------------------------------------------");
				System.out.println();
			} else {
				sql = "select re.reserve_no, re.customer_name, to_char(re.check_in, 'yy/mm/dd') as \"check_in\", to_char(re.check_out, 'yy/mm/dd') as \"check_out\", re.room_no, r.room_grade, r.room_price,\r\n"
						+ "re.payment\r\n" + "from reserve re join room r \r\n" + "on r.room_no = re.room_no\r\n"
						+ "where re.reserve_no = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, reserveNo);
				rs = psmt.executeQuery();
				if (rs.next()) {
					System.out.println();
					System.out.println("---------  [고객님의 현재 예약정보]  -----------------");
					System.out.println(
							"예약번호: " + rs.getString("reserve_no") + " | 예약자 성함: " + rs.getString("customer_name"));
					System.out.println();
					System.out.println(
							"체크인 날짜: " + rs.getString("check_in") + " | 체크아웃 날짜: " + rs.getString("check_out"));
					System.out.println();
					System.out.println("객실 번호: " + rs.getString("room_no") + " | 객실 등급: " + rs.getString("room_grade")
							+ " | 객실 가격: " + rs.getInt("room_price"));
					System.out.println();
					System.out.println("회원 등급: 일반 | 객실 할인율: 0 % | 결제 금액: " + (int) (rs.getDouble("payment")));
					System.out.println("------------------------------------------------");
					System.out.println();
				}
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

	boolean modifyCheck(String checkIn, String checkOut, String reserveNo) {
		getConn();
		String sql = "update reserve\r\n" + "set check_in = ? , check_out = ?\r\n" + "where reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, checkIn);
			psmt.setString(2, checkOut);
			psmt.setString(3, reserveNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
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

	String memberGrade2(String reserveNo) {
		String grade = null;
		getConn();
		String sql = "select members_grade\r\n" + "from reserve\r\n" + "where reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reserveNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				grade = rs.getString("members_grade");
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
		return grade;
	}

	boolean modifyRoom(int roomNo, String reserveNo, double payment) {
		getConn();
		String sql = "update reserve\r\n" + "set room_no = ?\r\n" + "where reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, roomNo);
			psmt.setString(2, reserveNo);
			int r = psmt.executeUpdate();
			if (r > 0) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "update reserve\r\n" + "set payment = ?\r\n" + "where reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, payment);
			psmt.setString(2, reserveNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
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

	boolean removeReserve(String reserveNo) {
		getConn();
		String sql = "delete from reserve where reserve_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reserveNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
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


	

	String outCheck(String reserveNo) {
		getConn();
		String sql = "select to_char(check_out, 'yy/mm/dd') as \"check_out\"\r\n" + "from reserve\r\n"
				+ "where reserve_no = ?";
		String checkOut = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reserveNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				checkOut = rs.getString("check_out");
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
		return checkOut;
	}
}
