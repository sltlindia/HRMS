package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recommendation_options_tbl")
public class RecommendationOptionsBean implements Serializable{
	
	private int recommendation_options_id;
	private String recommendation_options_name;
	
	@Id
	@Column(name="recommendation_options_id")
    @GeneratedValue
	public int getRecommendation_options_id() {
		return recommendation_options_id;
	}
	public void setRecommendation_options_id(int recommendation_options_id) {
		this.recommendation_options_id = recommendation_options_id;
	}
	
	@Column(name="recommendation_options_name")
	public String getRecommendation_options_name() {
		return recommendation_options_name;
	}
	public void setRecommendation_options_name(String recommendation_options_name) {
		this.recommendation_options_name = recommendation_options_name;
	}
	
	

}
