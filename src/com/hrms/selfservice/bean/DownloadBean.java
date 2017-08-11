package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="download_tbl")

public class DownloadBean {


	private int download_id;
	private int extension;
	private String link;
	private String date;
	private String reply;
	private String response_date;
	private String status;
	private String remarks;

	private EmployeeBean employeeBean;

	public DownloadBean(int extension, String link, String date, String status,
			EmployeeBean employeeBean) {
		super();
		this.extension = extension;
		this.link = link;
		this.date = date;
		this.status = status;
		this.employeeBean = employeeBean;
	}



	public DownloadBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Id 
    @Column(name="download_id")
    @GeneratedValue
	public int getDownload_id() {
		return download_id;
	}



	public void setDownload_id(int download_id) {
		this.download_id = download_id;
	}


	@Column(name="extension")
	public int getExtension() {
		return extension;
	}



	public void setExtension(int extension) {
		this.extension = extension;
	}


	@Column(name="link")
	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}


	@Column(name="date")
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}


	

	@Column(name="reply")
	public String getReply() {
		return reply;
	}


	public void setReply(String reply) {
		this.reply = reply;
	}

	@Column(name="response_date")

	public String getResponse_date() {
		return response_date;
	}



	public void setResponse_date(String response_date) {
		this.response_date = response_date;
	}



	@Column(name="status")
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}



	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}



}
