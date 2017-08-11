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
@Table(name="leave_hr_tbl")
public class LeaveHRBean implements Serializable
{
	@Id
	@GeneratedValue
	private int Id;
	private int LeaveType;
	private String From_Date;
	private String To_Date;
	private String Approval_Date;
	private int Approval_By;
	private LeaveBean leaveBean;
	private LeaveODBean leaveODBean;
	private LeaveCOBean leaveCOBean;
	private EmployeeBean employeeBean;
	
	public LeaveHRBean()
	{
		
	}
	
	public LeaveHRBean(int LeaveType , EmployeeBean employeeBean, String From_Date, String To_Date, String Approval_Date, int Approval_By , LeaveBean leaveBean)
	{
		this.LeaveType = LeaveType;
		this.employeeBean = employeeBean;
		this.From_Date = From_Date;
		this.To_Date = To_Date;
		this.Approval_Date = Approval_Date;
		this.Approval_By = Approval_By;
		this.leaveBean = leaveBean;
	}

	public LeaveHRBean(int LeaveType , EmployeeBean employeeBean, String OD_From_Date, String OD_To_Date, String Approval_Date, int Approval_By , LeaveODBean leaveODBean)
	{
		this.LeaveType = LeaveType;
		this.employeeBean = employeeBean;
		this.From_Date = OD_From_Date;
		this.To_Date = OD_To_Date;
		this.Approval_Date = Approval_Date;
		this.Approval_By = Approval_By;
		this.leaveODBean = leaveODBean;
	}

	public LeaveHRBean(int LeaveType , EmployeeBean employeeBean, String CO_From_Date,  String CO_To_Date, String Approval_Date, int Approval_By , LeaveCOBean leaveCOBean)
	{
		this.LeaveType = LeaveType;
		this.employeeBean = employeeBean;
		this.From_Date = CO_From_Date;
		this.To_Date = CO_To_Date;
		this.Approval_Date = Approval_Date;
		this.Approval_By = Approval_By;
		this.leaveCOBean = leaveCOBean;
	}
	
	
	@Id 
	@Column(name="Id")
	@GeneratedValue
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getLeaveType() {
		return LeaveType;
	}

	public void setLeaveType(int leaveType) {
		LeaveType = leaveType;
	}

	

	public String getFrom_Date() {
		return From_Date;
	}

	public void setFrom_Date(String from_Date) {
		From_Date = from_Date;
	}

	public String getTo_Date() {
		return To_Date;
	}

	public void setTo_Date(String to_Date) {
		To_Date = to_Date;
	}

	public String getApproval_Date() {
		return Approval_Date;
	}

	public void setApproval_Date(String approval_Date) {
		Approval_Date = approval_Date;
	}

	public int getApproval_By() {
		return Approval_By;
	}

	public void setApproval_By(int approval_By) {
		Approval_By = approval_By;
	}

	@ManyToOne
	@JoinColumn(name="leave_id")
	public LeaveBean getLeaveBean() {
		return leaveBean;
	}

	public void setLeaveBean(LeaveBean leaveBean) {
		this.leaveBean = leaveBean;
	}

	@ManyToOne
	@JoinColumn(name="OD_ID")
	public LeaveODBean getLeaveODBean() {
		return leaveODBean;
	}

	public void setLeaveODBean(LeaveODBean leaveODBean) {
		this.leaveODBean = leaveODBean;
	}

	
	@ManyToOne
	@JoinColumn(name="CO_ID")
	public LeaveCOBean getLeaveCOBean() {
		return leaveCOBean;
	}

	public void setLeaveCOBean(LeaveCOBean leaveCOBean) {
		this.leaveCOBean = leaveCOBean;
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
