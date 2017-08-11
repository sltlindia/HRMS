package com.hrms.pms.bean;

import java.io.Serializable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_master_tbl")
public class ProjectMasterBean implements Serializable{

	
	private int project_master_id;
	private String project_master_name;
	private String project_code;
	private String project_description;
    private String planned_start_date;
    private String planned_end_date;
    private String proj_hold_date;
    private String proj_hold_reason;
    private String proj_resume_date;
    private double proj_estimated_cost;
    private double machine_cost;
    private String proj_estimated_resources;
    private String proj_estimated_duration;
    private String actual_end_date;
    private String actual_start_date;
    private int misc_project;
    private String billabled;
    private String billing_type;
    private double billing_cost;
    private String billing_frequency;
    private String deliverable;
    private String status;
    private int approver_id;
   
    private ProjectStatusBean projectStatusBean; 
    private ManagerBean managerBean; 
    private PriorityBean priorityBean;
    private ClientMasterBean clientMasterBean;
    private CurrencyBean currencyBean;
    
    
    public ProjectMasterBean() {
		// TODO Auto-generated constructor stub
	}
    
    
    public ProjectMasterBean(String project_master_name, String project_code, String project_description,
			String planned_start_date, String planned_end_date, String proj_hold_date, String proj_hold_reason,
			String proj_resume_date, double proj_estimated_cost, double machine_cost, String proj_estimated_resources,
			String proj_estimated_duration, String actual_end_date, String actual_start_date, int misc_project,
			String billabled, String billing_type, double billing_cost, String billing_frequency,
			ProjectStatusBean projectStatusBean, ManagerBean managerBean, PriorityBean priorityBean,
			ClientMasterBean clientMasterBean, CurrencyBean currencyBean,String deliverable,String status,int approver_id) {
		super();
		this.project_master_name = project_master_name;
		this.project_code = project_code;
		this.project_description = project_description;
		this.planned_start_date = planned_start_date;
		this.planned_end_date = planned_end_date;
		this.proj_hold_date = proj_hold_date;
		this.proj_hold_reason = proj_hold_reason;
		this.proj_resume_date = proj_resume_date;
		this.proj_estimated_cost = proj_estimated_cost;
		this.machine_cost = machine_cost;
		this.proj_estimated_resources = proj_estimated_resources;
		this.proj_estimated_duration = proj_estimated_duration;
		this.actual_end_date = actual_end_date;
		this.actual_start_date = actual_start_date;
		this.misc_project = misc_project;
		this.billabled = billabled;
		this.billing_type = billing_type;
		this.billing_cost = billing_cost;
		this.billing_frequency = billing_frequency;
		this.projectStatusBean = projectStatusBean;
		this.managerBean = managerBean;
		this.priorityBean = priorityBean;
		this.clientMasterBean = clientMasterBean;
		this.currencyBean = currencyBean;
		this.deliverable = deliverable;
		this.status = status;
		this.approver_id = approver_id;
	}

	@Id 
    @Column(name="project_master_id")
    @GeneratedValue
	public int getProject_master_id() {
		return project_master_id;
	}


	public void setProject_master_id(int project_master_id) {
		this.project_master_id = project_master_id;
	}

	@Column(name="project_master_name")
	public String getProject_master_name() {
		return project_master_name;
	}


	public void setProject_master_name(String project_master_name) {
		this.project_master_name = project_master_name;
	}

	@Column(name="planned_start_date")
	public String getPlanned_start_date() {
		return planned_start_date;
	}


	public void setPlanned_start_date(String planned_start_date) {
		this.planned_start_date = planned_start_date;
	}

	@Column(name="planned_end_date")
	public String getPlanned_end_date() {
		return planned_end_date;
	}


	public void setPlanned_end_date(String planned_end_date) {
		this.planned_end_date = planned_end_date;
	}

	@Column(name="proj_hold_date")
	public String getProj_hold_date() {
		return proj_hold_date;
	}

	
	public void setProj_hold_date(String proj_hold_date) {
		this.proj_hold_date = proj_hold_date;
	}

	@Column(name="proj_hold_reason")
	public String getProj_hold_reason() {
		return proj_hold_reason;
	}


	public void setProj_hold_reason(String proj_hold_reason) {
		this.proj_hold_reason = proj_hold_reason;
	}

	@Column(name="proj_resume_date")
	public String getProj_resume_date() {
		return proj_resume_date;
	}


	public void setProj_resume_date(String proj_resume_date) {
		this.proj_resume_date = proj_resume_date;
	}


	
	@ManyToOne
	@JoinColumn(name="manager_id")
	public ManagerBean getManagerBean() {
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean) {
		this.managerBean = managerBean;
	}

	@ManyToOne
	@JoinColumn(name="project_status_id")
	public ProjectStatusBean getProjectStatusBean() {
		return projectStatusBean;
	}

	
	public void setProjectStatusBean(ProjectStatusBean projectStatusBean) {
		this.projectStatusBean = projectStatusBean;
	}
	
	@Column(name="proj_estimated_cost")
	public double getProj_estimated_cost() {
		return proj_estimated_cost;
	}

	
	public void setProj_estimated_cost(double proj_estimated_cost) {
		this.proj_estimated_cost = proj_estimated_cost;
	}

	@Column(name="proj_estimated_resources")
	public String getProj_estimated_resources() {
		return proj_estimated_resources;
	}

	
	public void setProj_estimated_resources(String proj_estimated_resources) {
		this.proj_estimated_resources = proj_estimated_resources;
	}

	@Column(name="proj_estimated_duration")
	public String getProj_estimated_duration() {
		return proj_estimated_duration;
	}

	
	public void setProj_estimated_duration(String proj_estimated_duration) {
		this.proj_estimated_duration = proj_estimated_duration;
	}

	@ManyToOne
	@JoinColumn(name="priority_id")
	public PriorityBean getPriorityBean() {
		return priorityBean;
	}

	public void setPriorityBean(PriorityBean priorityBean) {
		this.priorityBean = priorityBean;
	}

	@ManyToOne
	@JoinColumn(name="client_master_id")
	public ClientMasterBean getClientMasterBean() {
		return clientMasterBean;
	}

	public void setClientMasterBean(ClientMasterBean clientMasterBean) {
		this.clientMasterBean = clientMasterBean;
	}

	@Column(name="project_description")
	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	@Column(name="actual_end_date")
	public String getActual_end_date() {
		return actual_end_date;
	}

	public void setActual_end_date(String actual_end_date) {
		this.actual_end_date = actual_end_date;
	}

	@Column(name="actual_start_date")
	public String getActual_start_date() {
		return actual_start_date;
	}

	public void setActual_start_date(String actual_start_date) {
		this.actual_start_date = actual_start_date;
	}

	@Column(name="misc_project")
	public int getMisc_project() {
		return misc_project;
	}

	public void setMisc_project(int misc_project) {
		this.misc_project = misc_project;
	}

	@Column(name="billabled")
	public String getBillabled() {
		return billabled;
	}

	public void setBillabled(String billabled) {
		this.billabled = billabled;
	}

	@Column(name="billing_type")
	public String getBilling_type() {
		return billing_type;
	}

	public void setBilling_type(String billing_type) {
		this.billing_type = billing_type;
	}

	@Column(name="billing_cost")
	public double getBilling_cost() {
		return billing_cost;
	}

	public void setBilling_cost(double billing_cost) {
		this.billing_cost = billing_cost;
	}

	@Column(name="billing_frequency")
	public String getBilling_frequency() {
		return billing_frequency;
	}

	public void setBilling_frequency(String billing_frequency) {
		this.billing_frequency = billing_frequency;
	}

	@ManyToOne
	@JoinColumn(name="currency_id")
	public CurrencyBean getCurrencyBean() {
		return currencyBean;
	}

	public void setCurrencyBean(CurrencyBean currencyBean) {
		this.currencyBean = currencyBean;
	}

	public String getProject_code() {
		return project_code;
	}

	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}

	public double getMachine_cost() {
		return machine_cost;
	}

	public void setMachine_cost(double machine_cost) {
		this.machine_cost = machine_cost;
	}


	public String getDeliverable() {
		return deliverable;
	}


	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getApprover_id() {
		return approver_id;
	}


	public void setApprover_id(int approver_id) {
		this.approver_id = approver_id;
	}
	
	
	

	
}
