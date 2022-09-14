package com.web.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="applyforleave")
@DynamicInsert
public class Leave {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="Name")
	private String name;
	@Column(name="Lastname")
	private String lastname;
	@Column(name="Department")
	private String department;
	@Column(name="Designation")
	private String designation;
	@Column(name="Reason")
	private String reason;
	@Column(name="FromDate")
	private String fromdate;
	@Column(name="ToDate")
	private String todate;
	@ColumnDefault("Pending")
	@Column(name="leave_Status")
	private String leave_status;
	@ColumnDefault("-")
	@Column(name="remark")
	private String remark;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getLeave_status() {
		return leave_status;
	}
	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Leave [id=" + id + ", name=" + name + ", lastname=" + lastname + ", department=" + department
				+ ", designation=" + designation + ", reason=" + reason + ", fromdate=" + fromdate + ", todate="
				+ todate + ", leave_status=" + leave_status + ", remark=" + remark + "]";
	}
	
	
}
