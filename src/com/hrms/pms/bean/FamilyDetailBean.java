/*
Name : Bhoomi Patel
Action : Employee's Family Detail Bean , data insert into table family_detail_tbl */

package com.hrms.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="family_detail_tbl")
public class FamilyDetailBean {

	private int family_detail_id;
	private String name;
	private String dob;
	private String occupation;
	private String contact_number;
	private String adhaar_number;
	
	private EmployeeBean employeeBean;
	private FamilyRelationBean familyRelationBean;
	
	
	public FamilyDetailBean() {
		// TODO Auto-generated constructor stub
	}


	// Constructor for Insertion
	public FamilyDetailBean(String name, int relation, String dob, String occupation, String contact_number,
			String adhaar_number, EmployeeBean employeeBean, FamilyRelationBean familyRelationBean) {
		super();
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.contact_number = contact_number;
		this.adhaar_number = adhaar_number;
		this.employeeBean = employeeBean;
		this.familyRelationBean = familyRelationBean;
	}

	
	// Constructor for Updation
	public FamilyDetailBean(int family_detail_id, String name, int relation, String dob, String occupation,
			String contact_number, String adhaar_number, EmployeeBean employeeBean, FamilyRelationBean familyRelationBean) {
		super();
		this.family_detail_id = family_detail_id;
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.contact_number = contact_number;
		this.adhaar_number = adhaar_number;
		this.employeeBean = employeeBean;
		this.familyRelationBean = familyRelationBean;
	}
	


	@Id 
    @Column(name="family_detail_id")
    @GeneratedValue
	public int getFamily_detail_id() {
		return family_detail_id;
	}


	public void setFamily_detail_id(int family_detail_id) {
		this.family_detail_id = family_detail_id;
	}


	@Column(name="name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="dob")
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}


	@Column(name="occupation")
	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	@Column(name="contact_number")
	public String getContact_number() {
		return contact_number;
	}


	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}


	@Column(name="adhaar_number")
	public String getAdhaar_number() {
		return adhaar_number;
	}


	public void setAdhaar_number(String adhaar_number) {
		this.adhaar_number = adhaar_number;
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
	@JoinColumn(name="family_relation_id")
	public FamilyRelationBean getFamilyRelationBean() {
		return familyRelationBean;
	}

	public void setFamilyRelationBean(FamilyRelationBean familyRelationBean) {
		this.familyRelationBean = familyRelationBean;
	}
	
	
	
	
}
