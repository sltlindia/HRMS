package com.hrms.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.timesheet.bean.ProjectAllocationBean;

@Entity
@Table(name="allocation_notification_tbl")
public class AllocationNotificationBean {

	private int allocation_notification_id;
	private int show_view;
	
	
	private ProjectAllocationPercentageBean allocationPercentageBean;
	private ProjectAllocationBean projectAllocationBean;
	private EmployeeBean employeeBean;

	@Id
	@Column(name="allocation_notification_id")
    @GeneratedValue
	public int getAllocation_notification_id() {
		return allocation_notification_id;
	}

	public void setAllocation_notification_id(int allocation_notification_id) {
		this.allocation_notification_id = allocation_notification_id;
	}

	@Column(name="show_view")
	public int getShow_view() {
		return show_view;
	}

	public void setShow_view(int show_view) {
		this.show_view = show_view;
	}

	@ManyToOne
	@JoinColumn(name="project_allocation_percentage_id")
	public ProjectAllocationPercentageBean getAllocationPercentageBean() {
		return allocationPercentageBean;
	}

	public void setAllocationPercentageBean(ProjectAllocationPercentageBean allocationPercentageBean) {
		this.allocationPercentageBean = allocationPercentageBean;
	}

	@ManyToOne
	@JoinColumn(name="project_allocation_id")
	public ProjectAllocationBean getProjectAllocationBean() {
		return projectAllocationBean;
	}

	public void setProjectAllocationBean(ProjectAllocationBean projectAllocationBean) {
		this.projectAllocationBean = projectAllocationBean;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	
	
	
	
	
	
}
