package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vacancy_grade_level_tbl")
public class VacancyGradeLevelBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public VacancyGradeLevelBean(){}
	
	private VacancyLevelBean vacancyLevelBean;
	
	private int vacancy_grade_level_id;
	private String vacancy_grade_name;
	private String vacancy_grade_targeted_days;
	private String vacancy_grade_level_name;

	@ManyToOne
	@JoinColumn(name="vacancy_level_id")
	public VacancyLevelBean getVacancyLevelBean() {
		return vacancyLevelBean;
	}
	
	public void setVacancyLevelBean(VacancyLevelBean vacancyLevelBean) {
		this.vacancyLevelBean = vacancyLevelBean;
	}
	
	@Id
	@GeneratedValue
	@Column(name="vacancy_grade_level_id")
	public int getVacancy_grade_level_id() {
		return vacancy_grade_level_id;
	}
	
	public void setVacancy_grade_level_id(int vacancy_grade_level_id) {
		this.vacancy_grade_level_id = vacancy_grade_level_id;
	}
	
	public String getVacancy_grade_name() {
		return vacancy_grade_name;
	}
	
	public void setVacancy_grade_name(String vacancy_grade_name) {
		this.vacancy_grade_name = vacancy_grade_name;
	}
	
	public String getVacancy_grade_targeted_days() {
		return vacancy_grade_targeted_days;
	}
	
	public void setVacancy_grade_targeted_days(String vacancy_grade_targeted_days) {
		this.vacancy_grade_targeted_days = vacancy_grade_targeted_days;
	}
	
	public String getVacancy_grade_level_name() {
		return vacancy_grade_level_name;
	}

	public void setVacancy_grade_level_name(String vacancy_grade_level_name) {
		this.vacancy_grade_level_name = vacancy_grade_level_name;
	}
	
}
