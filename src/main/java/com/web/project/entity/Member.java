package com.web.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="sr_no")
	private String sr;
	@Column(name="district")
	private String district;
	@Column(name="study_center_code")
	private String study_center_code;
	@Column(name="study_center_name")
	private String study_center_name;
	@Column(name="program_code_name")
	private String program_code_name;
	@Column(name="incharge")
	private String incharge;
	@Column(name="co_ordinator")
	private String co_ordinator;
	@Column(name="email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSr() {
		return sr;
	}
	public void setSr(String sr) {
		this.sr = sr;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStudy_center_code() {
		return study_center_code;
	}
	public void setStudy_center_code(String study_center_code) {
		this.study_center_code = study_center_code;
	}
	public String getStudy_center_name() {
		return study_center_name;
	}
	public void setStudy_center_name(String study_center_name) {
		this.study_center_name = study_center_name;
	}
	public String getProgram_code_name() {
		return program_code_name;
	}
	public void setProgram_code_name(String program_code_name) {
		this.program_code_name = program_code_name;
	}
	public String getIncharge() {
		return incharge;
	}
	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}
	public String getCo_ordinator() {
		return co_ordinator;
	}
	public void setCo_ordinator(String co_ordinator) {
		this.co_ordinator = co_ordinator;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", sr=" + sr + ", district=" + district + ", study_center_code=" + study_center_code
				+ ", study_center_name=" + study_center_name + ", program_code_name=" + program_code_name
				+ ", incharge=" + incharge + ", co_ordinator=" + co_ordinator + ", email=" + email + "]";
	}
	
	
}
