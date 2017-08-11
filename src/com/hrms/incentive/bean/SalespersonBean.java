package com.hrms.incentive.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name = "sales_person_tbl")
public class SalespersonBean {

	private int sales_person_id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String fullname;
	private String designation;
	private String alias;

	private EmployeeBean employeeBean;

	public SalespersonBean(String firstname, String middlename, String lastname, String designation, String alias,
			EmployeeBean employeeBean) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.designation = designation;
		this.alias = alias;
		this.employeeBean = employeeBean;
	}

	public SalespersonBean(String firstname, String middlename, String lastname, String designation, String alias) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.designation = designation;
		this.alias = alias;
	}

	public SalespersonBean(int sales_person_id, String firstname, String middlename, String lastname,
			String designation, String alias, EmployeeBean employeeBean) {
		super();
		this.sales_person_id = sales_person_id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.designation = designation;
		this.alias = alias;
		this.employeeBean = employeeBean;
	}

	public SalespersonBean() {
		super();
	}

	@Id
	@Column(name = "sales_person_id")
	@GeneratedValue
	public int getSales_person_id() {
		return sales_person_id;
	}

	public void setSales_person_id(int sales_person_id) {
		this.sales_person_id = sales_person_id;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "alias")
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
