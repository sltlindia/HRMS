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
@Table(name="tds_hr_totala_tbl")
public class TDSHrTotalABean implements Serializable{

	private int tds_hr_totala_id;
	private double annual_gross_salary;
	private double bonus;
	private double leaveCount;
	private double incentive;
	private double previous_employeed_salary;
	private double performance_pay;
	private double full_final_leave;
	private double full_final_bonus;
	private double total_a;
	private TDSHrBean tdsHrBean;
	
	public TDSHrTotalABean() {}
	
	
	public TDSHrTotalABean(double annual_gross_salary, double bonus, double leaveCount, double incentive,
			double previous_employeed_salary, double performance_pay, double full_final_leave, double full_final_bonus,
			double total_a, TDSHrBean tdsHrBean) {
		this.annual_gross_salary = annual_gross_salary;
		this.bonus = bonus;
		this.leaveCount = leaveCount;
		this.incentive = incentive;
		this.previous_employeed_salary = previous_employeed_salary;
		this.performance_pay = performance_pay;
		this.full_final_leave = full_final_leave;
		this.full_final_bonus = full_final_bonus;
		this.total_a = total_a;
		this.tdsHrBean = tdsHrBean;
	}

	
	

	public TDSHrTotalABean(int tds_hr_totala_id, double annual_gross_salary, double bonus, double leaveCount,
			double incentive, double previous_employeed_salary, double performance_pay, double full_final_leave,
			double full_final_bonus, double total_a, TDSHrBean tdsHrBean) {
		super();
		this.tds_hr_totala_id = tds_hr_totala_id;
		this.annual_gross_salary = annual_gross_salary;
		this.bonus = bonus;
		this.leaveCount = leaveCount;
		this.incentive = incentive;
		this.previous_employeed_salary = previous_employeed_salary;
		this.performance_pay = performance_pay;
		this.full_final_leave = full_final_leave;
		this.full_final_bonus = full_final_bonus;
		this.total_a = total_a;
		this.tdsHrBean = tdsHrBean;
	}


	@Id
	@Column(name="tds_hr_totala_id")
	@GeneratedValue
	public int getTds_hr_totala_id() {
		return tds_hr_totala_id;
	}
	public void setTds_hr_totala_id(int tds_hr_totala_id) {
		this.tds_hr_totala_id = tds_hr_totala_id;
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
	
	@ManyToOne
	@JoinColumn(name="tds_hr_id")
	public TDSHrBean getTdsHrBean() {
		return tdsHrBean;
	}
	public void setTdsHrBean(TDSHrBean tdsHrBean) {
		this.tdsHrBean = tdsHrBean;
	}
	
	
}
