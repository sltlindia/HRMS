package com.hrms.riskmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stak_holders_details_tbl")
public class StakHoldersDetailsBean {

	private int stak_holders_id;
	private String stak_holders_name;
	private String stak_holders_contact_no;
	private String stak_holders_email_id;
	private RiskRepositoryBean riskRepositoryBean;

	public StakHoldersDetailsBean() {
	}

	public StakHoldersDetailsBean(String stak_holders_name, String stak_holders_contact_no,
			String stak_holders_email_id,RiskRepositoryBean riskRepositoryBean) {
		
		this.stak_holders_name = stak_holders_name;
		this.stak_holders_contact_no = stak_holders_contact_no;
		this.stak_holders_email_id = stak_holders_email_id;
		this.riskRepositoryBean = riskRepositoryBean;
	}

	@Id
	@Column(name = "stak_holders_id")
	@GeneratedValue
	public int getStak_holders_id() {
		return stak_holders_id;
	}

	public void setStak_holders_id(int stak_holders_id) {
		this.stak_holders_id = stak_holders_id;
	}

	@Column(name = "stak_holders_name")
	public String getStak_holders_name() {
		return stak_holders_name;
	}

	public void setStak_holders_name(String stak_holders_name) {
		this.stak_holders_name = stak_holders_name;
	}

	@Column(name = "stak_holders_contact_no")
	public String getStak_holders_contact_no() {
		return stak_holders_contact_no;
	}

	public void setStak_holders_contact_no(String stak_holders_contact_no) {
		this.stak_holders_contact_no = stak_holders_contact_no;
	}
	
	@Column(name = "stak_holders_email_id")
	public String getStak_holders_email_id() {
		return stak_holders_email_id;
	}

	public void setStak_holders_email_id(String stak_holders_email_id) {
		this.stak_holders_email_id = stak_holders_email_id;
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
