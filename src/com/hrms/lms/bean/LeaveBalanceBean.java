package com.hrms.lms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.hrms.pms.bean.EmployeeBean;


@Entity
@Table(name="leave_balance_tbl")
public class LeaveBalanceBean
{
	
	private int leave_balance_id;
	private EmployeeBean employeeBean;
	private double Leave_without_pay;
	private double CO;
	private double Plan_Leave;
	private double Unplan_Leave;
	private String leave_update_date;
	private String leave_update_name;
	private String CO_Reason;
	private String Plan_Reason;
	private String Unplan_Reason;
	private String LWP_Reason;
	
	public LeaveBalanceBean()
	{
		
	}

	@Id 
    @Column(name="leave_balance_id")
    @GeneratedValue
	public int getLeave_balance_id() {
		return leave_balance_id;
	}

	public void setLeave_balance_id(int leave_balance_id) {
		this.leave_balance_id = leave_balance_id;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public double getCO() {
		return CO;
	}

	public void setCO(double cO) {
		CO = cO;
	}
	
	public double getPlan_Leave() {
		return Plan_Leave;
	}

	public void setPlan_Leave(double plan_Leave) {
		Plan_Leave = plan_Leave;
	}

	public double getUnplan_Leave() {
		return Unplan_Leave;
	}

	public void setUnplan_Leave(double unplan_Leave) {
		Unplan_Leave = unplan_Leave;
	}

	public String getLeave_update_date() {
		return leave_update_date;
	}

	public void setLeave_update_date(String leave_update_date) {
		this.leave_update_date = leave_update_date;
	}

	public String getLeave_update_name() {
		return leave_update_name;
	}

	public void setLeave_update_name(String leave_update_name) {
		this.leave_update_name = leave_update_name;
	}

	public double getLeave_without_pay() {
		return Leave_without_pay;
	}

	public void setLeave_without_pay(double leave_without_pay) {
		Leave_without_pay = leave_without_pay;
	}

	public String getCO_Reason() {
		return CO_Reason;
	}

	public void setCO_Reason(String cO_Reason) {
		CO_Reason = cO_Reason;
	}

	public String getPlan_Reason() {
		return Plan_Reason;
	}

	public void setPlan_Reason(String plan_Reason) {
		Plan_Reason = plan_Reason;
	}

	public String getUnplan_Reason() {
		return Unplan_Reason;
	}

	public void setUnplan_Reason(String unplan_Reason) {
		Unplan_Reason = unplan_Reason;
	}

	public String getLWP_Reason() {
		return LWP_Reason;
	}

	public void setLWP_Reason(String lWP_Reason) {
		LWP_Reason = lWP_Reason;
	}

	
	
}
