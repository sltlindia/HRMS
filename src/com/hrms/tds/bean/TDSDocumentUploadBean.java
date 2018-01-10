package com.hrms.tds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;

@Entity
@Table(name="tds_document_upload_tbl")
public class TDSDocumentUploadBean implements Serializable{

	private int tds_document_upload_id ;
	private String attachment;
	private String attachment_name;
	private double amount;
	private String status;
	private int attachment_priority;
	
	private int year;
	private MonthBean monthBean;
	private TDSBean tdsBean;
	private EmployeeBean employeeBean;
	
	public TDSDocumentUploadBean() {
		// TODO Auto-generated constructor stub
	}

	public TDSDocumentUploadBean(String attachment, String attachment_name, double amount, String status,
			int attachment_priority, int year, MonthBean monthBean, TDSBean tdsBean, EmployeeBean employeeBean) {
		super();
		this.attachment = attachment;
		this.attachment_name = attachment_name;
		this.amount = amount;
		this.status = status;
		this.attachment_priority = attachment_priority;
		this.year = year;
		this.monthBean = monthBean;
		this.tdsBean = tdsBean;
		this.employeeBean = employeeBean;
	}

	@Id
	@GeneratedValue
	@Column(name="tds_document_upload_id")
	public int getTds_document_upload_id() {
		return tds_document_upload_id;
	}

	public void setTds_document_upload_id(int tds_document_upload_id) {
		this.tds_document_upload_id = tds_document_upload_id;
	}

	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getAttachment_name() {
		return attachment_name;
	}

	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getAttachment_priority() {
		return attachment_priority;
	}

	public void setAttachment_priority(int attachment_priority) {
		this.attachment_priority = attachment_priority;
	}

	@ManyToOne
	@JoinColumn(name="tds_id")
	public TDSBean getTdsBean() {
		return tdsBean;
	}

	public void setTdsBean(TDSBean tdsBean) {
		this.tdsBean = tdsBean;
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
