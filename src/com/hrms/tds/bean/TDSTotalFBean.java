package com.hrms.tds.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tds_totalf_tbl")
public class TDSTotalFBean implements Serializable{

	private int tds_totalf_id;
	private double a_self;
	private double d_self;
	private String father_birthdate;
	private double a_parents;
	private double d_parents;
	private double a_health_checkup;
	private double d_health_checkup;
	private double a_mediclaim;
	private double d_mediclaim;
	private double a_cash_amount;
	private double d_cash_amount;
	private double a_cheque_amount;
	private double d_cheque_amount;
	private double donation_80G;
	private double a_donation_80GGC;
	private double d_donation_80GGC;
	private double education_loan;
	private double total_80EGD;
	private double total_f;
	private double tax;
	private double tax_remit;
	private double total_tax;
	private double edu_cess;
	private double total_h;
	private double tax_paid;
	private double tax_payable;
	private double payable_total_f;
	private double payable_tax;
	private double payable_tax_remit;
	private double payable_total_tax;
	private double payable_edu_cess;
	private double payable_total_h;
	private double april;
	private double may;
	private double june;
	private double july;
	private double august;
	private double september;
	private double october;
	private double november;
	private double december;
	private double january;
	private double february;
	private double march;
	
	private TDSBean tdsBean;
	
	public TDSTotalFBean() {
		// TODO Auto-generated constructor stub
	}

	

	public TDSTotalFBean(int tds_totalf_id, double a_self, double d_self, String father_birthdate, double a_parents,
			double d_parents, double a_health_checkup, double d_health_checkup, double a_mediclaim, double d_mediclaim,
			double a_cash_amount, double d_cash_amount, double a_cheque_amount,
			double d_cheque_amount, double donation_80g, double a_donation_80GGC, double d_donation_80GGC,
			double education_loan, double total_80egd, double total_f, double tax, double tax_remit, double total_tax,
			double edu_cess, double total_h, double tax_paid, double tax_payable, double payable_total_f,
			double payable_tax, double payable_tax_remit, double payable_total_tax, double payable_edu_cess,
			double payable_total_h, double april, double may, double june, double july, double august, double september,
			double october, double november, double december, double january, double february, double march,
			TDSBean tdsBean) {
		super();
		this.tds_totalf_id = tds_totalf_id;
		this.a_self = a_self;
		this.d_self = d_self;
		this.father_birthdate = father_birthdate;
		this.a_parents = a_parents;
		this.d_parents = d_parents;
		this.a_health_checkup = a_health_checkup;
		this.d_health_checkup = d_health_checkup;
		this.a_mediclaim = a_mediclaim;
		this.d_mediclaim = d_mediclaim;
		this.a_cash_amount = a_cash_amount;
		this.d_cash_amount = d_cash_amount;
		this.a_cheque_amount = a_cheque_amount;
		this.d_cheque_amount = d_cheque_amount;
		donation_80G = donation_80g;
		this.a_donation_80GGC = a_donation_80GGC;
		this.d_donation_80GGC = d_donation_80GGC;
		this.education_loan = education_loan;
		total_80EGD = total_80egd;
		this.total_f = total_f;
		this.tax = tax;
		this.tax_remit = tax_remit;
		this.total_tax = total_tax;
		this.edu_cess = edu_cess;
		this.total_h = total_h;
		this.tax_paid = tax_paid;
		this.tax_payable = tax_payable;
		this.payable_total_f = payable_total_f;
		this.payable_tax = payable_tax;
		this.payable_tax_remit = payable_tax_remit;
		this.payable_total_tax = payable_total_tax;
		this.payable_edu_cess = payable_edu_cess;
		this.payable_total_h = payable_total_h;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
		this.january = january;
		this.february = february;
		this.march = march;
		this.tdsBean = tdsBean;
	}


	public TDSTotalFBean(double a_self, double d_self, String father_birthdate, double a_parents, double d_parents,
			double a_health_checkup, double d_health_checkup, double a_mediclaim, double d_mediclaim,
			double a_cash_amount, double d_cash_amount, double a_cheque_amount,
			double d_cheque_amount, double donation_80g, double a_donation_80GGC, double d_donation_80GGC,
			double education_loan, double total_80egd, double total_f, double tax, double tax_remit, double total_tax,
			double edu_cess, double total_h, double tax_paid, double tax_payable, double payable_total_f,
			double payable_tax, double payable_tax_remit, double payable_total_tax, double payable_edu_cess,
			double payable_total_h, double april, double may, double june, double july, double august, double september,
			double october, double november, double december, double january, double february, double march,
			TDSBean tdsBean) {
		super();
		this.a_self = a_self;
		this.d_self = d_self;
		this.father_birthdate = father_birthdate;
		this.a_parents = a_parents;
		this.d_parents = d_parents;
		this.a_health_checkup = a_health_checkup;
		this.d_health_checkup = d_health_checkup;
		this.a_mediclaim = a_mediclaim;
		this.d_mediclaim = d_mediclaim;
		this.a_cash_amount = a_cash_amount;
		this.d_cash_amount = d_cash_amount;
		this.a_cheque_amount = a_cheque_amount;
		this.d_cheque_amount = d_cheque_amount;
		donation_80G = donation_80g;
		this.a_donation_80GGC = a_donation_80GGC;
		this.d_donation_80GGC = d_donation_80GGC;
		this.education_loan = education_loan;
		total_80EGD = total_80egd;
		this.total_f = total_f;
		this.tax = tax;
		this.tax_remit = tax_remit;
		this.total_tax = total_tax;
		this.edu_cess = edu_cess;
		this.total_h = total_h;
		this.tax_paid = tax_paid;
		this.tax_payable = tax_payable;
		this.payable_total_f = payable_total_f;
		this.payable_tax = payable_tax;
		this.payable_tax_remit = payable_tax_remit;
		this.payable_total_tax = payable_total_tax;
		this.payable_edu_cess = payable_edu_cess;
		this.payable_total_h = payable_total_h;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
		this.january = january;
		this.february = february;
		this.march = march;
		this.tdsBean = tdsBean;
	}



	@Id
	@Column(name="tds_totalf_id")
	@GeneratedValue
	public int getTds_totalf_id() {
		return tds_totalf_id;
	}

	public void setTds_totalf_id(int tds_totalf_id) {
		this.tds_totalf_id = tds_totalf_id;
	}

	public double getA_self() {
		return a_self;
	}

	public void setA_self(double a_self) {
		this.a_self = a_self;
	}

	public double getD_self() {
		return d_self;
	}

	public void setD_self(double d_self) {
		this.d_self = d_self;
	}

	public String getFather_birthdate() {
		return father_birthdate;
	}

	public void setFather_birthdate(String father_birthdate) {
		this.father_birthdate = father_birthdate;
	}

	public double getA_parents() {
		return a_parents;
	}

	public void setA_parents(double a_parents) {
		this.a_parents = a_parents;
	}

	public double getD_parents() {
		return d_parents;
	}

	public void setD_parents(double d_parents) {
		this.d_parents = d_parents;
	}

	public double getA_health_checkup() {
		return a_health_checkup;
	}

	public void setA_health_checkup(double a_health_checkup) {
		this.a_health_checkup = a_health_checkup;
	}

	public double getD_health_checkup() {
		return d_health_checkup;
	}

	public void setD_health_checkup(double d_health_checkup) {
		this.d_health_checkup = d_health_checkup;
	}

	public double getA_mediclaim() {
		return a_mediclaim;
	}

	public void setA_mediclaim(double a_mediclaim) {
		this.a_mediclaim = a_mediclaim;
	}

	public double getD_mediclaim() {
		return d_mediclaim;
	}

	public void setD_mediclaim(double d_mediclaim) {
		this.d_mediclaim = d_mediclaim;
	}

	public double getA_cash_amount() {
		return a_cash_amount;
	}

	public void setA_cash_amount(double a_cash_amount) {
		this.a_cash_amount = a_cash_amount;
	}

	public double getD_cash_amount() {
		return d_cash_amount;
	}

	public void setD_cash_amount(double d_cash_amount) {
		this.d_cash_amount = d_cash_amount;
	}

	public double getA_cheque_amount() {
		return a_cheque_amount;
	}

	public void setA_cheque_amount(double a_cheque_amount) {
		this.a_cheque_amount = a_cheque_amount;
	}

	public double getD_cheque_amount() {
		return d_cheque_amount;
	}

	public void setD_cheque_amount(double d_cheque_amount) {
		this.d_cheque_amount = d_cheque_amount;
	}
	
	public double getDonation_80G() {
		return donation_80G;
	}

	public void setDonation_80G(double donation_80g) {
		donation_80G = donation_80g;
	}

	public double getA_donation_80GGC() {
		return a_donation_80GGC;
	}

	public void setA_donation_80GGC(double a_donation_80GGC) {
		this.a_donation_80GGC = a_donation_80GGC;
	}

	public double getD_donation_80GGC() {
		return d_donation_80GGC;
	}

	public void setD_donation_80GGC(double d_donation_80GGC) {
		this.d_donation_80GGC = d_donation_80GGC;
	}

	public double getEducation_loan() {
		return education_loan;
	}

	public void setEducation_loan(double education_loan) {
		this.education_loan = education_loan;
	}

	public double getTotal_80EGD() {
		return total_80EGD;
	}

	public void setTotal_80EGD(double total_80egd) {
		total_80EGD = total_80egd;
	}

	public double getTotal_f() {
		return total_f;
	}

	public void setTotal_f(double total_f) {
		this.total_f = total_f;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTax_remit() {
		return tax_remit;
	}

	public void setTax_remit(double tax_remit) {
		this.tax_remit = tax_remit;
	}

	public double getTotal_tax() {
		return total_tax;
	}

	public void setTotal_tax(double total_tax) {
		this.total_tax = total_tax;
	}

	public double getEdu_cess() {
		return edu_cess;
	}

	public void setEdu_cess(double edu_cess) {
		this.edu_cess = edu_cess;
	}

	public double getTotal_h() {
		return total_h;
	}

	public void setTotal_h(double total_h) {
		this.total_h = total_h;
	}
	
	
	public double getTax_paid() {
		return tax_paid;
	}

	public void setTax_paid(double tax_paid) {
		this.tax_paid = tax_paid;
	}

	public double getTax_payable() {
		return tax_payable;
	}

	public void setTax_payable(double tax_payable) {
		this.tax_payable = tax_payable;
	}

	public double getPayable_total_f() {
		return payable_total_f;
	}

	public void setPayable_total_f(double payable_total_f) {
		this.payable_total_f = payable_total_f;
	}

	public double getPayable_tax() {
		return payable_tax;
	}

	public void setPayable_tax(double payable_tax) {
		this.payable_tax = payable_tax;
	}

	public double getPayable_tax_remit() {
		return payable_tax_remit;
	}

	public void setPayable_tax_remit(double payable_tax_remit) {
		this.payable_tax_remit = payable_tax_remit;
	}

	public double getPayable_total_tax() {
		return payable_total_tax;
	}

	public void setPayable_total_tax(double payable_total_tax) {
		this.payable_total_tax = payable_total_tax;
	}

	public double getPayable_edu_cess() {
		return payable_edu_cess;
	}

	public void setPayable_edu_cess(double payable_edu_cess) {
		this.payable_edu_cess = payable_edu_cess;
	}

	public double getPayable_total_h() {
		return payable_total_h;
	}

	public void setPayable_total_h(double payable_total_h) {
		this.payable_total_h = payable_total_h;
	}

	public double getApril() {
		return april;
	}

	public void setApril(double april) {
		this.april = april;
	}

	public double getMay() {
		return may;
	}

	public void setMay(double may) {
		this.may = may;
	}

	public double getJune() {
		return june;
	}

	public void setJune(double june) {
		this.june = june;
	}

	public double getJuly() {
		return july;
	}

	public void setJuly(double july) {
		this.july = july;
	}

	public double getAugust() {
		return august;
	}

	public void setAugust(double august) {
		this.august = august;
	}

	public double getSeptember() {
		return september;
	}

	public void setSeptember(double september) {
		this.september = september;
	}

	public double getOctober() {
		return october;
	}

	public void setOctober(double october) {
		this.october = october;
	}

	public double getNovember() {
		return november;
	}

	public void setNovember(double november) {
		this.november = november;
	}

	public double getDecember() {
		return december;
	}

	public void setDecember(double december) {
		this.december = december;
	}

	public double getJanuary() {
		return january;
	}

	public void setJanuary(double january) {
		this.january = january;
	}

	public double getFebruary() {
		return february;
	}

	public void setFebruary(double february) {
		this.february = february;
	}

	public double getMarch() {
		return march;
	}

	public void setMarch(double march) {
		this.march = march;
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
