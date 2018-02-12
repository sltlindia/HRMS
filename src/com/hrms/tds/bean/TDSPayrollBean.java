package com.hrms.tds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name="tds_payroll_tbl")
public class TDSPayrollBean	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tds_payroll_id;
	private int employee_code;
	private String company_name;
	private double basic_salary;
	private double annual_basic_salary;
	private double conveyance;
	private double annual_conveyance;
	private double hra;
	private double annual_hra;
	private double medical;
	private double annual_medical;
	private double uni_allw;
	private double annual_uni_allw;
	private double edu_allw;
	private double annual_edu_allw;
	
	
	private MonthBean monthBean;
	private YearBean yearBean;
	
	public TDSPayrollBean() {
		// TODO Auto-generated constructor stub
	}
	


	public TDSPayrollBean(int employee_code, String company_name, double basic_salary, double annual_basic_salary,
			double conveyance, double annual_conveyance, double hra, double annual_hra, double medical,
			double annual_medical, double uni_allw, double annual_uni_allw, double edu_allw, double annual_edu_allw,
			MonthBean monthBean, YearBean yearBean) {
		super();
		this.employee_code = employee_code;
		this.company_name = company_name;
		this.basic_salary = basic_salary;
		this.annual_basic_salary = annual_basic_salary;
		this.conveyance = conveyance;
		this.annual_conveyance = annual_conveyance;
		this.hra = hra;
		this.annual_hra = annual_hra;
		this.medical = medical;
		this.annual_medical = annual_medical;
		this.uni_allw = uni_allw;
		this.annual_uni_allw = annual_uni_allw;
		this.edu_allw = edu_allw;
		this.annual_edu_allw = annual_edu_allw;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
	}



	@Id
	@GeneratedValue
	@Column(name="tds_payroll_id")
	public int getTds_payroll_id() {
		return tds_payroll_id;
	}

	public void setTds_payroll_id(int tds_payroll_id) {
		this.tds_payroll_id = tds_payroll_id;
	}

	
	
	public int getEmployee_code() {
		return employee_code;
	}



	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
	}



	public String getCompany_name() {
		return company_name;
	}



	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}



	public double getBasic_salary() {
		return basic_salary;
	}



	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}



	public double getAnnual_basic_salary() {
		return annual_basic_salary;
	}



	public void setAnnual_basic_salary(double annual_basic_salary) {
		this.annual_basic_salary = annual_basic_salary;
	}



	public double getConveyance() {
		return conveyance;
	}



	public void setConveyance(double conveyance) {
		this.conveyance = conveyance;
	}



	public double getAnnual_conveyance() {
		return annual_conveyance;
	}



	public void setAnnual_conveyance(double annual_conveyance) {
		this.annual_conveyance = annual_conveyance;
	}



	public double getHra() {
		return hra;
	}



	public void setHra(double hra) {
		this.hra = hra;
	}



	public double getAnnual_hra() {
		return annual_hra;
	}



	public void setAnnual_hra(double annual_hra) {
		this.annual_hra = annual_hra;
	}



	public double getMedical() {
		return medical;
	}



	public void setMedical(double medical) {
		this.medical = medical;
	}



	public double getAnnual_medical() {
		return annual_medical;
	}



	public void setAnnual_medical(double annual_medical) {
		this.annual_medical = annual_medical;
	}



	public double getUni_allw() {
		return uni_allw;
	}



	public void setUni_allw(double uni_allw) {
		this.uni_allw = uni_allw;
	}



	public double getAnnual_uni_allw() {
		return annual_uni_allw;
	}



	public void setAnnual_uni_allw(double annual_uni_allw) {
		this.annual_uni_allw = annual_uni_allw;
	}



	public double getEdu_allw() {
		return edu_allw;
	}



	public void setEdu_allw(double edu_allw) {
		this.edu_allw = edu_allw;
	}



	public double getAnnual_edu_allw() {
		return annual_edu_allw;
	}



	public void setAnnual_edu_allw(double annual_edu_allw) {
		this.annual_edu_allw = annual_edu_allw;
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
	@JoinColumn(name="year_id")
	public YearBean getYearBean() {
		return yearBean;
	}

	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}
}