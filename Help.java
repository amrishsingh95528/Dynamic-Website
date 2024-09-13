package com.web.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Help {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Lastname")
	private String lastname;
	@Column(name="Department")
	private String department;
	@Column(name="Designation")
	private String designation;
	@Column(name="ask_query")
	private String ask_query;
	@Column(name="query_status")
	private String query_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getAsk_query() {
		return ask_query;
	}
	public void setAsk_query(String ask_query) {
		this.ask_query = ask_query;
	}
	public String getQuery_status() {
		return query_status;
	}
	public void setQuery_status(String query_status) {
		this.query_status = query_status;
	}

	
	
	public Help() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Help(int id, String name, String lastname, String department, String designation, String ask_query,
			String query_status) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.department = department;
		this.designation = designation;
		this.ask_query = ask_query;
		this.query_status = query_status;
	}
	@Override
	public String toString() {
		return "Help [id=" + id + ", name=" + name + ", lastname=" + lastname + ", department=" + department
				+ ", designation=" + designation + ", ask_query=" + ask_query + ", query_status=" + query_status + "]";
	}
	
	
	
	
}
