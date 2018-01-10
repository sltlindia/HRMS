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
@Table(name="tds_payroll_master_data_tbl")
public class TDSPayrollMasterDataBean implements Serializable{

	private int tds_payroll_master_data_id;
	private int employee_code;
	private String company_name;
	private String employee_name;
	private String pan_no;
	private String date_of_birth;
	private String designation;
	private String gender;
	private String joining_date;
	private String from_date;
	private String to_date;
	private String resign_date;
	private String period;
	private double salary;
	private double bonus;
	private double leave_count;
	private double interest;
	private double full_final_bonus;
	private double full_final_leave;
	private double incentive;
	private double previous_salary;
	private double performance;
	private double total_a;
	private double conveyance;
	private double hra;
	private double medical_allw;
	private double mealcard;
	private double education_allw;
	private double lta;
	private double ptax;
	private double uniform_allw;
	private double other_allw;
	private double total_b;
	private double houseloan_interest;
	private double other_income;
	private double final_houseloan_interest;
	private double total_c;
	private double lic;
	private double epf;
	private double ppf;
	private double nsc;
	private double mf;
	private double tuition_fees;
	private double house_loan_principal;
	private double stamp_duty;
	private double tax_saver_deposite;
	private double other;
	private double total_d;
	private double total_80c;
	private double nps;
	private double rgess;
	private double total_e;
	private double mediclaim;
	private double donation;
	private double final_donation;
	private double edu_loan_interest;
	private double total_f;
	private double a10;
	private double total_g;
	private double tax;
	private double tax_remit;
	private double total_tax;
	private double edu_cess;
	private double total_h;
	private double tax_payable;
	private double previous_tax_paid;
	private double tax_paid;
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
	
	private MonthBean monthBean;
	private YearBean yearBean;
	
	public TDSPayrollMasterDataBean() {
		// TODO Auto-generated constructor stub
	}
	

	public TDSPayrollMasterDataBean(int employee_code, String company_name, String employee_name, String pan_no,
			String date_of_birth, String designation, String gender, String joining_date, String from_date,
			String to_date, String resign_date, String period, double salary, double bonus, double leave_count,
			double interest, double full_final_bonus, double full_final_leave, double incentive, double previous_salary,
			double performance, double total_a, double conveyance, double hra, double medical_allw, double mealcard,
			double education_allw, double lta, double ptax, double uniform_allw, double other_allw, double total_b,
			double houseloan_interest, double other_income, double final_houseloan_interest, double total_c, double lic,
			double epf, double ppf, double nsc, double mf, double tuition_fees, double house_loan_principal,
			double stamp_duty, double tax_saver_deposite, double other, double total_d, double total_80c, double nps,
			double rgess, double total_e, double mediclaim, double donation, double final_donation,
			double edu_loan_interest, double total_f, double a10, double total_g, double tax, double tax_remit,
			double total_tax, double edu_cess, double total_h, double tax_payable, double previous_tax_paid,
			double tax_paid, double april, double may, double june, double july, double august, double september,
			double october, double november, double december, double january, double february, double march,
			MonthBean monthBean, YearBean yearBean) {
		super();
		this.employee_code = employee_code;
		this.company_name = company_name;
		this.employee_name = employee_name;
		this.pan_no = pan_no;
		this.date_of_birth = date_of_birth;
		this.designation = designation;
		this.gender = gender;
		this.joining_date = joining_date;
		this.from_date = from_date;
		this.to_date = to_date;
		this.resign_date = resign_date;
		this.period = period;
		this.salary = salary;
		this.bonus = bonus;
		this.leave_count = leave_count;
		this.interest = interest;
		this.full_final_bonus = full_final_bonus;
		this.full_final_leave = full_final_leave;
		this.incentive = incentive;
		this.previous_salary = previous_salary;
		this.performance = performance;
		this.total_a = total_a;
		this.conveyance = conveyance;
		this.hra = hra;
		this.medical_allw = medical_allw;
		this.mealcard = mealcard;
		this.education_allw = education_allw;
		this.lta = lta;
		this.ptax = ptax;
		this.uniform_allw = uniform_allw;
		this.other_allw = other_allw;
		this.total_b = total_b;
		this.houseloan_interest = houseloan_interest;
		this.other_income = other_income;
		this.final_houseloan_interest = final_houseloan_interest;
		this.total_c = total_c;
		this.lic = lic;
		this.epf = epf;
		this.ppf = ppf;
		this.nsc = nsc;
		this.mf = mf;
		this.tuition_fees = tuition_fees;
		this.house_loan_principal = house_loan_principal;
		this.stamp_duty = stamp_duty;
		this.tax_saver_deposite = tax_saver_deposite;
		this.other = other;
		this.total_d = total_d;
		this.total_80c = total_80c;
		this.nps = nps;
		this.rgess = rgess;
		this.total_e = total_e;
		this.mediclaim = mediclaim;
		this.donation = donation;
		this.final_donation = final_donation;
		this.edu_loan_interest = edu_loan_interest;
		this.total_f = total_f;
		this.a10 = a10;
		this.total_g = total_g;
		this.tax = tax;
		this.tax_remit = tax_remit;
		this.total_tax = total_tax;
		this.edu_cess = edu_cess;
		this.total_h = total_h;
		this.tax_payable = tax_payable;
		this.previous_tax_paid = previous_tax_paid;
		this.tax_paid = tax_paid;
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
		this.monthBean = monthBean;
		this.yearBean = yearBean;
	}



	@Id
	@GeneratedValue
	@Column(name="tds_payroll_master_data_id")
	public int getTds_payroll_master_data_id() {
		return tds_payroll_master_data_id;
	}
	public void setTds_payroll_master_data_id(int tds_payroll_master_data_id) {
		this.tds_payroll_master_data_id = tds_payroll_master_data_id;
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
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getResign_date() {
		return resign_date;
	}
	public void setResign_date(String resign_date) {
		this.resign_date = resign_date;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getLeave_count() {
		return leave_count;
	}
	public void setLeave_count(double leave_count) {
		this.leave_count = leave_count;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getFull_final_bonus() {
		return full_final_bonus;
	}
	public void setFull_final_bonus(double full_final_bonus) {
		this.full_final_bonus = full_final_bonus;
	}
	public double getFull_final_leave() {
		return full_final_leave;
	}
	public void setFull_final_leave(double full_final_leave) {
		this.full_final_leave = full_final_leave;
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
	public double getPerformance() {
		return performance;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
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
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getMedical_allw() {
		return medical_allw;
	}
	public void setMedical_allw(double medical_allw) {
		this.medical_allw = medical_allw;
	}
	public double getMealcard() {
		return mealcard;
	}
	public void setMealcard(double mealcard) {
		this.mealcard = mealcard;
	}
	public double getEducation_allw() {
		return education_allw;
	}
	public void setEducation_allw(double education_allw) {
		this.education_allw = education_allw;
	}
	public double getLta() {
		return lta;
	}
	public void setLta(double lta) {
		this.lta = lta;
	}
	public double getPtax() {
		return ptax;
	}
	public void setPtax(double ptax) {
		this.ptax = ptax;
	}
	public double getUniform_allw() {
		return uniform_allw;
	}
	public void setUniform_allw(double uniform_allw) {
		this.uniform_allw = uniform_allw;
	}
	public double getOther_allw() {
		return other_allw;
	}
	public void setOther_allw(double other_allw) {
		this.other_allw = other_allw;
	}
	public double getTotal_b() {
		return total_b;
	}
	public void setTotal_b(double total_b) {
		this.total_b = total_b;
	}
	public double getHouseloan_interest() {
		return houseloan_interest;
	}
	public void setHouseloan_interest(double houseloan_interest) {
		this.houseloan_interest = houseloan_interest;
	}
	public double getOther_income() {
		return other_income;
	}
	public void setOther_income(double other_income) {
		this.other_income = other_income;
	}
	public double getFinal_houseloan_interest() {
		return final_houseloan_interest;
	}
	public void setFinal_houseloan_interest(double final_houseloan_interest) {
		this.final_houseloan_interest = final_houseloan_interest;
	}
	public double getTotal_c() {
		return total_c;
	}
	public void setTotal_c(double total_c) {
		this.total_c = total_c;
	}
	public double getLic() {
		return lic;
	}
	public void setLic(double lic) {
		this.lic = lic;
	}
	public double getEpf() {
		return epf;
	}
	public void setEpf(double epf) {
		this.epf = epf;
	}
	public double getPpf() {
		return ppf;
	}
	public void setPpf(double ppf) {
		this.ppf = ppf;
	}
	public double getNsc() {
		return nsc;
	}
	public void setNsc(double nsc) {
		this.nsc = nsc;
	}
	public double getMf() {
		return mf;
	}
	public void setMf(double mf) {
		this.mf = mf;
	}
	public double getTuition_fees() {
		return tuition_fees;
	}
	public void setTuition_fees(double tuition_fees) {
		this.tuition_fees = tuition_fees;
	}
	public double getHouse_loan_principal() {
		return house_loan_principal;
	}
	public void setHouse_loan_principal(double house_loan_principal) {
		this.house_loan_principal = house_loan_principal;
	}
	public double getStamp_duty() {
		return stamp_duty;
	}
	public void setStamp_duty(double stamp_duty) {
		this.stamp_duty = stamp_duty;
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
	public double getTotal_d() {
		return total_d;
	}
	public void setTotal_d(double total_d) {
		this.total_d = total_d;
	}
	public double getTotal_80c() {
		return total_80c;
	}
	public void setTotal_80c(double total_80c) {
		this.total_80c = total_80c;
	}
	public double getNps() {
		return nps;
	}
	public void setNps(double nps) {
		this.nps = nps;
	}
	public double getRgess() {
		return rgess;
	}
	public void setRgess(double rgess) {
		this.rgess = rgess;
	}
	public double getTotal_e() {
		return total_e;
	}
	public void setTotal_e(double total_e) {
		this.total_e = total_e;
	}
	public double getMediclaim() {
		return mediclaim;
	}
	public void setMediclaim(double mediclaim) {
		this.mediclaim = mediclaim;
	}
	public double getDonation() {
		return donation;
	}
	public void setDonation(double donation) {
		this.donation = donation;
	}
	public double getFinal_donation() {
		return final_donation;
	}
	public void setFinal_donation(double final_donation) {
		this.final_donation = final_donation;
	}
	public double getEdu_loan_interest() {
		return edu_loan_interest;
	}
	public void setEdu_loan_interest(double edu_loan_interest) {
		this.edu_loan_interest = edu_loan_interest;
	}
	public double getTotal_f() {
		return total_f;
	}
	public void setTotal_f(double total_f) {
		this.total_f = total_f;
	}
	public double getA10() {
		return a10;
	}
	public void setA10(double a10) {
		this.a10 = a10;
	}
	public double getTotal_g() {
		return total_g;
	}
	public void setTotal_g(double total_g) {
		this.total_g = total_g;
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
	public double getTax_payable() {
		return tax_payable;
	}
	public void setTax_payable(double tax_payable) {
		this.tax_payable = tax_payable;
	}
	public double getPrevious_tax_paid() {
		return previous_tax_paid;
	}
	public void setPrevious_tax_paid(double previous_tax_paid) {
		this.previous_tax_paid = previous_tax_paid;
	}
	public double getTax_paid() {
		return tax_paid;
	}
	public void setTax_paid(double tax_paid) {
		this.tax_paid = tax_paid;
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
