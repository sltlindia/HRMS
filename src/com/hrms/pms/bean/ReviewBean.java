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
@Table(name="review_tbl")
public class ReviewBean implements Serializable
{

	
    private int review_id;
    private String date_submission_employee;
    private String approve_status;
    private double tech_ave;
    private double soft_ave;
    private double tech_bonus;
    private double soft_bonus;
    private double total_bonus;
    private double performance_score;
    private String remarks_manager;
    private String achievements;
    private String area_of_improvement;
    private String date_finalize_manager;
    private int escalated_employee_id;
    
    private YearBean yearBean;
    private MonthBean monthBean;
    private ProjectMasterBean projectMasterBean;
    private EmployeeBean employeeBean;
    
    public ReviewBean() {
		// TODO Auto-generated constructor stub
	}
    
    
    public ReviewBean(EmployeeBean employeeBean,ProjectMasterBean projectMasterBean,MonthBean monthBean,YearBean yearBean,String date_submission_employee,String approve_status) {
        this.projectMasterBean=projectMasterBean;
        this.monthBean=monthBean;
        this.yearBean=yearBean;
        this.date_submission_employee=date_submission_employee;
        this.employeeBean= employeeBean;
        this.approve_status = approve_status;
    }
    

    @Id 
    @Column(name="review_id")
    @GeneratedValue
	public int getReview_id() {
		return review_id;
	}


	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	@ManyToOne
	@JoinColumn(name="year_id")
	public YearBean getYearBean() {
		return yearBean;
	}


	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}

	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}


	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}

	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}


	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}




	public String getDate_submission_employee() {
		return date_submission_employee;
	}


	public void setDate_submission_employee(String date_submission_employee) {
		this.date_submission_employee = date_submission_employee;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	 @Column(name="approve_status")
	public String getApprove_status() {
		return approve_status;
	}


	public void setApprove_status(String approve_status) {
		this.approve_status = approve_status;
	}

	@Column(name="tech_ave")
	public double getTech_ave() {
		return tech_ave;
	}


	public void setTech_ave(double tech_ave) {
		this.tech_ave = tech_ave;
	}

	@Column(name="soft_ave")
	public double getSoft_ave() {
		return soft_ave;
	}


	public void setSoft_ave(double soft_ave) {
		this.soft_ave = soft_ave;
	}

	@Column(name="tech_bonus")
	public double getTech_bonus() {
		return tech_bonus;
	}

	
	public void setTech_bonus(double tech_bonus) {
		this.tech_bonus = tech_bonus;
	}

	@Column(name="soft_bonus")
	public double getSoft_bonus() {
		return soft_bonus;
	}


	public void setSoft_bonus(double soft_bonus) {
		this.soft_bonus = soft_bonus;
	}

	@Column(name="total_bonus")
	public double getTotal_bonus() {
		return total_bonus;
	}


	public void setTotal_bonus(double total_bonus) {
		this.total_bonus = total_bonus;
	}


	public double getPerformance_score() {
		return performance_score;
	}


	public void setPerformance_score(double performance_score) {
		this.performance_score = performance_score;
	}


	@Column(name="remarks_manager")
	public String getRemarks_manager() {
		return remarks_manager;
	}


	public void setRemarks_manager(String remarks_manager) {
		this.remarks_manager = remarks_manager;
	}

	
	
	@Column(name="achievements")
	public String getAchievements() {
		return achievements;
	}


	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}


	@Column(name="area_of_improvement")
	public String getArea_of_improvement() {
		return area_of_improvement;
	}


	public void setArea_of_improvement(String area_of_improvement) {
		this.area_of_improvement = area_of_improvement;
	}

	@Column(name="date_finalize_manager")
	public String getDate_finalize_manager() {
		return date_finalize_manager;
	}


	public void setDate_finalize_manager(String date_finalize_manager) {
		this.date_finalize_manager = date_finalize_manager;
	}

	@Column(name="escalated_employee_id")
	public int getEscalated_employee_id() {
		return escalated_employee_id;
	}


	public void setEscalated_employee_id(int escalated_employee_id) {
		this.escalated_employee_id = escalated_employee_id;
	}

	
	
    
}