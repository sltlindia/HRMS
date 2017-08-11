package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.cache.impl.bridge.QueryResultsRegionAdapter;

@Entity
@Table(name="appraisal_tbl")
public class AppraisalBean implements Serializable{

	private int appraisal_id;
	private String date_of_submission;
	private String achievement;
	private String area_of_improvement;
	private String emp_comment;
	private String appraiser_commnet;
	private String reviewing_comment;
	private int white_collar;
	private String status;
	private double per;
	
	
	private EmployeeBean employeeBean;
	private MonthBean monthBean;
	private YearBean yearBean;
	private QuterlyMonthBean quterlyMonthBean;
	
	
	public AppraisalBean() {
	}
	
	public AppraisalBean(EmployeeBean employeeBean,MonthBean monthBean,YearBean yearBean,String date_of_submission,String achievement,String area_of_improvement,String emp_comment,String appraiser_commnet,String reviewing_comment,QuterlyMonthBean quterlyMonthBean,int white_collar,String status) {
		this.employeeBean = employeeBean;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
		this.date_of_submission = date_of_submission;
		this.achievement = achievement;
		this.area_of_improvement = area_of_improvement;
		this.emp_comment = emp_comment;
		this.appraiser_commnet = appraiser_commnet;
		this.reviewing_comment = reviewing_comment;
		this.quterlyMonthBean = quterlyMonthBean;
		this.white_collar = white_collar;
		this.status = status;
	}

	@Id
	@Column(name="appraisal_id")
    @GeneratedValue
	public int getAppraisal_id() {
		return appraisal_id;
	}
	public void setAppraisal_id(int appraisal_id) {
		this.appraisal_id = appraisal_id;
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
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}
	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}
	
	@ManyToOne
	@JoinColumn(name="year_id")
	public YearBean getYearBean() {
		return yearBean;
	}
	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}

	public String getDate_of_submission() {
		return date_of_submission;
	}

	public void setDate_of_submission(String date_of_submission) {
		this.date_of_submission = date_of_submission;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getArea_of_improvement() {
		return area_of_improvement;
	}

	public void setArea_of_improvement(String area_of_improvement) {
		this.area_of_improvement = area_of_improvement;
	}

	public String getEmp_comment() {
		return emp_comment;
	}

	public void setEmp_comment(String emp_comment) {
		this.emp_comment = emp_comment;
	}

	public String getAppraiser_commnet() {
		return appraiser_commnet;
	}

	public void setAppraiser_commnet(String appraiser_commnet) {
		this.appraiser_commnet = appraiser_commnet;
	}

	public String getReviewing_comment() {
		return reviewing_comment;
	}

	public void setReviewing_comment(String reviewing_comment) {
		this.reviewing_comment = reviewing_comment;
	}

	@ManyToOne
	@JoinColumn(name="quarterly_month_id")
	public QuterlyMonthBean getQuterlyMonthBean() {
		return quterlyMonthBean;
	}

	public void setQuterlyMonthBean(QuterlyMonthBean quterlyMonthBean) {
		this.quterlyMonthBean = quterlyMonthBean;
	}

	public int getWhite_collar() {
		return white_collar;
	}

	public void setWhite_collar(int white_collar) {
		this.white_collar = white_collar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}
	
	
	
	
	
}
