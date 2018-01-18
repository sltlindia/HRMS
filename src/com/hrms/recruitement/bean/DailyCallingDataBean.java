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

@Entity
@Table(name="daily_calling_data_tbl")
public class DailyCallingDataBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int daily_calling_data_id;
	private String submission_date;
	//private String position;
	//private String department;
	private String candidate_name;
	private String gender;
	private String current_location;
	private String mobile_number;
	private String email_id;
	private String current_designation;
	private String total_experience;
	private String highest_qualification;
	private String current_CTC;
	private String expected_CTC;
	private String notice_period;
	private String status;
	private String remarks;
	//private String source_of_recuriment;
	private String offered_gross;
	private String offered_CTC;
	private String joining_date;
	private String upload_resume;
	private DepartmentBean departmentBean;
	private VacancyFormBean vacancyFormBean;
	private SourceOfResumeBean sourceOfResumeBean;
	private EmployeeBean employeeBean;
	
	public DailyCallingDataBean() {}
	
	public DailyCallingDataBean(String upload_resume , String submission_date, String candidate_name, String gender, String current_location,
			String mobile_number, String email_id, String current_designation, String total_experience,
			String highest_qualification, String current_CTC, String expected_CTC, String notice_period, String status,
			String remarks, String offered_gross, String offered_CTC, String joining_date,
			DepartmentBean departmentBean, VacancyFormBean vacancyFormBean, SourceOfResumeBean sourceOfResumeBean, EmployeeBean employeeBean) {
		super();
		this.submission_date = submission_date;
		this.candidate_name = candidate_name;
		this.gender = gender;
		this.current_location = current_location;
		this.mobile_number = mobile_number;
		this.email_id = email_id;
		this.current_designation = current_designation;
		this.total_experience = total_experience;
		this.highest_qualification = highest_qualification;
		this.current_CTC = current_CTC;
		this.expected_CTC = expected_CTC;
		this.notice_period = notice_period;
		this.status = status;
		this.remarks = remarks;
		this.offered_gross = offered_gross;
		this.offered_CTC = offered_CTC;
		this.joining_date = joining_date;
		this.departmentBean = departmentBean;
		this.vacancyFormBean = vacancyFormBean;
		this.sourceOfResumeBean = sourceOfResumeBean;
		this.employeeBean = employeeBean;
		this.upload_resume = upload_resume;
	}



	@Id
	@Column(name="daily_calling_data_id")
	@GeneratedValue
	public int getDaily_calling_data_id() {
		return daily_calling_data_id;
	}
	public void setDaily_calling_data_id(int daily_calling_data_id) {
		this.daily_calling_data_id = daily_calling_data_id;
	}
	public String getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	public String getCandidate_name() {
		return candidate_name;
	}
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}
	
	
	
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrent_location() {
		return current_location;
	}
	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getCurrent_designation() {
		return current_designation;
	}
	public void setCurrent_designation(String current_designation) {
		this.current_designation = current_designation;
	}
	public String getTotal_experience() {
		return total_experience;
	}
	public void setTotal_experience(String total_experience) {
		this.total_experience = total_experience;
	}
	public String getHighest_qualification() {
		return highest_qualification;
	}
	public void setHighest_qualification(String highest_qualification) {
		this.highest_qualification = highest_qualification;
	}
	public String getCurrent_CTC() {
		return current_CTC;
	}
	public void setCurrent_CTC(String current_CTC) {
		this.current_CTC = current_CTC;
	}
	public String getExpected_CTC() {
		return expected_CTC;
	}
	public void setExpected_CTC(String expected_CTC) {
		this.expected_CTC = expected_CTC;
	}
	public String getNotice_period() {
		return notice_period;
	}
	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getOffered_gross() {
		return offered_gross;
	}
	public void setOffered_gross(String offered_gross) {
		this.offered_gross = offered_gross;
	}
	public String getOffered_CTC() {
		return offered_CTC;
	}
	public void setOffered_CTC(String offered_CTC) {
		this.offered_CTC = offered_CTC;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}
	
	@ManyToOne
	@JoinColumn(name = "vacancy_id")
	public VacancyFormBean getVacancyFormBean() {
		return vacancyFormBean;
	}
	public void setVacancyFormBean(VacancyFormBean vacancyFormBean) {
		this.vacancyFormBean = vacancyFormBean;
	}
	
	@ManyToOne
	@JoinColumn(name = "source_of_resume_id")
	public SourceOfResumeBean getSourceOfResumeBean() {
		return sourceOfResumeBean;
	}
	public void setSourceOfResumeBean(SourceOfResumeBean sourceOfResumeBean) {
		this.sourceOfResumeBean = sourceOfResumeBean;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getUpload_resume() {
		return upload_resume;
	}

	public void setUpload_resume(String upload_resume) {
		this.upload_resume = upload_resume;
	}
	
	
	
	
}
