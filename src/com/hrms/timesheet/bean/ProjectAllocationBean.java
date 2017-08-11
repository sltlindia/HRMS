package com.hrms.timesheet.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name="project_allocation_tbl")
public class ProjectAllocationBean {

	private int Project_Allocation_id;
	private int under_manager_id;
	private int allocation_status;
	
	private ProjectMasterBean projectMasterBean;
	private EmployeeBean employeeBean;
	private TaskMasterBean taskMasterBean;
	private MonthBean monthBean;
	private YearBean yearBean;
	
	public ProjectAllocationBean() {
		// TODO Auto-generated constructor stub
    }

	
	@Id
	@Column(name="project_allocation_id")
	@GeneratedValue
	public int getProject_Allocation_id() {
		return Project_Allocation_id;
	}

	public void setProject_Allocation_id(int project_Allocation_id) {
		Project_Allocation_id = project_Allocation_id;
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
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@ManyToOne
	@JoinColumn(name="task_master_id")
	public TaskMasterBean getTaskMasterBean() {
		return taskMasterBean;
	}


	public void setTaskMasterBean(TaskMasterBean taskMasterBean) {
		this.taskMasterBean = taskMasterBean;
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

	
	@Column(name="under_manager_id")
	public int getUnder_manager_id() {
		return under_manager_id;
	}


	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}

	@Column(name="allocation_status")
	public int getAllocation_status() {
		return allocation_status;
	}


	public void setAllocation_status(int allocation_status) {
		this.allocation_status = allocation_status;
	}


	

	
	
	
}
