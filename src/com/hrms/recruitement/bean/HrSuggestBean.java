package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hr_suggest_tbl")
public class HrSuggestBean implements Serializable{

	public HrSuggestBean(){} 
	
	int hr_suggest_id;
	private ResumeDataBean resumeDataBean;
	private VacancyFormBean vacancyFormBean;
	
	@Id
	@GeneratedValue
	public int getHr_suggest_id() {
		return hr_suggest_id;
	}
	public void setHr_suggest_id(int hr_suggest_id) {
		this.hr_suggest_id = hr_suggest_id;
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
	@JoinColumn(name="vacancy_id")
	public VacancyFormBean getVacancyFormBean() {
		return vacancyFormBean;
	}
	public void setVacancyFormBean(VacancyFormBean vacancyFormBean) {
		this.vacancyFormBean = vacancyFormBean;
	}
	
	
	public HrSuggestBean(ResumeDataBean resumeDataBean, VacancyFormBean vacancyFormBean) {

		this.resumeDataBean = resumeDataBean;
		this.vacancyFormBean = vacancyFormBean;
	}
	
	
	
	
	
}
