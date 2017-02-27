package com.model;

public class Student {
  
int rollno;
  String name;
  String address;
  int mark;
  int age;
  String gender;
  
  public Student(int rollno, String name, String address, int mark, int age, String gender) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.mark = mark;
		this.age = age;
		this.gender = gender;
	}
  
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getMark() {
	return mark;
}
public void setMark(int mark) {
	this.mark = mark;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

@Override
public String toString() {
	return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + ", mark=" + mark + ", age=" + age
			+ ", gender=" + gender + "]";
}
  
  
  
	
}
