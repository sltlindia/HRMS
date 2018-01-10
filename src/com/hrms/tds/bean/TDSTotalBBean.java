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
@Table(name="tds_totalb_tbl")
public class TDSTotalBBean implements Serializable{

	private int tds_totalb_id;
	private double conveyance;
	private double d_conveyance;
	private String metro_non_metro;
	private double a_total_basic;
	private double d_non_metro_total_basic;
	private double d_metro_total_basic;
	private double a_rent_slip;
	private double d_non_metro_rent_slip;
	private double d_metro_rent_slip;
	private double a_hra;
	private double d_non_metro_hra;
	private double d_metro_hra;
	private double hra_non_metro_deduction;
	private double hra_metro_deduction;
	private double house_rant;
	private String landlord_name;
	private String landlord_pan_no;
	private double a_medical;
	private double provided_medical_bills;
	private double d_medical;
	private double meal_card;
	private double lta_during_year;
	private double actual_expenditure_lta;
	private double d_lta;
	private double ptax;
	private int no_of_child;
	private double d_education_allw;
	private double uni_allw_during_year;
	private double actual_expenditure_uni_allw;
	private double d_uni_allw;
	private double total_hra;
	private double total_b;
	
	private TDSBean tdsBean;
	
	public TDSTotalBBean() {
		// TODO Auto-generated constructor stub
	}
	

	public TDSTotalBBean(double conveyance, double d_conveyance, String metro_non_metro, double a_total_basic,
			double d_non_metro_total_basic, double d_metro_total_basic, double a_rent_slip,
			double d_non_metro_rent_slip, double d_metro_rent_slip, double a_hra, double d_non_metro_hra,
			double d_metro_hra, double hra_non_metro_deduction, double hra_metro_deduction, double house_rant,
			String landlord_name, String landlord_pan_no, double a_medical, double provided_medical_bills,
			double d_medical, double meal_card, double lta_during_year,
			double actual_expenditure_lta, double d_lta, double ptax, int no_of_child, double d_education_allw,
			double uni_allw_during_year, double actual_expenditure_uni_allw, double d_uni_allw, double total_hra,
			double total_b, TDSBean tdsBean) {
		super();
		this.conveyance = conveyance;
		this.d_conveyance = d_conveyance;
		this.metro_non_metro = metro_non_metro;
		this.a_total_basic = a_total_basic;
		this.d_non_metro_total_basic = d_non_metro_total_basic;
		this.d_metro_total_basic = d_metro_total_basic;
		this.a_rent_slip = a_rent_slip;
		this.d_non_metro_rent_slip = d_non_metro_rent_slip;
		this.d_metro_rent_slip = d_metro_rent_slip;
		this.a_hra = a_hra;
		this.d_non_metro_hra = d_non_metro_hra;
		this.d_metro_hra = d_metro_hra;
		this.hra_non_metro_deduction = hra_non_metro_deduction;
		this.hra_metro_deduction = hra_metro_deduction;
		this.house_rant = house_rant;
		this.landlord_name = landlord_name;
		this.landlord_pan_no = landlord_pan_no;
		this.a_medical = a_medical;
		this.provided_medical_bills = provided_medical_bills;
		this.d_medical = d_medical;
		this.meal_card = meal_card;
		this.lta_during_year = lta_during_year;
		this.actual_expenditure_lta = actual_expenditure_lta;
		this.d_lta = d_lta;
		this.ptax = ptax;
		this.no_of_child = no_of_child;
		this.d_education_allw = d_education_allw;
		this.uni_allw_during_year = uni_allw_during_year;
		this.actual_expenditure_uni_allw = actual_expenditure_uni_allw;
		this.d_uni_allw = d_uni_allw;
		this.total_hra = total_hra;
		this.total_b = total_b;
		this.tdsBean = tdsBean;
	}

	public TDSTotalBBean(int tds_totalb_id, double conveyance, double d_conveyance, String metro_non_metro,
			double a_total_basic, double d_non_metro_total_basic, double d_metro_total_basic, double a_rent_slip,
			double d_non_metro_rent_slip, double d_metro_rent_slip, double a_hra, double d_non_metro_hra,
			double d_metro_hra, double hra_non_metro_deduction, double hra_metro_deduction, double house_rant,
			String landlord_name, String landlord_pan_no, double a_medical, double provided_medical_bills,
			double d_medical, double meal_card, double lta_during_year,
			double actual_expenditure_lta, double d_lta, double ptax, int no_of_child, double d_education_allw,
			double uni_allw_during_year, double actual_expenditure_uni_allw, double d_uni_allw, double total_hra,
			double total_b, TDSBean tdsBean) {
		super();
		this.tds_totalb_id = tds_totalb_id;
		this.conveyance = conveyance;
		this.d_conveyance = d_conveyance;
		this.metro_non_metro = metro_non_metro;
		this.a_total_basic = a_total_basic;
		this.d_non_metro_total_basic = d_non_metro_total_basic;
		this.d_metro_total_basic = d_metro_total_basic;
		this.a_rent_slip = a_rent_slip;
		this.d_non_metro_rent_slip = d_non_metro_rent_slip;
		this.d_metro_rent_slip = d_metro_rent_slip;
		this.a_hra = a_hra;
		this.d_non_metro_hra = d_non_metro_hra;
		this.d_metro_hra = d_metro_hra;
		this.hra_non_metro_deduction = hra_non_metro_deduction;
		this.hra_metro_deduction = hra_metro_deduction;
		this.house_rant = house_rant;
		this.landlord_name = landlord_name;
		this.landlord_pan_no = landlord_pan_no;
		this.a_medical = a_medical;
		this.provided_medical_bills = provided_medical_bills;
		this.d_medical = d_medical;
		this.meal_card = meal_card;
		this.lta_during_year = lta_during_year;
		this.actual_expenditure_lta = actual_expenditure_lta;
		this.d_lta = d_lta;
		this.ptax = ptax;
		this.no_of_child = no_of_child;
		this.d_education_allw = d_education_allw;
		this.uni_allw_during_year = uni_allw_during_year;
		this.actual_expenditure_uni_allw = actual_expenditure_uni_allw;
		this.d_uni_allw = d_uni_allw;
		this.total_hra = total_hra;
		this.total_b = total_b;
		this.tdsBean = tdsBean;
	}


	@Id
	@Column(name="tds_totalb_id")
	@GeneratedValue
	public int getTds_totalb_id() {
		return tds_totalb_id;
	}

	public void setTds_totalb_id(int tds_totalb_id) {
		this.tds_totalb_id = tds_totalb_id;
	}

	public double getConveyance() {
		return conveyance;
	}

	public void setConveyance(double conveyance) {
		this.conveyance = conveyance;
	}

	public double getD_conveyance() {
		return d_conveyance;
	}

	public void setD_conveyance(double d_conveyance) {
		this.d_conveyance = d_conveyance;
	}

	public String getMetro_non_metro() {
		return metro_non_metro;
	}

	public void setMetro_non_metro(String metro_non_metro) {
		this.metro_non_metro = metro_non_metro;
	}

	public double getA_total_basic() {
		return a_total_basic;
	}

	public void setA_total_basic(double a_total_basic) {
		this.a_total_basic = a_total_basic;
	}

	public double getD_non_metro_total_basic() {
		return d_non_metro_total_basic;
	}

	public void setD_non_metro_total_basic(double d_non_metro_total_basic) {
		this.d_non_metro_total_basic = d_non_metro_total_basic;
	}

	public double getD_metro_total_basic() {
		return d_metro_total_basic;
	}

	public void setD_metro_total_basic(double d_metro_total_basic) {
		this.d_metro_total_basic = d_metro_total_basic;
	}

	public double getA_rent_slip() {
		return a_rent_slip;
	}

	public void setA_rent_slip(double a_rent_slip) {
		this.a_rent_slip = a_rent_slip;
	}

	public double getD_non_metro_rent_slip() {
		return d_non_metro_rent_slip;
	}

	public void setD_non_metro_rent_slip(double d_non_metro_rent_slip) {
		this.d_non_metro_rent_slip = d_non_metro_rent_slip;
	}

	public double getD_metro_rent_slip() {
		return d_metro_rent_slip;
	}

	public void setD_metro_rent_slip(double d_metro_rent_slip) {
		this.d_metro_rent_slip = d_metro_rent_slip;
	}

	public double getA_hra() {
		return a_hra;
	}

	public void setA_hra(double a_hra) {
		this.a_hra = a_hra;
	}

	public double getD_non_metro_hra() {
		return d_non_metro_hra;
	}

	public void setD_non_metro_hra(double d_non_metro_hra) {
		this.d_non_metro_hra = d_non_metro_hra;
	}

	public double getD_metro_hra() {
		return d_metro_hra;
	}

	public void setD_metro_hra(double d_metro_hra) {
		this.d_metro_hra = d_metro_hra;
	}

	public double getHra_non_metro_deduction() {
		return hra_non_metro_deduction;
	}

	public void setHra_non_metro_deduction(double hra_non_metro_deduction) {
		this.hra_non_metro_deduction = hra_non_metro_deduction;
	}

	public double getHra_metro_deduction() {
		return hra_metro_deduction;
	}

	public void setHra_metro_deduction(double hra_metro_deduction) {
		this.hra_metro_deduction = hra_metro_deduction;
	}

	public double getHouse_rant() {
		return house_rant;
	}

	public void setHouse_rant(double house_rant) {
		this.house_rant = house_rant;
	}

	public String getLandlord_name() {
		return landlord_name;
	}

	public void setLandlord_name(String landlord_name) {
		this.landlord_name = landlord_name;
	}

	public String getLandlord_pan_no() {
		return landlord_pan_no;
	}

	public void setLandlord_pan_no(String landlord_pan_no) {
		this.landlord_pan_no = landlord_pan_no;
	}

	public double getA_medical() {
		return a_medical;
	}

	public void setA_medical(double a_medical) {
		this.a_medical = a_medical;
	}

	public double getProvided_medical_bills() {
		return provided_medical_bills;
	}

	public void setProvided_medical_bills(double provided_medical_bills) {
		this.provided_medical_bills = provided_medical_bills;
	}

	public double getD_medical() {
		return d_medical;
	}

	public void setD_medical(double d_medical) {
		this.d_medical = d_medical;
	}

	public double getMeal_card() {
		return meal_card;
	}

	public void setMeal_card(double meal_card) {
		this.meal_card = meal_card;
	}

	public double getLta_during_year() {
		return lta_during_year;
	}

	public void setLta_during_year(double lta_during_year) {
		this.lta_during_year = lta_during_year;
	}

	public double getActual_expenditure_lta() {
		return actual_expenditure_lta;
	}

	public void setActual_expenditure_lta(double actual_expenditure_lta) {
		this.actual_expenditure_lta = actual_expenditure_lta;
	}

	public double getD_lta() {
		return d_lta;
	}

	public void setD_lta(double d_lta) {
		this.d_lta = d_lta;
	}

	public double getPtax() {
		return ptax;
	}

	public void setPtax(double ptax) {
		this.ptax = ptax;
	}

	public int getNo_of_child() {
		return no_of_child;
	}

	public void setNo_of_child(int no_of_child) {
		this.no_of_child = no_of_child;
	}

	public double getD_education_allw() {
		return d_education_allw;
	}

	public void setD_education_allw(double d_education_allw) {
		this.d_education_allw = d_education_allw;
	}

	public double getUni_allw_during_year() {
		return uni_allw_during_year;
	}

	public void setUni_allw_during_year(double uni_allw_during_year) {
		this.uni_allw_during_year = uni_allw_during_year;
	}

	public double getActual_expenditure_uni_allw() {
		return actual_expenditure_uni_allw;
	}

	public void setActual_expenditure_uni_allw(double actual_expenditure_uni_allw) {
		this.actual_expenditure_uni_allw = actual_expenditure_uni_allw;
	}

	public double getD_uni_allw() {
		return d_uni_allw;
	}

	public void setD_uni_allw(double d_uni_allw) {
		this.d_uni_allw = d_uni_allw;
	}

	public double getTotal_hra() {
		return total_hra;
	}

	public void setTotal_hra(double total_hra) {
		this.total_hra = total_hra;
	}

	public double getTotal_b() {
		return total_b;
	}

	public void setTotal_b(double total_b) {
		this.total_b = total_b;
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
