package com.skillup.Vo.vo;

public class lectureVo {
	private String LectureName;
    private String startDay;
    private String endDay;
    private String Lectureontent;
    private String LecturelStudent;
    private String Lecturecharge;
    private String GJAHR;
    private String month;
    private  String subject;
    private  String Belnr;
    private  String tcId;
    private  String stId;
    private  String falseValue;
    private  String idx;
    
    
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTcId() {
		return tcId;
	}
	public void setTcId(String tcId) {
		this.tcId = tcId;
	}
	public String getStId() {
		return stId;
	}
	public void setStId(String stId) {
		this.stId = stId;
	}
	public String getFalseValue() {
		return falseValue;
	}
	public void setFalseValue(String falseValue) {
		this.falseValue = falseValue;
	}
	public String getBelnr() {
		return Belnr;
	}
	public void setBelnr(String belnr) {
		Belnr = belnr;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getLectureName() {
		return LectureName;
	}
	public void setLectureName(String lectureName) {
		LectureName = lectureName;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getLectureontent() {
		return Lectureontent;
	}
	public void setLectureontent(String lectureontent) {
		Lectureontent = lectureontent;
	}
	public String getLecturelStudent() {
		return LecturelStudent;
	}
	public void setLecturelStudent(String lecturelStudent) {
		LecturelStudent = lecturelStudent;
	}
	public String getLecturecharge() {
		return Lecturecharge;
	}

	public void setLecturecharge(String lecturecharge) {
		Lecturecharge = lecturecharge;
	}
	public String getGJAHR() {
		return GJAHR;
	}
	public void setGJAHR(String gJAHR) {
		GJAHR = gJAHR;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "lectureVo [LectureName=" + LectureName + ", startDay=" + startDay + ", endDay=" + endDay
				+ ", Lectureontent=" + Lectureontent + ", LecturelStudent=" + LecturelStudent + ", Lecturecharge="
				+ Lecturecharge + ", GJAHR=" + GJAHR + ", month=" + month + ", subject=" + subject + ", Belnr=" + Belnr
				+ ", tcId=" + tcId + ", stId=" + stId + ", falseValue=" + falseValue + ", getTcId()=" + getTcId()
				+ ", getStId()=" + getStId() + ", getFalseValue()=" + getFalseValue() + ", getBelnr()=" + getBelnr()
				+ ", getSubject()=" + getSubject() + ", getLectureName()=" + getLectureName() + ", getStartDay()="
				+ getStartDay() + ", getEndDay()=" + getEndDay() + ", getLectureontent()=" + getLectureontent()
				+ ", getLecturelStudent()=" + getLecturelStudent() + ", getLecturecharge()=" + getLecturecharge()
				+ ", getGJAHR()=" + getGJAHR() + ", getMonth()=" + getMonth() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
    
}
