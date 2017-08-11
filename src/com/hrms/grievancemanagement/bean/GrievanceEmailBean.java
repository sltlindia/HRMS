package com.hrms.grievancemanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="grievance_email_tbl")
public class GrievanceEmailBean implements Serializable{

	private int grievance_email_id;
	private GrievanceQueryBean grievanceQueryBean;
	private String email_id;
	
	public GrievanceEmailBean() {

	}
	
	public GrievanceEmailBean(String email_id, GrievanceQueryBean grievanceQueryBean) {
		this.email_id = email_id;
		this.grievanceQueryBean = grievanceQueryBean;
			
	}

	@Id 
    @Column(name="grievance_email_id")
    @GeneratedValue
	public int getGrievance_email_id() {
		return grievance_email_id;
	}

	public void setGrievance_email_id(int grievance_email_id) {
		this.grievance_email_id = grievance_email_id;
	}

	@ManyToOne
	@JoinColumn(name="grievance_query_id")
	public GrievanceQueryBean getGrievanceQueryBean() {
		return grievanceQueryBean;
	}

	public void setGrievanceQueryBean(GrievanceQueryBean grievanceQueryBean) {
		this.grievanceQueryBean = grievanceQueryBean;
	}
	
	@Column(name="email_id")
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	

}
