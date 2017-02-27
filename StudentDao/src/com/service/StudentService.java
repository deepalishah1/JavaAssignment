package com.service;

import java.sql.ResultSet;

import com.model.Student;

public interface StudentService {
	
	public void Save(Student s);
	
	public void Update(Student s);
	
	public void Delete(int r);
	
	public Student Search(int r);
	
	public Student Last();
	
	public Student First();
	
	public Student Prev(int r);
	
	public Student Next(int r);
	
	public Student setStudentDetails (ResultSet rs);
	
}
