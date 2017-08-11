package com.hrms.riskmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name = "concern_person_tbl")
public class ConcernPersonBean {

	private int concern_person_id;
	
	
	private EmployeeBean employeeBean;
	private RiskRepositoryBean riskRepositoryBean;

	public ConcernPersonBean() {
	}

	

	public ConcernPersonBean(EmployeeBean employeeBean, RiskRepositoryBean riskRepositoryBean) {
		super();
		this.employeeBean = employeeBean;
		this.riskRepositoryBean = riskRepositoryBean;
	}

	@Id
	@Column(name = "concern_person_id")
	@GeneratedValue
	public int getConcern_person_id() {
		return concern_person_id;
	}

	public void setConcern_person_id(int concern_person_id) {
		this.concern_person_id = concern_person_id;
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
	@JoinColumn(name="risk_repository_id")
	public RiskRepositoryBean getRiskRepositoryBean() {
		return riskRepositoryBean;
	}

	public void setRiskRepositoryBean(RiskRepositoryBean riskRepositoryBean) {
		this.riskRepositoryBean = riskRepositoryBean;
	}

	

}
