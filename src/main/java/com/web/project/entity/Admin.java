package com.web.project.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="AdminTable")
@DynamicInsert
public class Admin {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="fullName")
	private String fullName;
	@Column(name="number")
	private String number;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="joinDate")
	private String joinDate;
	@ColumnDefault("Still Working")
	@Column(name="lastDate")
	private String lastDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", fullName=" + fullName + ", number=" + number + ", email=" + email + ", address="
				+ address + ", username=" + username + ", password=" + password + ", joinDate=" + joinDate
				+ ", lastDate=" + lastDate + "]";
	}

	
}

