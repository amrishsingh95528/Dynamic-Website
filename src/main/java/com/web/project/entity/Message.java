package com.web.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="Name")
	private String name;
	@Column(name="Number")
	private String number;
	@Column(name="Email")
	private String email;
	@Column(name="Subject")
	private String subject;
	@Column(name="MessageText")
	private String messageText;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", subject="
				+ subject + ", messageText=" + messageText + "]";
	}
	
	
	
}
