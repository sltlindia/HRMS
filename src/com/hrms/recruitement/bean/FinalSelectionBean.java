package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;

@Entity
@Table(name="final_selection_tbl")
public class FinalSelectionBean implements Serializable{
	
	public FinalSelectionBean(){}
	
	private int final_selection_id;
	private String decision;
	private String reject_reason;
	private String joining_in_days;
	private double salary;
	private String probation_period;
	private String procced_for_next;
	
	private RoleBean roleBean;
	private DepartmentBean departmentBean;
	private EmployeeBean employeeBean;
	private ResumeDataBean resumeDataBean;
	private JobLocationBean jobLocationBean;
	
	

	public FinalSelectionBean(String decision, String reject_reason, String joining_in_days, double salary,
			String probation_period, String procced_for_next, RoleBean roleBean, DepartmentBean departmentBean,
			EmployeeBean employeeBean, ResumeDataBean resumeDataBean, JobLocationBean jobLocationBean) {

		this.decision = decision;
		this.reject_reason = reject_reason;
		this.joining_in_days = joining_in_days;
		this.salary = salary;
		this.probation_period = probation_period;
		this.procced_for_next = procced_for_next;
		this.roleBean = roleBean;
		this.departmentBean = departmentBean;
		this.employeeBean = employeeBean;
		this.resumeDataBean = resumeDataBean;
		this.jobLocationBean = jobLocationBean;
	}
	
	@Id
	@GeneratedValue
	@Column(name="final_selection_id")
	public int getFinal_selection_id() {
		return final_selection_id;
	}
	public void setFinal_selection_id(int final_selection_id) {
		this.final_selection_id = final_selection_id;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getReject_reason() {
		return reject_reason;
	}
	public void setReject_reason(String reject_reason) {
		this.reject_reason = reject_reason;
	}
	public String getJoining_in_days() {
		return joining_in_days;
	}
	public void setJoining_in_days(String joining_in_days) {
		this.joining_in_days = joining_in_days;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getProbation_period() {
		return probation_period;
	}
	public void setProbation_period(String probation_period) {
		this.probation_period = probation_period;
	}
	public String getProcced_for_next() {
		return procced_for_next;
	}
	public void setProcced_for_next(String procced_for_next) {
		this.procced_for_next = procced_for_next;
	}
	
	@ManyToOne
	@JoinColumn(name="role_id")
	public RoleBean getRoleBean() {
		return roleBean;
	}
	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}
	
	@ManyToOne
	@JoinColumn(name="department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	@ManyToOne
	@JoinColumn(name="resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}
	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}
	
	@ManyToOne
	@JoinColumn(name="job_location_id")
	public JobLocationBean getJobLocationBean() {
		return jobLocationBean;
	}

	public void setJobLocationBean(JobLocationBean jobLocationBean) {
		this.jobLocationBean = jobLocationBean;
	}
	
	

}
