package com.hrms.riskmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "suggestion_tbl")
public class SuggestionBean implements Serializable{
	
	private int suggestion_id;
	private RiskRepositoryBean riskRepositoryBean;
	private String suggestion;
	
	public SuggestionBean() {
	}
	
	
	public SuggestionBean(RiskRepositoryBean riskRepositoryBean, String suggestion) {
		super();
		this.riskRepositoryBean = riskRepositoryBean;
		this.suggestion = suggestion;
	}

	@Id
	@Column(name = "suggestion_id")
	@GeneratedValue
	public int getSuggestion_id() {
		return suggestion_id;
	}
	
	public void setSuggestion_id(int suggestion_id) {
		this.suggestion_id = suggestion_id;
	}
	@Column(name = "suggestion")
	public String getSuggestion() {
		return suggestion;
	}


	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	@ManyToOne
	@JoinColumn(name="risk_repository_id")
	public RiskRepositoryBean getRiskRepositoryBean() {
		return riskRepositoryBean;
	}
	public void setRiskRepositoryBean(RiskRepositoryBean riskRepositoryBean) {
		this.riskRepositoryBean = riskRepositoryBean;
	}
}
