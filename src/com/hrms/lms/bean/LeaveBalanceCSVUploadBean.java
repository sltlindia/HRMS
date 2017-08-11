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
public class LeaveBalanceCSVUploadBean {

	private int leave_balance_id;
	private String Plan_leave;
	private String Unplan_leave;
	private String CO;
	private String Leave_without_pay;
	
	private EmployeeBean employeeBean;
	
	

	public LeaveBalanceCSVUploadBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveBalanceCSVUploadBean(String plan_leave, String unplan_leave, String cO, String leave_without_pay,
			EmployeeBean employeeBean) {
		super();
		Plan_leave = plan_leave;
		Unplan_leave = unplan_leave;
		CO = cO;
		Leave_without_pay = leave_without_pay;
		this.employeeBean = employeeBean;
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
	@Column(name="Plan_leave")
	public String getPlan_leave() {
		return Plan_leave;
	}

	public void setPlan_leave(String plan_leave) {
		Plan_leave = plan_leave;
	}
	@Column(name="Unplan_leave")
	public String getUnplan_leave() {
		return Unplan_leave;
	}

	public void setUnplan_leave(String unplan_leave) {
		Unplan_leave = unplan_leave;
	}
	@Column(name="CO")
	public String getCO() {
		return CO;
	}

	public void setCO(String cO) {
		CO = cO;
	}
	@Column(name="Leave_without_pay")
	public String getLeave_without_pay() {
		return Leave_without_pay;
	}

	public void setLeave_without_pay(String leave_without_pay) {
		Leave_without_pay = leave_without_pay;
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
