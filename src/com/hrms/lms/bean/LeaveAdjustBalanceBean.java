package com.hrms.lms.bean;

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
@Table(name="leave_adjustbalance_tbl")
public class LeaveAdjustBalanceBean implements Serializable 
{
	@Id
	@GeneratedValue
	private int adjustbalance_ID;
	private EmployeeBean employeeBean;
	private double add_CO;
	private double sub_CO;
	private double add_PL;
	private double sub_PL;
	private double add_SL;
	private double sub_SL;
	private double add_LWP;
	private double sub_LWP;
	private String leave_update_date;
	private String leave_update_name;
	private String CO_Reason;
	private String Plan_Reason;
	private String Unplan_Reason;
	private String LWP_Reason;
	
	
	
	public LeaveAdjustBalanceBean()
	{
		
	}
	
	
	public LeaveAdjustBalanceBean(EmployeeBean employeeBean, double add_CO, double sub_CO, String leave_update_date, String leave_update_name, String CO_Reason)
			
	{
		this.employeeBean = employeeBean;
		this.add_CO = add_CO;
		this.sub_CO = sub_CO;
		this.leave_update_date = leave_update_date;
		this.leave_update_name = leave_update_name;
		this.CO_Reason = CO_Reason;
	}
	
	public LeaveAdjustBalanceBean(EmployeeBean employeeBean, String leave_update_date, String leave_update_name, double add_PL , double sub_PL , String Plan_Reason)	
	{
		this.employeeBean = employeeBean;
		this.add_PL = add_PL;
		this.sub_PL = sub_PL;
		this.leave_update_date = leave_update_date;
		this.leave_update_name = leave_update_name;
		this.Plan_Reason = Plan_Reason;
	}
	
	public LeaveAdjustBalanceBean(EmployeeBean employeeBean, String leave_update_date, double add_SL , double sub_SL , String leave_update_name,  String Unplan_Reason)
	{
		this.employeeBean = employeeBean;
		this.add_SL = add_SL;
		this.sub_SL = sub_SL;
		this.leave_update_date = leave_update_date;
		this.leave_update_name = leave_update_name;
		this.Unplan_Reason = Unplan_Reason;
	}
	
	public LeaveAdjustBalanceBean(EmployeeBean employeeBean, String leave_update_date, String leave_update_name,  String LWP_Reason, double add_LWP , double sub_LWP)
	{
		this.employeeBean = employeeBean;
		this.add_LWP = add_LWP;
		this.sub_LWP = sub_LWP;
		this.leave_update_date = leave_update_date;
		this.leave_update_name = leave_update_name;
		this.LWP_Reason = LWP_Reason;
	}
	
	
	
	 @Id 
	 @Column(name="adjustbalance_ID")
	 @GeneratedValue
	public int getAdjustbalance_ID() {
		return adjustbalance_ID;
	}
	public void setAdjustbalance_ID(int adjustbalance_ID) {
		this.adjustbalance_ID = adjustbalance_ID;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}


	public double getAdd_CO() {
		return add_CO;
	}


	public void setAdd_CO(double add_CO) {
		this.add_CO = add_CO;
	}


	public double getSub_CO() {
		return sub_CO;
	}


	public void setSub_CO(double sub_CO) {
		this.sub_CO = sub_CO;
	}


	public double getAdd_PL() {
		return add_PL;
	}


	public void setAdd_PL(double add_PL) {
		this.add_PL = add_PL;
	}


	public double getSub_PL() {
		return sub_PL;
	}


	public void setSub_PL(double sub_PL) {
		this.sub_PL = sub_PL;
	}


	public double getAdd_SL() {
		return add_SL;
	}


	public void setAdd_SL(double add_SL) {
		this.add_SL = add_SL;
	}


	public double getSub_SL() {
		return sub_SL;
	}


	public void setSub_SL(double sub_SL) {
		this.sub_SL = sub_SL;
	}


	public double getAdd_LWP() {
		return add_LWP;
	}


	public void setAdd_LWP(double add_LWP) {
		this.add_LWP = add_LWP;
	}


	public double getSub_LWP() {
		return sub_LWP;
	}


	public void setSub_LWP(double sub_LWP) {
		this.sub_LWP = sub_LWP;
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
