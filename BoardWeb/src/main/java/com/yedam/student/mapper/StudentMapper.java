package com.yedam.student.mapper;

import java.util.List;

import com.yedam.student.vo.Student;

public interface StudentMapper {
	// CRUD
	List<Student> studentList();
	int addStudent(Student std); // 필드를 넣음 #{studentNo},#~~~
	int remStudent(String sno); // #{sno}
}
