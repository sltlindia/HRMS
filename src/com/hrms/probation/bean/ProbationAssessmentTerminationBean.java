package com.hrms.probation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name = "probation_assessment_termination_tbl")
public class ProbationAssessmentTerminationBean {

	private int probation_assessment_termination_id;
	private int reviewing_manager_id;
	private EmployeeBean employeeBean;
	private String manager_status;
	private String termination_remarks;
	private String manager_rejection_remarks;
	private MonthBean monthBean;
	private YearBean yearBean;

	public ProbationAssessmentTerminationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProbationAssessmentTerminationBean(int reviewing_manager_id, EmployeeBean employeeBean,
			String manager_status,MonthBean monthBean, YearBean yearBean,String termination_remarks) {
		this.reviewing_manager_id = reviewing_manager_id;
		this.employeeBean = employeeBean;
		this.manager_status = manager_status;
		this.termination_remarks = termination_remarks;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
	}

	@Id
	@Column(name = "probation_assessment_termination_id")
	@GeneratedValue
	public int getProbation_assessment_termination_id() {
		return probation_assessment_termination_id;
	}

	public void setProbation_assessment_termination_id(int probation_assessment_termination_id) {
		this.probation_assessment_termination_id = probation_assessment_termination_id;
	}

	@Column(name = "reviewing_manager_id")
	public int getReviewing_manager_id() {
		return reviewing_manager_id;
	}

	public void setReviewing_manager_id(int reviewing_manager_id) {
		this.reviewing_manager_id = reviewing_manager_id;
	}

	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@Column(name = "manager_status")
	public String getManager_status() {
		return manager_status;
	}

	public void setManager_status(String manager_status) {
		this.manager_status = manager_status;
	}

	@Column(name = "manager_rejection_remarks")
	public String getManager_rejection_remarks() {
		return manager_rejection_remarks;
	}

	public void setManager_rejection_remarks(String manager_rejection_remarks) {
		this.manager_rejection_remarks = manager_rejection_remarks;
	}

	@ManyToOne
	@JoinColumn(name = "month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}

	@ManyToOne
	@JoinColumn(name = "year_id")
	public YearBean getYearBean() {
		return yearBean;
	}

	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}

	
	@Column(name = "termination_remarks")
	public String getTermination_remarks() {
		return termination_remarks;
	}

	public void setTermination_remarks(String termination_remarks) {
		this.termination_remarks = termination_remarks;
	}

}
