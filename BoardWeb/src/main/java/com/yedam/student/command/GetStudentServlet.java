package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/getStudentServlet")
public class GetStudentServlet extends HttpServlet {

//	public GetStudentServlet() {
//		super();
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url?sno=23-010&sname=홍길동
		resp.setContentType("text/html;charset=utf-8");
		String sno = req.getParameter("sno");

		StudentService dao = new StudentServiceImpl();
		Student std = dao.getStudent(sno);

		String str = "<table border = '1'>";
		str += "<caption>학생정보</caption>";
		str += "<tr><th>학번</th><td>" + std.getStudentNo() + "</td></tr>";
		str += "<tr><th>이름</th><td>" + std.getStudentName() + "</td></tr>";
		str += "<tr><th>영어</th><td>" + std.getEng() + "</td></tr>";
		str += "<tr><th>수학</th><td>" + std.getMath() + "</td></tr>";
		str += "</table>";
		str += "<br><a href='modifyStudent?sno="+ std.getStudentNo() +"'>수정화면</a>";
		str += "<br><a href='studentList'>목록</a>";
		
		resp.getWriter().print(str);
		
	}
}
