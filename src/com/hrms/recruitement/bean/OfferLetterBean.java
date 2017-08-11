package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.VacancyFormBean;

@Entity
@Table(name="offer_letter_tbl")
public class OfferLetterBean {

	@Id
	@GeneratedValue
	private int offer_letter_id;
	private String gross_salary;
	private String joining_date;
	private String probation_period;
	private String submission_date;
	
	private JobLocationBean jobLocationBean;
	private InterviewFeedbackBean interviewFeedbackBean;
	private VacancyFormBean vacancyFormBean;
	private RoleBean roleBean;
	private CompanyListBean companyListBean;
	private DepartmentBean departmentBean;
	
	public OfferLetterBean() {
	}

	
	
	public OfferLetterBean(String gross_salary, String joining_date, String probation_period,
			JobLocationBean jobLocationBean, InterviewFeedbackBean interviewFeedbackBean,
			VacancyFormBean vacancyFormBean, RoleBean roleBean, CompanyListBean companyListBean,String submission_date,DepartmentBean departmentBean) {
		super();
		this.gross_salary = gross_salary;
		this.joining_date = joining_date;
		this.probation_period = probation_period;
		this.jobLocationBean = jobLocationBean;
		this.interviewFeedbackBean = interviewFeedbackBean;
		this.vacancyFormBean = vacancyFormBean;
		this.roleBean = roleBean;
		this.companyListBean = companyListBean;
		this.submission_date = submission_date;
		this.departmentBean = departmentBean;
	}



	@Id
	@Column(name = "offer_letter_id")
	@GeneratedValue
	public int getOffer_letter_id() {
		return offer_letter_id;
	}

	public void setOffer_letter_id(int offer_letter_id) {
		this.offer_letter_id = offer_letter_id;
	}

	public String getGross_salary() {
		return gross_salary;
	}

	public void setGross_salary(String gross_salary) {
		this.gross_salary = gross_salary;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getProbation_period() {
		return probation_period;
	}

	public void setProbation_period(String probation_period) {
		this.probation_period = probation_period;
	}

	@ManyToOne
	@JoinColumn(name = "job_location_id")
	public JobLocationBean getJobLocationBean() {
		return jobLocationBean;
	}

	public void setJobLocationBean(JobLocationBean jobLocationBean) {
		this.jobLocationBean = jobLocationBean;
	}

	
	@ManyToOne
	@JoinColumn(name = "company_list_id")
	public CompanyListBean getCompanyListBean() {
		return companyListBean;
	}



	public void setCompanyListBean(CompanyListBean companyListBean) {
		this.companyListBean = companyListBean;
	}



	@ManyToOne
	@JoinColumn(name = "interview_feedback_id")
	public InterviewFeedbackBean getInterviewFeedbackBean() {
		return interviewFeedbackBean;
	}

	public void setInterviewFeedbackBean(InterviewFeedbackBean interviewFeedbackBean) {
		this.interviewFeedbackBean = interviewFeedbackBean;
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
	@JoinColumn(name = "role_id")
	public RoleBean getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	

	@ManyToOne
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}



	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}



	public String getSubmission_date() {
		return submission_date;
	}



	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	
	
	
}
