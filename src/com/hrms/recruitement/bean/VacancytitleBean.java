package com.hrms.recruitement.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vacancy_title_tbl")
public class VacancytitleBean 
{
	
	private int vacancy_title_id;
	private String vacancy_title;
	private String vacancy_grades;
	
	
	public VacancytitleBean()
	{
		
	}
	
	
	
	@Id
	@GeneratedValue
	public int getVacancy_title_id() {
		return vacancy_title_id;
	}
	public void setVacancy_title_id(int vacancy_title_id) {
		this.vacancy_title_id = vacancy_title_id;
	}
	public String getVacancy_title() {
		return vacancy_title;
	}
	public void setVacancy_title(String vacancy_title) {
		this.vacancy_title = vacancy_title;
	}
	public String getVacancy_grades() {
		return vacancy_grades;
	}
	public void setVacancy_grades(String vacancy_grades) {
		this.vacancy_grades = vacancy_grades;
	}
	
	
	
	
	
}
