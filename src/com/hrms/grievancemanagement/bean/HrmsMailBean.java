package com.hrms.grievancemanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hrms_mail_tbl")
public class HrmsMailBean implements Serializable{

	
	private int hrms_mail_id;
	private String hrms_mail;
	
	public HrmsMailBean() {

	}

	public HrmsMailBean(String hrms_mail) {
		this.hrms_mail = hrms_mail;
	}

	
	@Id 
    @Column(name="hrms_mail_id")
    @GeneratedValue
	public int getHrms_mail_id() {
		return hrms_mail_id;
	}
	public void setHrms_mail_id(int hrms_mail_id) {
		this.hrms_mail_id = hrms_mail_id;
	}
	
    @Column(name="hrms_mail")
	public String getHrms_mail() {
		return hrms_mail;
	}
	public void setHrms_mail(String hrms_mail) {
		this.hrms_mail = hrms_mail;
	}
	
	
}
