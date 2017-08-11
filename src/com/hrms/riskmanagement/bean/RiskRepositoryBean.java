package com.hrms.riskmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;

@Entity
@Table(name="risk_repository_tbl")
public class RiskRepositoryBean implements Serializable {

	private int risk_repository_id;
	private String date_of_risk_identification;
	private String updated_on;
	private String risk_type;
	private String category_of_risk;
	private String risk_description;
	private String stage;
	private String impact;
	private String impact_description;
	private String justification;
	private String mitigation_action;
	private String mitigation_date;
	private String threshold_condition_mitigation;
	private String contingency_action;
	private String threshold_condition_contingency;
	private String contingency_date;
	private int employee_id_contingency;
	private String fallback_plan;
	private String remarks;
	
	
	 
	private RiskPriorityBean riskPriorityBean;
	private ProjectMasterBean projectMasterBean;
	private ProbabilityBean probabilityBean;
	private MonitoringFrequencyBean monitoringFrequencyBean;
	private EmployeeBean employeeBean;
	private RiskStatusBean riskStatusBean;
	private SeverityBean severityBean; 
	
	
	public RiskRepositoryBean(){
	
	}
	
	public RiskRepositoryBean(String date_of_risk_identification,String updated_on, String risk_type, String category_of_risk,
			String risk_description, String stage, String impact, String impact_description, String justification,
			String mitigation_action, String threshold_condition_mitigation, String mitigation_date,
			String contingency_action, String threshold_condition_contingency, String contingency_date,
			int employee_id_contingency,  RiskPriorityBean riskPriorityBean,
			ProjectMasterBean projectMasterBean, ProbabilityBean probabilityBean,
			MonitoringFrequencyBean monitoringFrequencyBean, EmployeeBean employeeBean, RiskStatusBean riskStatusBean ,SeverityBean severityBean,String fallback_plan,String remarks) {
		this.date_of_risk_identification = date_of_risk_identification;
		this.updated_on = updated_on;
		this.risk_type = risk_type;
		this.category_of_risk = category_of_risk;
		this.risk_description = risk_description;
		this.stage = stage;
		this.impact = impact;
		this.impact_description = impact_description;
		this.justification = justification;
		this.mitigation_action = mitigation_action;
		this.threshold_condition_mitigation = threshold_condition_mitigation;
		this.mitigation_date = mitigation_date;
		this.contingency_action = contingency_action;
		this.threshold_condition_contingency = threshold_condition_contingency;
		this.contingency_date = contingency_date;
		this.employee_id_contingency = employee_id_contingency;
		this.riskPriorityBean = riskPriorityBean;
		this.projectMasterBean = projectMasterBean;
		this.probabilityBean = probabilityBean;
		this.monitoringFrequencyBean = monitoringFrequencyBean;
		this.employeeBean = employeeBean;
		this.riskStatusBean = riskStatusBean;
		this.severityBean = severityBean;
		this.fallback_plan = fallback_plan;
		this.remarks = remarks;
	}

	@Id
	@Column(name="risk_repository_id")
    @GeneratedValue
	public int getRisk_repository_id() {
		return risk_repository_id;
	}

	public void setRisk_repository_id(int risk_repository_id) {
		this.risk_repository_id = risk_repository_id;
	}
	@Column(name="updated_on")
	public String getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}
	@Column(name="date_of_risk_identification")
	public String getDate_of_risk_identification() {
		return date_of_risk_identification;
	}

	public void setDate_of_risk_identification(String date_of_risk_identification) {
		this.date_of_risk_identification = date_of_risk_identification;
	}

	
	@Column(name="risk_type")
	public String getRisk_type() {
		return risk_type;
	}

	public void setRisk_type(String risk_type) {
		this.risk_type = risk_type;
	}
	@Column(name="category_of_risk")
	public String getCategory_of_risk() {
		return category_of_risk;
	}

	public void setCategory_of_risk(String category_of_risk) {
		this.category_of_risk = category_of_risk;
	}
	@Column(name="risk_description")
	public String getRisk_description() {
		return risk_description;
	}

	public void setRisk_description(String risk_description) {
		this.risk_description = risk_description;
	}
	@Column(name="stage")
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}
	@Column(name="impact")
	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}
	@Column(name="impact_description")
	public String getImpact_description() {
		return impact_description;
	}

	public void setImpact_description(String impact_description) {
		this.impact_description = impact_description;
	}
	@Column(name="justification")
	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}
	@Column(name="mitigation_action")
	public String getMitigation_action() {
		return mitigation_action;
	}
	
	public void setMitigation_action(String mitigation_action) {
		this.mitigation_action = mitigation_action;
	}
	@Column(name="threshold_condition_mitigation")
	public String getThreshold_condition_mitigation() {
		return threshold_condition_mitigation;
	}

	public void setThreshold_condition_mitigation(String threshold_condition_mitigation) {
		this.threshold_condition_mitigation = threshold_condition_mitigation;
	}
	@Column(name="mitigation_date")
	public String getMitigation_date() {
		return mitigation_date;
	}

	public void setMitigation_date(String mitigation_date) {
		this.mitigation_date = mitigation_date;
	}
	@Column(name="contingency_action")
	public String getContingency_action() {
		return contingency_action;
	}

	public void setContingency_action(String contingency_action) {
		this.contingency_action = contingency_action;
	}
	@Column(name="threshold_condition_contingency")
	public String getThreshold_condition_contingency() {
		return threshold_condition_contingency;
	}

	public void setThreshold_condition_contingency(String threshold_condition_contingency) {
		this.threshold_condition_contingency = threshold_condition_contingency;
	}
	@Column(name="contingency_date")
	public String getContingency_date() {
		return contingency_date;
	}

	public void setContingency_date(String contingency_date) {
		this.contingency_date = contingency_date;
	}
	@Column(name="employee_id_contingency")
	public int getEmployee_id_contingency() {
		return employee_id_contingency;
	}

	public void setEmployee_id_contingency(int employee_id_contingency) {
		this.employee_id_contingency = employee_id_contingency;
	}
	
	@ManyToOne
	@JoinColumn(name="risk_priority_id")
	public RiskPriorityBean getRiskPriorityBean() {
		return riskPriorityBean;
	}

	public void setRiskPriorityBean(RiskPriorityBean riskPriorityBean) {
		this.riskPriorityBean = riskPriorityBean;
	}
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}

	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	@ManyToOne
	@JoinColumn(name="probability_id")
	public ProbabilityBean getProbabilityBean() {
		return probabilityBean;
	}

	public void setProbabilityBean(ProbabilityBean probabilityBean) {
		this.probabilityBean = probabilityBean;
	}
	@ManyToOne
	@JoinColumn(name="monitoring_frequency_id")
	public MonitoringFrequencyBean getMonitoringFrequencyBean() {
		return monitoringFrequencyBean;
	}

	public void setMonitoringFrequencyBean(MonitoringFrequencyBean monitoringFrequencyBean) {
		this.monitoringFrequencyBean = monitoringFrequencyBean;
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
	@JoinColumn(name="risk_status_id")
	public RiskStatusBean getRiskStatusBean() {
		return riskStatusBean;
	}

	public void setRiskStatusBean(RiskStatusBean riskStatusBean) {
		this.riskStatusBean = riskStatusBean;
	}
	@ManyToOne
	@JoinColumn(name="severity_id")
	public SeverityBean getSeverityBean() {
		return severityBean;
	}

	public void setSeverityBean(SeverityBean severityBean) {
		this.severityBean = severityBean;
	}
	@Column(name="fallback_plan")
	public String getFallback_plan() {
		return fallback_plan;
	}

	public void setFallback_plan(String fallback_plan) {
		this.fallback_plan = fallback_plan;
	}
	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
