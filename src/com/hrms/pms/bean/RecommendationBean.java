package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recommendation_tbl")
public class RecommendationBean implements Serializable{
	
	private int recommendation_id;
	private String description;
	
	private EmployeeBean employeeBean;
	private ReviewBean reviewBean;
	private RecommendationOptionsBean recommendationOptionsBean;
	
	
	
	public RecommendationBean() {
		// TODO Auto-generated constructor stub
	}
	
	public RecommendationBean(String description,EmployeeBean employeeBean,ReviewBean reviewBean,RecommendationOptionsBean recommendationOptionsBean) {

		this.description = description;
		this.employeeBean = employeeBean;
		this.reviewBean = reviewBean;
		this.recommendationOptionsBean = recommendationOptionsBean;
		
	}
	
	
	@Id
	@Column(name="recommendation_id")
    @GeneratedValue
	public int getRecommendation_id() {
		return recommendation_id;
	}
	public void setRecommendation_id(int recommendation_id) {
		this.recommendation_id = recommendation_id;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	@ManyToOne
	@JoinColumn(name="review_id")
	public ReviewBean getReviewBean() {
		return reviewBean;
	}
	public void setReviewBean(ReviewBean reviewBean) {
		this.reviewBean = reviewBean;
	}
	
	@ManyToOne
	@JoinColumn(name="recommendation_options_id")
	public RecommendationOptionsBean getRecommendationOptionsBean() {
		return recommendationOptionsBean;
	}
	public void setRecommendationOptionsBean(RecommendationOptionsBean recommendationOptionsBean) {
		this.recommendationOptionsBean = recommendationOptionsBean;
	}
	
	
	
	
}