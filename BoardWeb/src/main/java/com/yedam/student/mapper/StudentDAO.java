package com.yedam.student.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.student.vo.Student;

// 저장공간: Oracle DB

// 추가/수정/삭제/목록/단건조회
public class StudentDAO {
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

	// 목록
	public List<Student> getStudentList() {
		getConn();
		List<Student> students = new ArrayList<>();
		String sql = "select * from student order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	} // end of getStudentList()

	// 등록
	public boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false); // 자동커밋 실행 여부
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStudentNo());
			psmt.setString(2, std.getStudentName());
			psmt.setInt(3, std.getEng());
			psmt.setInt(4, std.getMath());

			int r = psmt.executeUpdate(); // db에 처리된 건수 반환.
			if (r == 1) {
				conn.commit();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addStudent()

	// 단건조회
	public Student getStudent(String no) {
		getConn();
		String sql = "select * from student where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회된 값이 없으면 null 값 반환
	} // end of getStudent()

	// 수정
	public boolean modifyStudent(String no, int eng, int math) {
		getConn();
		String sql = "update student\r\n" + "set    eng = ?, math = ?\r\n" + "where  student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, math);
			psmt.setString(3, no);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of modifyStudent()

	// 삭제
	public boolean removeStudent(String name) {
		getConn();
		String sql = "delete from student where student_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of removeStudent()
	
}
