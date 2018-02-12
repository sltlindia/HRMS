package com.hrms.selfservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
@Entity
@Table(name = "selfservice_query_tbl")
public class SelfServiceQuerybean {


	
	private int selfservice_query_id;
	private String description;
	private String attachment;
	private String date_of_submission;
	
	private EmployeeBean employeeBean;
	private SelfServiceTypeBean selfServiceTypeBean;
	
	public SelfServiceQuerybean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id 
    @Column(name="selfservice_query_id")
    @GeneratedValue
	public int getSelfservice_query_id() {
		return selfservice_query_id;
	}


	public void setSelfservice_query_id(int selfservice_query_id) {
		this.selfservice_query_id = selfservice_query_id;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="attachment")
	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Column(name="date_of_submission")
	public String getDate_of_submission() {
		return date_of_submission;
	}


	public void setDate_of_submission(String date_of_submission) {
		this.date_of_submission = date_of_submission;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@ManyToOne
	@JoinColumn(name="selfservice_type_id")
	public SelfServiceTypeBean getSelfServiceTypeBean() {
		return selfServiceTypeBean;
	}


	public void setSelfServiceTypeBean(SelfServiceTypeBean selfServiceTypeBean) {
		this.selfServiceTypeBean = selfServiceTypeBean;
	}


	public SelfServiceQuerybean(String description, String attachment, String date_of_submission,
			EmployeeBean employeeBean, SelfServiceTypeBean selfServiceTypeBean) {
		super();
		this.description = description;
		this.attachment = attachment;
		this.date_of_submission = date_of_submission;
		this.employeeBean = employeeBean;
		this.selfServiceTypeBean = selfServiceTypeBean;
	}
	
	
	
}
