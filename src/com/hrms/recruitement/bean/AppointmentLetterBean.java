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
import com.hrms.selfservice.bean.RoleCategoryBean;

@Entity
@Table(name = "appointment_letter_tbl")
public class AppointmentLetterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppointmentLetterBean() {

	}

	private RoleBean roleBean;
	private CompanyListBean companyListBean;
	private EmployeeBean employeeBean;

	@Id
	@GeneratedValue
	private int appointment_letter_id;
	private String joining_date;
	private String candidate_name;
	private String address;
	private String ctc;
	private String gross_salary;
	private String notice_period;
	private String submission_date;

	public AppointmentLetterBean(RoleBean roleBean, CompanyListBean companyListBean, EmployeeBean employeeBean,
			String joining_date, String candidate_name, String address, String ctc,
			String gross_salary, String notice_period, String submission_date) {

		this.roleBean = roleBean;
		this.companyListBean = companyListBean;
		this.employeeBean = employeeBean;
		this.joining_date = joining_date;
		this.candidate_name = candidate_name;
		this.address = address;
		this.ctc = ctc;
		this.gross_salary = gross_salary;
		this.notice_period = notice_period;
		this.submission_date = submission_date;
	}

	@ManyToOne
	@JoinColumn(name = "role_id")
	public RoleBean getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	@ManyToOne
	@JoinColumn(name = "company_list_id")
	public CompanyListBean getCompanyListBean() {
		return companyListBean;
	}

	public void setCompanyListBean(CompanyListBean companyListBean) {
		this.companyListBean = companyListBean;
	}

	@Id
	@GeneratedValue
	@Column(name = "appointment_letter_id")
	public int getAppointment_letter_id() {
		return appointment_letter_id;
	}

	public void setAppointment_letter_id(int appointment_letter_id) {
		this.appointment_letter_id = appointment_letter_id;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCandidate_name() {
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	public String getGross_salary() {
		return gross_salary;
	}

	public void setGross_salary(String gross_salary) {
		this.gross_salary = gross_salary;
	}

	public String getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}


}
