package com.skillup.Vo.vo;

import java.util.Date;

public class loginVo {
	private  String id;//id
	private  String email;//email
	private  String userType;//type
	private  String pwd;//pwd
	private  String name;//age
	private  String age;
	private  String subject;
	private  String grade;
	
	private String userIp;
	private Date date;
	
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "loginVo [id=" + id + ", email=" + email + ", userType=" + userType + ", pwd=" + pwd + ", name=" + name
				+ ", age=" + age + ", subject=" + subject + ", grade=" + grade + ", getId()=" + getId()
				+ ", getEmail()=" + getEmail() + ", getUserType()=" + getUserType() + ", getPwd()=" + getPwd()
				+ ", getName()=" + getName() + ", getAge()=" + getAge() + ", getSubject()=" + getSubject()
				+ ", getGrade()=" + getGrade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
