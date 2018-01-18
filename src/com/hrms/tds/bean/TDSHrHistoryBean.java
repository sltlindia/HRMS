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

@Entity
@Table(name="tds_hr_history_tbl")
public class TDSHrHistoryBean implements Serializable {

	private int tds_hr_history_id;
	private String status;
	private String submission_date;
	private String period;
	private double annual_gross_salary;
	private double bonus;
	private double leaveCount;
	private double incentive;
	private double previous_employeed_salary;
	private double performance_pay;
	private double full_final_leave;
	private double full_final_bonus;
	private double total_a;
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
	private String monthly_yearly;
	private double yearly_mealcard;
	private String monthly_start_date;
	private String monthly_end_date;
	private int days;
	private double monthly_mealcard;
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
	private double other_income;
	private double a_house_loan;
	private double d_house_loan;
	private String bank_name;
	private String bank_pan_no;
	private String bank_address;
	private double total_c;
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
	private double a_total_d;
	private double d_total_d;
	private double a_NPS;
	private double d_NPS;
	private double a_RGESS;
	private double d_RGESS;
	private double total_NPS_RGESS;
	private double total_e;
	private double a_self;
	private double d_self;
	private String father_birthdate;
	private double a_parents;
	private double d_parents;
	private double a_health_checkup;
	private double d_health_checkup;
	private double a_mediclaim;
	private double d_mediclaim;
	private String cash_cheque;
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
	private double tax_paid;
	private double tax_payable;
	
	private TDSHrBean tdsHrBean;
	private EmployeeBean employeeBean;
	
	public TDSHrHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public TDSHrHistoryBean(String status, String submission_date, String period, double annual_gross_salary,
			double bonus, double leaveCount, double incentive, double previous_employeed_salary, double performance_pay,
			double full_final_leave, double full_final_bonus, double total_a, double conveyance, double d_conveyance,
			String metro_non_metro, double a_total_basic, double d_non_metro_total_basic, double d_metro_total_basic,
			double a_rent_slip, double d_non_metro_rent_slip, double d_metro_rent_slip, double a_hra,
			double d_non_metro_hra, double d_metro_hra, double hra_non_metro_deduction, double hra_metro_deduction,
			double house_rant, String landlord_name, String landlord_pan_no, double a_medical, double provided_medical_bills, double d_medical,
			String monthly_yearly, double yearly_mealcard, String monthly_start_date, String monthly_end_date, int days,
			double monthly_mealcard, double meal_card, double lta_during_year, double actual_expenditure_lta,
			double d_lta, double ptax, int no_of_child, double d_education_allw, double uni_allw_during_year,
			double actual_expenditure_uni_allw, double d_uni_allw, double total_hra, double total_b,
			double other_income, double a_house_loan, double d_house_loan, String bank_name, String bank_pan_no,
			String bank_address, double total_c, double life_insurance, double ePF, double pPF, double nSC, double mF,
			double tuition_fees, double stamp_duty, double house_loan_principal, double tax_saver_deposite,
			String other_document, double other,  double a_total_d, double d_total_d, double a_NPS, double d_NPS, double a_RGESS,
			double d_RGESS, double total_NPS_RGESS, double total_e, double a_self, double d_self,
			String father_birthdate, double a_parents, double d_parents, double a_health_checkup,
			double d_health_checkup, double a_mediclaim, double d_mediclaim, String cash_cheque, double a_cash_amount,
			double d_cash_amount, double a_cheque_amount, double d_cheque_amount, double donation_80g,
			double a_donation_80GGC, double d_donation_80GGC, double education_loan, double total_80egd, double total_f,
			double tax, double tax_remit, double total_tax, double edu_cess, double total_h, double april, double may,
			double june, double july, double august, double september, double october, double november, double december,
			double january, double february, double march, double tax_paid, double tax_payable, TDSHrBean tdsHrBean,
			EmployeeBean employeeBean) {
		super();
		this.status = status;
		this.submission_date = submission_date;
		this.period = period;
		this.annual_gross_salary = annual_gross_salary;
		this.bonus = bonus;
		this.leaveCount = leaveCount;
		this.incentive = incentive;
		this.previous_employeed_salary = previous_employeed_salary;
		this.performance_pay = performance_pay;
		this.full_final_leave = full_final_leave;
		this.full_final_bonus = full_final_bonus;
		this.total_a = total_a;
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
		this.monthly_yearly = monthly_yearly;
		this.yearly_mealcard = yearly_mealcard;
		this.monthly_start_date = monthly_start_date;
		this.monthly_end_date = monthly_end_date;
		this.days = days;
		this.monthly_mealcard = monthly_mealcard;
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
		this.other_income = other_income;
		this.a_house_loan = a_house_loan;
		this.d_house_loan = d_house_loan;
		this.bank_name = bank_name;
		this.bank_pan_no = bank_pan_no;
		this.bank_address = bank_address;
		this.total_c = total_c;
		this.life_insurance = life_insurance;
		this.EPF = ePF;
		this.PPF = pPF;
		this.NSC = nSC;
		this.MF = mF;
		this.tuition_fees = tuition_fees;
		this.stamp_duty = stamp_duty;
		this.house_loan_principal = house_loan_principal;
		this.tax_saver_deposite = tax_saver_deposite;
		this.other_document = other_document;
		this.other = other;
		this.a_total_d = a_total_d;
		this.d_total_d = d_total_d;
		this.a_NPS = a_NPS;
		this.d_NPS = d_NPS;
		this.a_RGESS = a_RGESS;
		this.d_RGESS = d_RGESS;
		this.total_NPS_RGESS = total_NPS_RGESS;
		this.total_e = total_e;
		this.a_self = a_self;
		this.d_self = d_self;
		this.father_birthdate = father_birthdate;
		this.a_parents = a_parents;
		this.d_parents = d_parents;
		this.a_health_checkup = a_health_checkup;
		this.d_health_checkup = d_health_checkup;
		this.a_mediclaim = a_mediclaim;
		this.d_mediclaim = d_mediclaim;
		this.cash_cheque = cash_cheque;
		this.a_cash_amount = a_cash_amount;
		this.d_cash_amount = d_cash_amount;
		this.a_cheque_amount = a_cheque_amount;
		this.d_cheque_amount = d_cheque_amount;
		this.donation_80G = donation_80g;
		this.a_donation_80GGC = a_donation_80GGC;
		this.d_donation_80GGC = d_donation_80GGC;
		this.education_loan = education_loan;
		this.total_80EGD = total_80egd;
		this.total_f = total_f;
		this.tax = tax;
		this.tax_remit = tax_remit;
		this.total_tax = total_tax;
		this.edu_cess = edu_cess;
		this.total_h = total_h;
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
		this.tax_paid = tax_paid;
		this.tax_payable = tax_payable;
		this.tdsHrBean = tdsHrBean;
		this.employeeBean = employeeBean;
	}



	@Id
	@Column(name="tds_hr_history_id")
	@GeneratedValue
	public int getTds_hr_history_id() {
		return tds_hr_history_id;
	}
	public void setTds_hr_history_id(int tds_hr_history_id) {
		this.tds_hr_history_id = tds_hr_history_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public double getAnnual_gross_salary() {
		return annual_gross_salary;
	}
	public void setAnnual_gross_salary(double annual_gross_salary) {
		this.annual_gross_salary = annual_gross_salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getLeaveCount() {
		return leaveCount;
	}
	public void setLeaveCount(double leaveCount) {
		this.leaveCount = leaveCount;
	}
	public double getIncentive() {
		return incentive;
	}
	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	public double getPrevious_employeed_salary() {
		return previous_employeed_salary;
	}
	public void setPrevious_employeed_salary(double previous_employeed_salary) {
		this.previous_employeed_salary = previous_employeed_salary;
	}
	public double getPerformance_pay() {
		return performance_pay;
	}
	public void setPerformance_pay(double performance_pay) {
		this.performance_pay = performance_pay;
	}
	public double getFull_final_leave() {
		return full_final_leave;
	}
	public void setFull_final_leave(double full_final_leave) {
		this.full_final_leave = full_final_leave;
	}
	public double getFull_final_bonus() {
		return full_final_bonus;
	}
	public void setFull_final_bonus(double full_final_bonus) {
		this.full_final_bonus = full_final_bonus;
	}
	public double getTotal_a() {
		return total_a;
	}
	public void setTotal_a(double total_a) {
		this.total_a = total_a;
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
	public String getMonthly_yearly() {
		return monthly_yearly;
	}
	public void setMonthly_yearly(String monthly_yearly) {
		this.monthly_yearly = monthly_yearly;
	}
	public double getYearly_mealcard() {
		return yearly_mealcard;
	}
	public void setYearly_mealcard(double yearly_mealcard) {
		this.yearly_mealcard = yearly_mealcard;
	}
	public String getMonthly_start_date() {
		return monthly_start_date;
	}
	public void setMonthly_start_date(String monthly_start_date) {
		this.monthly_start_date = monthly_start_date;
	}
	public String getMonthly_end_date() {
		return monthly_end_date;
	}
	public void setMonthly_end_date(String monthly_end_date) {
		this.monthly_end_date = monthly_end_date;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public double getMonthly_mealcard() {
		return monthly_mealcard;
	}
	public void setMonthly_mealcard(double monthly_mealcard) {
		this.monthly_mealcard = monthly_mealcard;
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
	public String getOther_document() {
		return other_document;
	}
	public void setOther_document(String other_document) {
		this.other_document = other_document;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
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
	public double getA_NPS() {
		return a_NPS;
	}
	public void setA_NPS(double a_NPS) {
		this.a_NPS = a_NPS;
	}
	public double getD_NPS() {
		return d_NPS;
	}
	public void setD_NPS(double d_NPS) {
		this.d_NPS = d_NPS;
	}
	public double getA_RGESS() {
		return a_RGESS;
	}
	public void setA_RGESS(double a_RGESS) {
		this.a_RGESS = a_RGESS;
	}
	public double getD_RGESS() {
		return d_RGESS;
	}
	public void setD_RGESS(double d_RGESS) {
		this.d_RGESS = d_RGESS;
	}
	public double getTotal_NPS_RGESS() {
		return total_NPS_RGESS;
	}
	public void setTotal_NPS_RGESS(double total_NPS_RGESS) {
		this.total_NPS_RGESS = total_NPS_RGESS;
	}
	public double getTotal_e() {
		return total_e;
	}
	public void setTotal_e(double total_e) {
		this.total_e = total_e;
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
	public String getCash_cheque() {
		return cash_cheque;
	}
	public void setCash_cheque(String cash_cheque) {
		this.cash_cheque = cash_cheque;
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
	
	@ManyToOne
	@JoinColumn(name="tds_hr_id")
	public TDSHrBean getTdsHrBean() {
		return tdsHrBean;
	}
	public void setTdsHrBean(TDSHrBean tdsHrBean) {
		this.tdsHrBean = tdsHrBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
}
