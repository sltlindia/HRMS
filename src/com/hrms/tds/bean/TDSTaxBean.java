package com.hrms.tds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
@Entity
@Table(name="tds_tax_tbl")
public class TDSTaxBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private int tds_tax_id;
	private int year;
	private double tax;
	private TDSBean tdsBean;
	private EmployeeBean employeeBean;
	private MonthBean monthBean;
	
	public TDSTaxBean() {
		// TODO Auto-generated constructor stub
	}

	public TDSTaxBean(int year, double tax, TDSBean tdsBean, EmployeeBean employeeBean, MonthBean monthBean) {
		super();
		this.year = year;
		this.tax = tax;
		this.tdsBean = tdsBean;
		this.employeeBean = employeeBean;
		this.monthBean = monthBean;
	}
	
	

	public TDSTaxBean(int tds_tax_id, int year, double tax, TDSBean tdsBean, EmployeeBean employeeBean,  MonthBean monthBean) {
		super();
		this.tds_tax_id = tds_tax_id;
		this.year = year;
		this.tax = tax;
		this.tdsBean = tdsBean;
		this.employeeBean = employeeBean;
		this.monthBean = monthBean;
	}

	@Id
	@GeneratedValue
	@Column(name="tds_tax_id")
	public int getTds_tax_id() {
		return tds_tax_id;
	}

	public void setTds_tax_id(int tds_tax_id) {
		this.tds_tax_id = tds_tax_id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
