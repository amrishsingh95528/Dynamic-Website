package com.web.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fees")
public class Fees {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="course")
	private String course;
	@Column(name="courseCode")
	private String courseCode;
	@Column(name="year")
	private String year;
	@Column(name="universityFees")
	private String universityFees;
	@Column(name="studyCenterFees")
	private String studyCenterFees;
	@Column(name="totalFees")
	private String totalFees;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getUniversityFees() {
		return universityFees;
	}
	public void setUniversityFees(String universityFees) {
		this.universityFees = universityFees;
	}
	public String getStudyCenterFees() {
		return studyCenterFees;
	}
	public void setStudyCenterFees(String studyCenterFees) {
		this.studyCenterFees = studyCenterFees;
	}
	public String getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(String totalFees) {
		this.totalFees = totalFees;
	}
	@Override
	public String toString() {
		return "Fees [id=" + id + ", course=" + course + ", courseCode=" + courseCode + ", year=" + year
				+ ", universityFees=" + universityFees + ", studyCenterFees=" + studyCenterFees + ", totalFees="
				+ totalFees + "]";
	}
	
	
	
}
