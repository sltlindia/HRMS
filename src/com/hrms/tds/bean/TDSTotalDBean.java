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
@Table(name="tds_totald_tbl")
public class TDSTotalDBean implements Serializable{
	
	private int tds_totald_id;
	private double life_insurance;
	private double EPF;
	private double PPF;
	private double NSC;
	private double MF;
	private double tuition_fees;
	private double stamp_duty;
	private double house_loan_principal;
	private double tax_saver_deposite;
	private String other_document;
	private double other;
	private double total_d;
	private double a_total_d;
	private double d_total_d;
	private double payable_lic;
	private double payable_epf;
	private double payable_ppf;
	private double payable_nsc;
	private double payable_mf;
	private double payable_tuition_fees;
	private double payable_stamp_duty;
	private double payable_house_loan;
	private double payable_fix_deposite;
	private double payable_other;
	private double payable_a_total_d;
	private double payable_d_total_d;
	private double payable_total_d;
	
	private TDSBean tdsBean;
	
	public TDSTotalDBean() {
		// TODO Auto-generated constructor stub
	}
	
	public TDSTotalDBean(double life_insurance, double ePF, double pPF, double nSC, double mF, double tuition_fees,
			double stamp_duty, double house_loan_principal, double tax_saver_deposite, String other_document,
			double other, double a_total_d, double d_total_d, double total_d, double payable_lic, double payable_epf,
			double payable_ppf, double payable_nsc, double payable_mf, double payable_tuition_fees,
			double payable_stamp_duty, double payable_house_loan, double payable_fix_deposite, double payable_other,
			double payable_a_total_d, double payable_d_total_d, double payable_total_d, TDSBean tdsBean) {
		super();
		this.life_insurance = life_insurance;
		EPF = ePF;
		PPF = pPF;
		NSC = nSC;
		MF = mF;
		this.tuition_fees = tuition_fees;
		this.stamp_duty = stamp_duty;
		this.house_loan_principal = house_loan_principal;
		this.tax_saver_deposite = tax_saver_deposite;
		this.other_document = other_document;
		this.other = other;
		this.a_total_d = a_total_d;
		this.d_total_d = d_total_d;
		this.total_d = total_d;
		this.payable_lic = payable_lic;
		this.payable_epf = payable_epf;
		this.payable_ppf = payable_ppf;
		this.payable_nsc = payable_nsc;
		this.payable_mf = payable_mf;
		this.payable_tuition_fees = payable_tuition_fees;
		this.payable_stamp_duty = payable_stamp_duty;
		this.payable_house_loan = payable_house_loan;
		this.payable_fix_deposite = payable_fix_deposite;
		this.payable_other = payable_other;
		this.payable_a_total_d = payable_a_total_d;
		this.payable_d_total_d = payable_d_total_d;
		this.payable_total_d = payable_total_d;
		this.tdsBean = tdsBean;
	}

	public TDSTotalDBean(int tds_totald_id, double life_insurance, double ePF, double pPF, double nSC, double mF,
			double tuition_fees, double stamp_duty, double house_loan_principal, double tax_saver_deposite,
			String other_document, double other, double a_total_d, double d_total_d, double total_d, double payable_lic,
			double payable_epf, double payable_ppf, double payable_nsc, double payable_mf, double payable_tuition_fees,
			double payable_stamp_duty, double payable_house_loan, double payable_fix_deposite, double payable_other,
			double payable_a_total_d, double payable_d_total_d, double payable_total_d, TDSBean tdsBean) {
		super();
		this.tds_totald_id = tds_totald_id;
		this.life_insurance = life_insurance;
		EPF = ePF;
		PPF = pPF;
		NSC = nSC;
		MF = mF;
		this.tuition_fees = tuition_fees;
		this.stamp_duty = stamp_duty;
		this.house_loan_principal = house_loan_principal;
		this.tax_saver_deposite = tax_saver_deposite;
		this.other_document = other_document;
		this.other = other;
		this.a_total_d = a_total_d;
		this.d_total_d = d_total_d;
		this.total_d = total_d;
		this.payable_lic = payable_lic;
		this.payable_epf = payable_epf;
		this.payable_ppf = payable_ppf;
		this.payable_nsc = payable_nsc;
		this.payable_mf = payable_mf;
		this.payable_tuition_fees = payable_tuition_fees;
		this.payable_stamp_duty = payable_stamp_duty;
		this.payable_house_loan = payable_house_loan;
		this.payable_fix_deposite = payable_fix_deposite;
		this.payable_other = payable_other;
		this.payable_a_total_d = payable_a_total_d;
		this.payable_d_total_d = payable_d_total_d;
		this.payable_total_d = payable_total_d;
		this.tdsBean = tdsBean;
	}


	@Id
	@Column(name="tds_totald_id")
	@GeneratedValue
	public int getTds_totald_id() {
		return tds_totald_id;
	}

	public void setTds_totald_id(int tds_totald_id) {
		this.tds_totald_id = tds_totald_id;
	}

	public double getLife_insurance() {
		return life_insurance;
	}

	public void setLife_insurance(double life_insurance) {
		this.life_insurance = life_insurance;
	}

	public double getEPF() {
		return EPF;
	}

	public void setEPF(double ePF) {
		EPF = ePF;
	}

	public double getPPF() {
		return PPF;
	}

	public void setPPF(double pPF) {
		PPF = pPF;
	}

	public double getNSC() {
		return NSC;
	}

	public void setNSC(double nSC) {
		NSC = nSC;
	}

	public double getMF() {
		return MF;
	}

	public void setMF(double mF) {
		MF = mF;
	}

	public double getTuition_fees() {
		return tuition_fees;
	}

	public void setTuition_fees(double tuition_fees) {
		this.tuition_fees = tuition_fees;
	}

	public double getStamp_duty() {
		return stamp_duty;
	}

	public void setStamp_duty(double stamp_duty) {
		this.stamp_duty = stamp_duty;
	}

	public double getHouse_loan_principal() {
		return house_loan_principal;
	}

	public void setHouse_loan_principal(double house_loan_principal) {
		this.house_loan_principal = house_loan_principal;
	}

	public double getTax_saver_deposite() {
		return tax_saver_deposite;
	}

	public void setTax_saver_deposite(double tax_saver_deposite) {
		this.tax_saver_deposite = tax_saver_deposite;
	}
	
	public double getOther() {
		return other;
	}

	public void setOther(double other) {
		this.other = other;
	}
	
	public String getOther_document() {
		return other_document;
	}

	public void setOther_document(String other_document) {
		this.other_document = other_document;
	}

	public double getA_total_d() {
		return a_total_d;
	}

	public void setA_total_d(double a_total_d) {
		this.a_total_d = a_total_d;
	}

	public double getD_total_d() {
		return d_total_d;
	}

	public void setD_total_d(double d_total_d) {
		this.d_total_d = d_total_d;
	}
	
	public double getTotal_d() {
		return total_d;
	}

	public void setTotal_d(double total_d) {
		this.total_d = total_d;
	}
	
	public double getPayable_lic() {
		return payable_lic;
	}

	public void setPayable_lic(double payable_lic) {
		this.payable_lic = payable_lic;
	}

	public double getPayable_epf() {
		return payable_epf;
	}

	public void setPayable_epf(double payable_epf) {
		this.payable_epf = payable_epf;
	}

	public double getPayable_ppf() {
		return payable_ppf;
	}

	public void setPayable_ppf(double payable_ppf) {
		this.payable_ppf = payable_ppf;
	}

	public double getPayable_nsc() {
		return payable_nsc;
	}

	public void setPayable_nsc(double payable_nsc) {
		this.payable_nsc = payable_nsc;
	}

	public double getPayable_mf() {
		return payable_mf;
	}

	public void setPayable_mf(double payable_mf) {
		this.payable_mf = payable_mf;
	}

	public double getPayable_tuition_fees() {
		return payable_tuition_fees;
	}

	public void setPayable_tuition_fees(double payable_tuition_fees) {
		this.payable_tuition_fees = payable_tuition_fees;
	}

	public double getPayable_stamp_duty() {
		return payable_stamp_duty;
	}

	public void setPayable_stamp_duty(double payable_stamp_duty) {
		this.payable_stamp_duty = payable_stamp_duty;
	}

	public double getPayable_house_loan() {
		return payable_house_loan;
	}

	public void setPayable_house_loan(double payable_house_loan) {
		this.payable_house_loan = payable_house_loan;
	}

	public double getPayable_fix_deposite() {
		return payable_fix_deposite;
	}

	public void setPayable_fix_deposite(double payable_fix_deposite) {
		this.payable_fix_deposite = payable_fix_deposite;
	}

	public double getPayable_other() {
		return payable_other;
	}

	public void setPayable_other(double payable_other) {
		this.payable_other = payable_other;
	}

	public double getPayable_a_total_d() {
		return payable_a_total_d;
	}

	public void setPayable_a_total_d(double payable_a_total_d) {
		this.payable_a_total_d = payable_a_total_d;
	}

	public double getPayable_d_total_d() {
		return payable_d_total_d;
	}

	public void setPayable_d_total_d(double payable_d_total_d) {
		this.payable_d_total_d = payable_d_total_d;
	}
	
	public double getPayable_total_d() {
		return payable_total_d;
	}

	public void setPayable_total_d(double payable_total_d) {
		this.payable_total_d = payable_total_d;
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
