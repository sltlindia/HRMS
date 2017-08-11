package com.hrms.recruitement.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="vacancy_level_tbl")
public class VacancyLevelBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
		private int vacancy_level_id;
		private String vacancy_level_sf;
		private String vacancy_level_name;
		
		
		public VacancyLevelBean() {

		}

		@Id
		@GeneratedValue
		@Column(name="vacancy_level_id")
		public int getVacancy_level_id() {
			return vacancy_level_id;
		}

		public void setVacancy_level_id(int vacancy_level_id) {
			this.vacancy_level_id = vacancy_level_id;
		}

		public String getVacancy_level_sf() {
			return vacancy_level_sf;
		}

		public void setVacancy_level_sf(String vacancy_level_sf) {
			this.vacancy_level_sf = vacancy_level_sf;
		}

		public String getVacancy_level_name() {
			return vacancy_level_name;
		}

		public void setVacancy_level_name(String vacancy_level_name) {
			this.vacancy_level_name = vacancy_level_name;
		}

		

		
		
}
