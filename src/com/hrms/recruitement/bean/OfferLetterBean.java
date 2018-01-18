package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.RoleBean;

@Entity
@Table(name="offer_letter_tbl")
public class OfferLetterBean {

	@Id
	@GeneratedValue
	private int offer_letter_id;
	private String joining_date;
	private String submission_date;
	
	private JobLocationBean jobLocationBean;
	private RoleBean roleBean;
	private CompanyListBean companyListBean;
	private ResumeDataBean resumeDataBean;
	private FinalSelectionBean finalSelectionBean;
	
	public OfferLetterBean() {
	}

	
	
	
	@Id
	@GeneratedValue
	@Column(name="offer_letter_id")
	public int getOffer_letter_id() {
		return offer_letter_id;
	}

	public void setOffer_letter_id(int offer_letter_id) {
		this.offer_letter_id = offer_letter_id;
	}





	public OfferLetterBean(String joining_date, String submission_date, JobLocationBean jobLocationBean,
			RoleBean roleBean, CompanyListBean companyListBean, ResumeDataBean resumeDataBean, FinalSelectionBean finalSelectionBean) {
		super();
		this.joining_date = joining_date;
		this.submission_date = submission_date;
		this.jobLocationBean = jobLocationBean;
		this.roleBean = roleBean;
		this.companyListBean = companyListBean;
		this.resumeDataBean = resumeDataBean;
		this.finalSelectionBean = finalSelectionBean;
	}





	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	@ManyToOne
	@JoinColumn(name="job_location_id")
	public JobLocationBean getJobLocationBean() {
		return jobLocationBean;
	}

	public void setJobLocationBean(JobLocationBean jobLocationBean) {
		this.jobLocationBean = jobLocationBean;
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

	@ManyToOne
	@JoinColumn(name="resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}

	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}



	@ManyToOne
	@JoinColumn(name="final_selection_id")
	public FinalSelectionBean getFinalSelectionBean() {
		return finalSelectionBean;
	}




	public void setFinalSelectionBean(FinalSelectionBean finalSelectionBean) {
		this.finalSelectionBean = finalSelectionBean;
	}

	
	
	
	
	
}
