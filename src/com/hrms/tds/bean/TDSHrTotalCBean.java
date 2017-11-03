package com.hrms.tds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tds_hr_totalc_tbl")
public class TDSHrTotalCBean implements Serializable{

	private int tds_hr_totalc_id;
	private double other_income;
	private double a_house_loan;
	private double d_house_loan;
	private String bank_name;
	private String bank_pan_no;
	private String bank_address;
	private double total_c;
	private TDSHrBean tdsHrBean;
	
	public TDSHrTotalCBean() {}

	
	public TDSHrTotalCBean(double other_income, double a_house_loan, double d_house_loan, String bank_name,
			String bank_pan_no, String bank_address, double total_c, TDSHrBean tdsHrBean) {
		this.other_income = other_income;
		this.a_house_loan = a_house_loan;
		this.d_house_loan = d_house_loan;
		this.bank_name = bank_name;
		this.bank_pan_no = bank_pan_no;
		this.bank_address = bank_address;
		this.total_c = total_c;
		this.tdsHrBean = tdsHrBean;
	}
	
	
	

	public TDSHrTotalCBean(int tds_hr_totalc_id, double other_income, double a_house_loan, double d_house_loan,
			String bank_name, String bank_pan_no, String bank_address, double total_c, TDSHrBean tdsHrBean) {
		super();
		this.tds_hr_totalc_id = tds_hr_totalc_id;
		this.other_income = other_income;
		this.a_house_loan = a_house_loan;
		this.d_house_loan = d_house_loan;
		this.bank_name = bank_name;
		this.bank_pan_no = bank_pan_no;
		this.bank_address = bank_address;
		this.total_c = total_c;
		this.tdsHrBean = tdsHrBean;
	}


	@Id
	@Column(name="tds_hr_totalc_id")
	@GeneratedValue
	public int getTds_hr_totalc_id() {
		return tds_hr_totalc_id;
	}

	public void setTds_hr_totalc_id(int tds_hr_totalc_id) {
		this.tds_hr_totalc_id = tds_hr_totalc_id;
	}

	public double getOther_income() {
		return other_income;
	}

	public void setOther_income(double other_income) {
		this.other_income = other_income;
	}

	public double getA_house_loan() {
		return a_house_loan;
	}

	public void setA_house_loan(double a_house_loan) {
		this.a_house_loan = a_house_loan;
	}

	public double getD_house_loan() {
		return d_house_loan;
	}

	public void setD_house_loan(double d_house_loan) {
		this.d_house_loan = d_house_loan;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_pan_no() {
		return bank_pan_no;
	}

	public void setBank_pan_no(String bank_pan_no) {
		this.bank_pan_no = bank_pan_no;
	}

	public String getBank_address() {
		return bank_address;
	}

	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}

	public double getTotal_c() {
		return total_c;
	}

	public void setTotal_c(double total_c) {
		this.total_c = total_c;
	}

	@ManyToOne
	@JoinColumn(name="tds_hr_id")
	public TDSHrBean getTdsHrBean() {
		return tdsHrBean;
	}

	public void setTdsHrBean(TDSHrBean tdsHrBean) {
		this.tdsHrBean = tdsHrBean;
	}
	
}
