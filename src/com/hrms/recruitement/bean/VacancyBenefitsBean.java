package com.hrms.recruitement.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="vacancy_benefit_tbl")
public class VacancyBenefitsBean implements Serializable{
	
	
	
	private int vacancy_benefit_id;
	private VacancyFormBean vacancyFormBean;
	private BenefitsBean benefitsBean;
	
	
	public VacancyBenefitsBean()
	{
		
	}
	
	public VacancyBenefitsBean(VacancyFormBean vacancyFormBean, BenefitsBean benefitsBean){
		this.vacancyFormBean = vacancyFormBean;
		this.benefitsBean = benefitsBean;
	}
	
	@Id
	@Column(name = "vacancy_benefit_id")
	@GeneratedValue
	public int getVacancy_benefit_id() {
		return vacancy_benefit_id;
	}
	public void setVacancy_benefit_id(int vacancy_benefit_id) {
		this.vacancy_benefit_id = vacancy_benefit_id;
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
	@JoinColumn(name="benefit_id")
	public BenefitsBean getBenefitsBean() {
		return benefitsBean;
	}

	public void setBenefitsBean(BenefitsBean benefitsBean) {
		this.benefitsBean = benefitsBean;
	}
	

}
