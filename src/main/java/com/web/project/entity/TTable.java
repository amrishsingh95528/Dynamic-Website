package com.web.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="time_table")
public class TTable {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="ProgramCode")
	private String programCode;
	@Column(name="ProgramName")
	private String programName;
	@Column(name="UploadDate")
	private String uploadDate;
	@Column(name="FileName")
	private String filename;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProgramCode() {
		return programCode;
	}
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "TTable [id=" + id + ", programCode=" + programCode + ", programName=" + programName + ", uploadDate="
				+ uploadDate + ", filename=" + filename + "]";
	}
	
	

}
