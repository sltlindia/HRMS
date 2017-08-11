package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score_area_tbl")
public class ScoreAreaBean implements Serializable{
	

	private int score_area_id;
	private String score_area_name;
	
	 @Id
	 @Column(name="score_area_id")
	 @GeneratedValue
	public int getScore_area_id() {
		return score_area_id;
	}
	public void setScore_area_id(int score_area_id) {
		this.score_area_id = score_area_id;
	}
	
	
	@Column(name="score_area_name")
	public String getScore_area_name() {
		return score_area_name;
	}
	public void setScore_area_name(String score_area_name) {
		this.score_area_name = score_area_name;
	} 
	



}
