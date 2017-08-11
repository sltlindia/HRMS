package com.hrms.recruitement.bean;

import java.io.Serializable;

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
@Table(name="appointment_letter_tbl")
public class AppointmentLetterBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AppointmentLetterBean() {

	}
	
	private RoleBean roleBean;
	private CompanyListBean companyListBean;
	private DepartmentBean departmentBean;
	private EmployeeBean employeeBean;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}

	@Id
	@GeneratedValue
	private String appointment_letter_id;
	private String joining_date;
	private String company_code;
	private String serial_no;
	private String candidate_name;
	private String address;
	private String basic_salary;
	private String gross_salary;
	private String conveyance_allowance;
	private String medical_allowance;
	private String lta;
	private String other_allowance;
	private String notice_period;
	private String submission_date;
	
	
	public AppointmentLetterBean(RoleBean roleBean, CompanyListBean companyListBean, String joining_date,
			String company_code,String candidate_name, String address, String basic_salary, 
			String gross_salary,
			String conveyance_allowance, String medical_allowance, String lta, String other_allowance,
			String notice_period, String submission_date,DepartmentBean departmentBean, EmployeeBean employeeBean) {
		
		this.roleBean = roleBean;
		this.companyListBean = companyListBean;
		
		this.joining_date = joining_date;
		this.company_code = company_code;
		this.candidate_name = candidate_name;
		this.address = address;
		this.basic_salary = basic_salary;
		this.gross_salary = gross_salary;
		this.conveyance_allowance = conveyance_allowance;
		this.medical_allowance = medical_allowance;
		this.lta = lta;
		this.other_allowance = other_allowance;
		this.notice_period = notice_period;
		this.submission_date = submission_date;
		this.departmentBean = departmentBean;
		this.employeeBean = employeeBean;
		
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
	@JoinColumn(name="company_list_id")
	public CompanyListBean getCompanyListBean() {
		return companyListBean;
	}
	public void setCompanyListBean(CompanyListBean companyListBean) {
		this.companyListBean = companyListBean;
	}
	
	@Id
	@GeneratedValue
	public String getAppointment_letter_id() {
		return appointment_letter_id;
	}
	public void setAppointment_letter_id(String appointment_letter_id) {
		this.appointment_letter_id = appointment_letter_id;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBasic_salary() {
		return basic_salary;
	}
	public void setBasic_salary(String basic_salary) {
		this.basic_salary = basic_salary;
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
	public String getConveyance_allowance() {
		return conveyance_allowance;
	}
	public void setConveyance_allowance(String conveyance_allowance) {
		this.conveyance_allowance = conveyance_allowance;
	}
	public String getMedical_allowance() {
		return medical_allowance;
	}
	public void setMedical_allowance(String medical_allowance) {
		this.medical_allowance = medical_allowance;
	}
	public String getLta() {
		return lta;
	}
	public void setLta(String lta) {
		this.lta = lta;
	}
	public String getOther_allowance() {
		return other_allowance;
	}
	public void setOther_allowance(String other_allowance) {
		this.other_allowance = other_allowance;
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
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	
	

}
