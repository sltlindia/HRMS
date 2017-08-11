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
@Table(name="task_master_tbl")
public class TaskMasterBean implements Serializable{

	private int task_master_id;
	private String task_master_name;
	private String task_description;
    private String task_planned_start_date;
    private String task_planned_end_date;
    private String task_hold_date;
    private String task_hold_reason;
    private String task_resume_date;
    private double task_estimated_cost;
    private String task_estimated_resources;
    private String task_estimated_duration;
    private String task_actual_start_date;
    private String task_actual_end_date;
    private String task_percentage_completion;
    private int task_id;
    private int milestone_or_not;
    private int master_task_id;
    private int emp_id;
    private int master_task_or_not;
    private String location;
    
    
   
    private ProjectMasterBean projectMasterBean;
	private PriorityBean priorityBean;
	private ManagerBean managerBean;
	private StatusBean statusBean;
	private MilestoneBean milestoneBean;
	
	
	public TaskMasterBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public TaskMasterBean(String task_master_name, String task_description, String task_planned_start_date,
			String task_planned_end_date, String task_hold_date, String task_hold_reason, String task_resume_date,
			double task_estimated_cost, String task_estimated_resources, String task_estimated_duration,
			String task_actual_start_date, String task_actual_end_date, String task_percentage_completion, int task_id,
			int milestone_or_not, ProjectMasterBean projectMasterBean, PriorityBean priorityBean,
			ManagerBean managerBean, StatusBean statusBean, MilestoneBean milestoneBean) {
		super();
		this.task_master_name = task_master_name;
		this.task_description = task_description;
		this.task_planned_start_date = task_planned_start_date;
		this.task_planned_end_date = task_planned_end_date;
		this.task_hold_date = task_hold_date;
		this.task_hold_reason = task_hold_reason;
		this.task_resume_date = task_resume_date;
		this.task_estimated_cost = task_estimated_cost;
		this.task_estimated_resources = task_estimated_resources;
		this.task_estimated_duration = task_estimated_duration;
		this.task_actual_start_date = task_actual_start_date;
		this.task_actual_end_date = task_actual_end_date;
		this.task_percentage_completion = task_percentage_completion;
		this.task_id = task_id;
		this.milestone_or_not = milestone_or_not;
		this.projectMasterBean = projectMasterBean;
		this.priorityBean = priorityBean;
		this.managerBean = managerBean;
		this.statusBean = statusBean;
		this.milestoneBean = milestoneBean;
	}
	
	
	
	
	
	
	
	public TaskMasterBean(String task_master_name, String task_description, String task_planned_start_date,
			String task_planned_end_date, String task_hold_date, String task_hold_reason, String task_resume_date,
			double task_estimated_cost, String task_estimated_resources, String task_estimated_duration,
			String task_actual_start_date, String task_actual_end_date, String task_percentage_completion, int task_id,
			int milestone_or_not, int master_task_id, ProjectMasterBean projectMasterBean, PriorityBean priorityBean,
			ManagerBean managerBean, StatusBean statusBean, MilestoneBean milestoneBean,int emp_id) {
		super();
		this.task_master_name = task_master_name;
		this.task_description = task_description;
		this.task_planned_start_date = task_planned_start_date;
		this.task_planned_end_date = task_planned_end_date;
		this.task_hold_date = task_hold_date;
		this.task_hold_reason = task_hold_reason;
		this.task_resume_date = task_resume_date;
		this.task_estimated_cost = task_estimated_cost;
		this.task_estimated_resources = task_estimated_resources;
		this.task_estimated_duration = task_estimated_duration;
		this.task_actual_start_date = task_actual_start_date;
		this.task_actual_end_date = task_actual_end_date;
		this.task_percentage_completion = task_percentage_completion;
		this.task_id = task_id;
		this.milestone_or_not = milestone_or_not;
		this.master_task_id = master_task_id;
		this.projectMasterBean = projectMasterBean;
		this.priorityBean = priorityBean;
		this.managerBean = managerBean;
		this.statusBean = statusBean;
		this.milestoneBean = milestoneBean;
		this.emp_id = emp_id;
	}



	@Id
	@Column(name="task_master_id")
	@GeneratedValue
	public int getTask_master_id() {
		return task_master_id;
	}
	public void setTask_master_id(int task_master_id) {
		this.task_master_id = task_master_id;
	}
	@Column(name="task_master_name")
	public String getTask_master_name() {
		return task_master_name;
	}
	public void setTask_master_name(String task_master_name) {
		this.task_master_name = task_master_name;
	}
	@Column(name="task_description")
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	@Column(name="task_planned_start_date")
	public String getTask_planned_start_date() {
		return task_planned_start_date;
	}
	public void setTask_planned_start_date(String task_planned_start_date) {
		this.task_planned_start_date = task_planned_start_date;
	}
	@Column(name="task_planned_end_date")
	public String getTask_planned_end_date() {
		return task_planned_end_date;
	}
	public void setTask_planned_end_date(String task_planned_end_date) {
		this.task_planned_end_date = task_planned_end_date;
	}
	@Column(name="task_hold_date")
	public String getTask_hold_date() {
		return task_hold_date;
	}
	public void setTask_hold_date(String task_hold_date) {
		this.task_hold_date = task_hold_date;
	}
	@Column(name="task_hold_reason")
	public String getTask_hold_reason() {
		return task_hold_reason;
	}
	public void setTask_hold_reason(String task_hold_reason) {
		this.task_hold_reason = task_hold_reason;
	}
	@Column(name="task_resume_date")
	public String getTask_resume_date() {
		return task_resume_date;
	}
	public void setTask_resume_date(String task_resume_date) {
		this.task_resume_date = task_resume_date;
	}
	@Column(name="task_estimated_cost")
	public double getTask_estimated_cost() {
		return task_estimated_cost;
	}
	public void setTask_estimated_cost(double task_estimated_cost) {
		this.task_estimated_cost = task_estimated_cost;
	}
	@Column(name="task_estimated_resources")
	public String getTask_estimated_resources() {
		return task_estimated_resources;
	}
	public void setTask_estimated_resources(String task_estimated_resources) {
		this.task_estimated_resources = task_estimated_resources;
	}
	@Column(name="task_estimated_duration")
	public String getTask_estimated_duration() {
		return task_estimated_duration;
	}
	public void setTask_estimated_duration(String task_estimated_duration) {
		this.task_estimated_duration = task_estimated_duration;
	}
	@Column(name="task_actual_start_date")
	public String getTask_actual_start_date() {
		return task_actual_start_date;
	}
	public void setTask_actual_start_date(String task_actual_start_date) {
		this.task_actual_start_date = task_actual_start_date;
	}
	@Column(name="task_actual_end_date")
	public String getTask_actual_end_date() {
		return task_actual_end_date;
	}
	public void setTask_actual_end_date(String task_actual_end_date) {
		this.task_actual_end_date = task_actual_end_date;
	}
	@Column(name="task_percentage_completion")
	public String getTask_percentage_completion() {
		return task_percentage_completion;
	}
	public void setTask_percentage_completion(String task_percentage_completion) {
		this.task_percentage_completion = task_percentage_completion;
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
	@JoinColumn(name="priority_id")
	public PriorityBean getPriorityBean() {
		return priorityBean;
	}

	public void setPriorityBean(PriorityBean priorityBean) {
		this.priorityBean = priorityBean;
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
	@JoinColumn(name="status_id")
	public StatusBean getStatusBean() {
		return statusBean;
	}
	
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	
	
	@ManyToOne
	@JoinColumn(name="milestone_id")
	public MilestoneBean getMilestoneBean() {
		return milestoneBean;
	}
	public void setMilestoneBean(MilestoneBean milestoneBean) {
		this.milestoneBean = milestoneBean;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getMilestone_or_not() {
		return milestone_or_not;
	}
	public void setMilestone_or_not(int milestone_or_not) {
		this.milestone_or_not = milestone_or_not;
	}



	public int getMaster_task_id() {
		return master_task_id;
	}



	public void setMaster_task_id(int master_task_id) {
		this.master_task_id = master_task_id;
	}
	
	@Column(name="emp_id")
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	@Column(name="master_task_or_not")
	public int getMaster_task_or_not() {
		return master_task_or_not;
	}

	public void setMaster_task_or_not(int master_task_or_not) {
		this.master_task_or_not = master_task_or_not;
	}


	@Column(name="location")
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
