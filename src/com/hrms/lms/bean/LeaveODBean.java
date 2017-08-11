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
@Table(name="leave_od_tbl")
public class LeaveODBean 
{
	@Id
	@GeneratedValue
	private int OD_ID;
	private EmployeeBean employeeBean;
	private String OD_StartDate;
	private String OD_EndDate;
	private String OD_StartTime;
	private String OD_EndTime;
	private int OD_TotalDay;
	private int under_manager_id;
	private String Status;
	private String reason;
	private String description;
	private int mail_view;
	private int sundayCOadd;
	private int holidayCOadd;
	private String coDates;

	public LeaveODBean()
	{
		
	}

	
	public LeaveODBean(EmployeeBean employeeBean , String OD_StartDate , String OD_EndDate , String OD_StartTime , String OD_EndTime , int OD_TotalDay ,
			int under_manager_id , String Status,String description , int sundayCOadd , int holidayCOadd , String coDates)
	{
		this.employeeBean = employeeBean;
		this.OD_StartDate = OD_StartDate;
		this.OD_EndDate = OD_EndDate;
		this.OD_StartTime = OD_StartTime;
		this.OD_EndTime =  OD_EndTime;
		this.OD_TotalDay = OD_TotalDay;
		this.under_manager_id = under_manager_id;
		this.Status = Status;
		this.description = description;
		this.sundayCOadd = sundayCOadd;
		this.holidayCOadd = holidayCOadd;
		this.coDates = coDates;
	}
	
	
	
	@Id 
	@Column(name="OD_ID")
	@GeneratedValue
	public int getOD_ID() {
		return OD_ID;
	}

	public void setOD_ID(int oD_ID) {
		OD_ID = oD_ID;
	}

	
	public String getOD_StartDate() {
		return OD_StartDate;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}


	public void setOD_StartDate(String oD_StartDate) {
		OD_StartDate = oD_StartDate;
	}

	public String getOD_EndDate() {
		return OD_EndDate;
	}

	public void setOD_EndDate(String oD_EndDate) {
		OD_EndDate = oD_EndDate;
	}

	public String getOD_StartTime() {
		return OD_StartTime;
	}

	public void setOD_StartTime(String oD_StartTime) {
		OD_StartTime = oD_StartTime;
	}

	public String getOD_EndTime() {
		return OD_EndTime;
	}

	public void setOD_EndTime(String oD_EndTime) {
		OD_EndTime = oD_EndTime;
	}

	public int getOD_TotalDay() {
		return OD_TotalDay;
	}

	public void setOD_TotalDay(int oD_TotalDay) {
		OD_TotalDay = oD_TotalDay;
	}
	

	public int getUnder_manager_id() {
		return under_manager_id;
	}


	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}


	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getMail_view() {
		return mail_view;
	}


	public void setMail_view(int mail_view) {
		this.mail_view = mail_view;
	}


	public int getSundayCOadd() {
		return sundayCOadd;
	}


	public void setSundayCOadd(int sundayCOadd) {
		this.sundayCOadd = sundayCOadd;
	}


	public int getHolidayCOadd() {
		return holidayCOadd;
	}


	public void setHolidayCOadd(int holidayCOadd) {
		this.holidayCOadd = holidayCOadd;
	}


	public String getCoDates() {
		return coDates;
	}


	public void setCoDates(String coDates) {
		this.coDates = coDates;
	}

	
	
}
