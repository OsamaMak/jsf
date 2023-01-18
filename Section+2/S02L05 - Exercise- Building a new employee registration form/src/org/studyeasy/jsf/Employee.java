package org.studyeasy.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Employee {
   private String name;
   private int age;
   private String gender;
   private String status;
   private String[] department;
   private String refcode;
   private String comment;
   
   
   
public Employee() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String[] getDepartment() {
	return department;
}
public void setDepartment(String[] department) {
	this.department = department;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getRefcode() {
	return refcode;
}
public void setRefcode(String refcode) {
	this.refcode = refcode;
}
   
 
}
