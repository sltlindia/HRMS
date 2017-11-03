package com.hrms.tds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tds_payroll_tbl")
public class TDSPayrollBean	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tds_payroll_id;
	private String company_name;
	private int employee_code;
	private String date;
	private double basic_salary;
	private double incentive;
	private double previous_salary;
	private double performance_pay;
	private double conveyance;
	private double hra;
	private double medical;
	private double ltc;
	private double ptax;
	private double pf;
	private double uni_allw;
	private double edu_allw;
	private double other_allw;
	private double adhoc_allw;
	
	public TDSPayrollBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public TDSPayrollBean(String company_name, int employee_code, String date, double basic_salary, double incentive,
			double previous_salary, double performance_pay, double conveyance, double hra, double medical, double ltc,
			double ptax, double pf, double uni_allw, double edu_allw, double other_allw, double adhoc_allw) {
		super();
		this.company_name = company_name;
		this.employee_code = employee_code;
		this.date = date;
		this.basic_salary = basic_salary;
		this.incentive = incentive;
		this.previous_salary = previous_salary;
		this.performance_pay = performance_pay;
		this.conveyance = conveyance;
		this.hra = hra;
		this.medical = medical;
		this.ltc = ltc;
		this.ptax = ptax;
		this.pf = pf;
		this.uni_allw = uni_allw;
		this.edu_allw = edu_allw;
		this.other_allw = other_allw;
		this.adhoc_allw = adhoc_allw;
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
	
	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public double getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	public double getPrevious_salary() {
		return previous_salary;
	}

	public void setPrevious_salary(double previous_salary) {
		this.previous_salary = previous_salary;
	}

	public double getPerformance_pay() {
		return performance_pay;
	}

	public void setPerformance_pay(double performance_pay) {
		this.performance_pay = performance_pay;
	}

	public double getConveyance() {
		return conveyance;
	}

	public void setConveyance(double conveyance) {
		this.conveyance = conveyance;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getMedical() {
		return medical;
	}

	public void setMedical(double medical) {
		this.medical = medical;
	}

	public double getLtc() {
		return ltc;
	}

	public void setLtc(double ltc) {
		this.ltc = ltc;
	}

	public double getPtax() {
		return ptax;
	}

	public void setPtax(double ptax) {
		this.ptax = ptax;
	}
	
	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getUni_allw() {
		return uni_allw;
	}

	public void setUni_allw(double uni_allw) {
		this.uni_allw = uni_allw;
	}

	public double getEdu_allw() {
		return edu_allw;
	}

	public void setEdu_allw(double edu_allw) {
		this.edu_allw = edu_allw;
	}

	public double getOther_allw() {
		return other_allw;
	}

	public void setOther_allw(double other_allw) {
		this.other_allw = other_allw;
	}

	public double getAdhoc_allw() {
		return adhoc_allw;
	}

	public void setAdhoc_allw(double adhoc_allw) {
		this.adhoc_allw = adhoc_allw;
	}

}
