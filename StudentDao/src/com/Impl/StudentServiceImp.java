package com.Impl;
import java.sql.*;

import com.DBhelper.DBhelper;
import com.model.Student;
import com.service.StudentService;
public class StudentServiceImp implements StudentService {
	
	
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void Save(Student s) {
		String q = "insert into student(rollno,name,address,mark,gender,age) values(?,?,?,?,?,?)";
		try {
		PreparedStatement ps = new DBhelper().getConnected().prepareStatement(q);
		ps.setInt(1,s.getRollno());
		ps.setString(2,s.getName());
		ps.setString(3,s.getAddress());
		ps.setInt(4,s.getMark());
		ps.setString(5,s.getGender());
		ps.setInt(6,s.getAge());
	    int rowsUpdated = ps.executeUpdate();
	    if (rowsUpdated > 0) {
	        System.out.println(" inserted successfully!");
	    }
		}
		catch( Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void Update(Student s) {
		String q = "update student  set name=?, address=? , mark=? , age = ? ,gender = ? where rollno = ?";
		try {
		PreparedStatement ps = new DBhelper().getConnected().prepareStatement(q);
		//ps.last();
		//ps.last();
		ps.setString(1,s.getName());
		ps.setString(2,s.getAddress());
		ps.setInt(3,s.getMark());
		ps.setInt(4,s.getAge());
		ps.setString(5,s.getGender());
	    ps.setInt(6,s.getRollno());
		
	 
	    int rowsUpdated = ps.executeUpdate();
	    if (rowsUpdated > 0) {
	        System.out.println(" updated successfully!");
	    }
		}
		catch( Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void Delete( int r) {
		Student s = null;
		String q = "delete from student where rollno = ?";
		try {
		PreparedStatement ps = new DBhelper().getConnected().prepareStatement(q);
		ps.setInt(1,r);
	    ps.execute();
	    System.out.println("deleted record successfully"+ps);
		}
		catch( Exception e) {
			e.printStackTrace();
		}	
	}

	public Student Search(int r) {
		Student s = null;
		String q = "select * from student where rollno = ?";
		try {
		PreparedStatement ps = new DBhelper().getConnected().prepareStatement(q);
		 ps.setInt(1,r);
		
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()){
			 s = setStudentDetails(rs);
		 }
		} catch( Exception e) {
			e.printStackTrace();
		}
		return s;	
	}
	
public Student First(){
	Student s = null;
	try {
	 Statement stmt = new DBhelper().getConnected().createStatement();
		ResultSet rs =  stmt.executeQuery("select * from student");
	 if(rs.next()){
		s = setStudentDetails(rs);
	 }
	} catch( Exception e) {
		e.printStackTrace();
	}
	return s;	
		
	}

public Student Last(){
	Student s = null;
	try {
	 Statement stmt = new DBhelper().getConnected().createStatement();
		ResultSet rs =  stmt.executeQuery("select * from student");
	  if(rs.last()){
		s = setStudentDetails(rs);
	 }
	} catch( Exception e) {
		e.printStackTrace();
	}
	return s;	
		
	}

public Student Prev(int r){
	Student s = null;
	try {
	 Statement stmt = new DBhelper().getConnected().createStatement();
		ResultSet rs =  stmt.executeQuery("select * from student");
		rs.last();
	  while(rs.previous()){
		s = setStudentDetails(rs);
	 }
	} catch( Exception e) {
		e.printStackTrace();
	}
	return s;	
}		

public Student Next(int r){
	Student s = null;
	String show = "false";
	try {
	 Statement stmt = new DBhelper().getConnected().createStatement();
		ResultSet rs =  stmt.executeQuery("select * from student");
		
	  if(rs.next()){
		  if(rs.getInt("rollno") == r)
			  show = "true";
	  }
		 if(show == "true"){
			 rs.next();
			 s = setStudentDetails(rs); 
		 }
		
	 
	} catch( Exception e) {
		e.printStackTrace();
	}
	return s;	
}	

public Student setStudentDetails(ResultSet rs) {
	Student s = null;
	try {
		 int rn = rs.getInt("rollno");
		 String n = rs.getString("name"); 
		 String add = rs.getString("address");
		 int mark = rs.getInt("mark");
		 int age = rs.getInt("age");
		 String gender = rs.getString("address"); 
		 s = new Student(rn,n,add,mark,age,gender);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return s;
}



}
