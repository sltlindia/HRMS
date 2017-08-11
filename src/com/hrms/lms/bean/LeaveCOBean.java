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
@Table(name="leave_co_tbl")
public class LeaveCOBean
{
	@Id
	@GeneratedValue
	private int CO_ID;
	private EmployeeBean employeeBean;
	private String decripction;
	private String CO_date;
	private String Start_time;
	private String End_time;
	private double Total_Hours;
	private int under_manager_id; 
	private String status;
	private String reason;
	private String sundayholiday;
	private int mail_view;
	
	
	public LeaveCOBean()
	{
		
	}

	
	public LeaveCOBean(EmployeeBean employeeBean , String decripction, String CO_date , String Start_time , String End_time , double Total_Hours , int under_manager_id , String status , String sundayholiday,int mail_view)
	{
		this.employeeBean = employeeBean;
		this.decripction = decripction;
		this.CO_date = CO_date;
		this.Start_time = Start_time;
		this.End_time = End_time;
		this.Total_Hours = Total_Hours;
		this.under_manager_id = under_manager_id;
		this.status = status;
		this.sundayholiday = sundayholiday;
		this.mail_view = mail_view;
	}
	
	
	 @Id 
	 @Column(name="CO_ID")
	 @GeneratedValue
	public int getCO_ID() {
		return CO_ID;
	}


	public void setCO_ID(int cO_ID) {
		CO_ID = cO_ID;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	
	public String getDecripction() {
		return decripction;
	}


	public void setDecripction(String decripction) {
		this.decripction = decripction;
	}


	public String getCO_date() {
		return CO_date;
	}


	public void setCO_date(String cO_date) {
		CO_date = cO_date;
	}


	public String getStart_time() {
		return Start_time;
	}


	public void setStart_time(String start_time) {
		Start_time = start_time;
	}


	public String getEnd_time() {
		return End_time;
	}


	public void setEnd_time(String end_time) {
		End_time = end_time;
	}


	

	public double getTotal_Hours() {
		return Total_Hours;
	}


	public void setTotal_Hours(double total_Hours) {
		Total_Hours = total_Hours;
	}


	public int getUnder_manager_id() {
		return under_manager_id;
	}


	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getSundayholiday() {
		return sundayholiday;
	}


	public void setSundayholiday(String sundayholiday) {
		this.sundayholiday = sundayholiday;
	}


	public int getMail_view() {
		return mail_view;
	}


	public void setMail_view(int mail_view) {
		this.mail_view = mail_view;
	}
	
	
	
}
