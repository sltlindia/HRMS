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
@Table(name="tds_totalc_tbl")
public class TDSTotalCBean implements Serializable{
	
	private int tds_totalc_id;
	private double other_income;
	private double a_house_loan;
	private double d_house_loan;
	private String bank_name;
	private String bank_pan_no;
	private String bank_address;
	private double total_c;
	
	private TDSBean tdsBean;
	
	public TDSTotalCBean() {
		// TODO Auto-generated constructor stub
	}
	
	public TDSTotalCBean(double other_income, double a_house_loan, double d_house_loan, String bank_name,
			String bank_pan_no, String bank_address, double total_c, TDSBean tdsBean) {
		super();
		this.other_income = other_income;
		this.a_house_loan = a_house_loan;
		this.d_house_loan = d_house_loan;
		this.bank_name = bank_name;
		this.bank_pan_no = bank_pan_no;
		this.bank_address = bank_address;
		this.total_c = total_c;
		this.tdsBean = tdsBean;
	}
	
	

	public TDSTotalCBean(int tds_totalc_id, double other_income, double a_house_loan, double d_house_loan,
			String bank_name, String bank_pan_no, String bank_address, double total_c, TDSBean tdsBean) {
		super();
		this.tds_totalc_id = tds_totalc_id;
		this.other_income = other_income;
		this.a_house_loan = a_house_loan;
		this.d_house_loan = d_house_loan;
		this.bank_name = bank_name;
		this.bank_pan_no = bank_pan_no;
		this.bank_address = bank_address;
		this.total_c = total_c;
		this.tdsBean = tdsBean;
	}

	@Id
	@Column(name="tds_totalc_id")
	@GeneratedValue
	public int getTds_totalc_id() {
		return tds_totalc_id;
	}

	public void setTds_totalc_id(int tds_totalc_id) {
		this.tds_totalc_id = tds_totalc_id;
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
	@JoinColumn(name="tds_id")
	public TDSBean getTdsBean() {
		return tdsBean;
	}

	public void setTdsBean(TDSBean tdsBean) {
		this.tdsBean = tdsBean;
	}
	
	
}
