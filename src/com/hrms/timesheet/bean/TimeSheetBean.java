package com.hrms.timesheet.bean;

import java.io.Serializable;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;

@Entity
@Table(name="timesheet_tbl")
public class TimeSheetBean implements Serializable{
	

		private int timesheet_master_id;
		private String date;
		private double worked_hours;
		private double leave_hours;
	    private String employee_comment;
	    private String manager_comment;
	    private String task_time_status;
	    private String approval_status;
	    private String rejection_reason;
	    private String external_task_name;
	    private double percentage_completed;
	    private int unplanned_task;
	   
	   /* private String approval_status;
	    private int leave_id;*/
	    
	    private EmployeeBean employeeBean;
	    private ProjectMasterBean projectMasterBean;
	    private TaskMasterBean taskMasterBean;
	    private ClientMasterBean clientMasterBean;
	    private DayBean dayBean;
	    
	    
	    public TimeSheetBean() {
			// TODO Auto-generated constructor stub
	    }
	    
	    public TimeSheetBean(EmployeeBean employeeBean,ProjectMasterBean projectMasterBean,TaskMasterBean taskMasterBean,ClientMasterBean clientMasterBean,DayBean dayBean,String date,double worked_hours,String employee_comment,String task_time_status,String approval_status,double percentage_completed,String external_task_name, int unplanned_task){
	    	this.employeeBean = employeeBean;
	    	this.projectMasterBean = projectMasterBean;
	    	this.taskMasterBean = taskMasterBean;
	    	this.clientMasterBean = clientMasterBean;
	    	this.dayBean = dayBean;
	    	this.date = date;
	    	this.worked_hours = worked_hours;
	    	this.leave_hours = leave_hours;
	    	this.employee_comment = employee_comment;
	    	this.task_time_status = task_time_status;
	    	this.approval_status = approval_status;
	    	this.percentage_completed = percentage_completed;
	    	this.external_task_name = external_task_name;
	    	this.unplanned_task = unplanned_task;
	    }
	    
	    
	    public TimeSheetBean(EmployeeBean employeeBean,ProjectMasterBean projectMasterBean,TaskMasterBean taskMasterBean,ClientMasterBean clientMasterBean,DayBean dayBean,String date,double worked_hours,String employee_comment,String task_time_status,String approval_status,double percentage_completed,String external_task_name){
	    	this.employeeBean = employeeBean;
	    	this.projectMasterBean = projectMasterBean;
	    	this.taskMasterBean = taskMasterBean;
	    	this.clientMasterBean = clientMasterBean;
	    	this.dayBean = dayBean;
	    	this.date = date;
	    	this.worked_hours = worked_hours;
	    	this.leave_hours = leave_hours;
	    	this.employee_comment = employee_comment;
	    	this.task_time_status = task_time_status;
	    	this.approval_status = approval_status;
	    	this.percentage_completed = percentage_completed;
	    	this.external_task_name = external_task_name;
	    }
	    
	    
	    public TimeSheetBean(String date,EmployeeBean employeeBean,DayBean dayBean,String task_time_status,double worked_hours,double leave_hours,String approval_status) {
	    	this.date = date;	    
	    	this.employeeBean = employeeBean;
	    	this.dayBean = dayBean;
	    	this.task_time_status = task_time_status;
	    	this.leave_hours = leave_hours;
	    	this.worked_hours = worked_hours;
	    	this.approval_status = approval_status;
	    }
	    public TimeSheetBean(int timesheet_master_id,ProjectMasterBean projectMasterBean,ClientMasterBean clientMasterBean,TaskMasterBean taskMasterBean,String task_time_status,double worked_hours,double leave_hours) {
	    	this.timesheet_master_id = timesheet_master_id;	    
	    	this.projectMasterBean = projectMasterBean;
	    	this.clientMasterBean = clientMasterBean;
	    	this.taskMasterBean = taskMasterBean;
	    	this.task_time_status = task_time_status;
	    	this.leave_hours = leave_hours;
	    	this.worked_hours = worked_hours;
	    }

	    
	    @Id 
	    @Column(name="timesheet_master_id")
	    @GeneratedValue 
		public int getTimesheet_master_id() {
			return timesheet_master_id;
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
		@JoinColumn(name="project_master_id")
		public ProjectMasterBean getProjectMasterBean() {
			return projectMasterBean;
		}

		public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
			this.projectMasterBean = projectMasterBean;
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
		@JoinColumn(name="client_master_id")
		public ClientMasterBean getClientMasterBean() {
			return clientMasterBean;
		}

		public void setClientMasterBean(ClientMasterBean clientMasterBean) {
			this.clientMasterBean = clientMasterBean;
		}

		@ManyToOne
		@JoinColumn(name="day_id")
		public DayBean getDayBean() {
			return dayBean;
		}

		public void setDayBean(DayBean dayBean) {
			this.dayBean = dayBean;
		}
	    

		public void setTimesheet_master_id(int timesheet_master_id) {
			this.timesheet_master_id = timesheet_master_id;
		}
		
		@Column(name="date")
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		@Column(name="worked_hours")
		public double getWorked_hours() {
			return worked_hours;
		}

		public void setWorked_hours(double worked_hours) {
			this.worked_hours = worked_hours;
		}

		@Column(name="leave_hours")
		public double getLeave_hours() {
			return leave_hours;
		}

		public void setLeave_hours(double leave_hours) {
			this.leave_hours = leave_hours;
		}

		@Column(name="employee_comment")
		public String getEmployee_comment() {
			return employee_comment;
		}

		public void setEmployee_comment(String employee_comment) {
			this.employee_comment = employee_comment;
		}

		/*public String getManager_comment() {
			return manager_comment;
		}

		public void setManager_comment(String manager_comment) {
			this.manager_comment = manager_comment;
		}
*/
		@Column(name="task_time_status")
		public String getTask_time_status() {
			return task_time_status;
		}

		public void setTask_time_status(String task_time_status) {
			this.task_time_status = task_time_status;
		}

		@Column(name="approval_status")
		public String getApproval_status() {
			return approval_status;
		}

		public void setApproval_status(String approval_status) {
			this.approval_status = approval_status;
		}

		@Column(name="manager_comment")
		public String getManager_comment() {
			return manager_comment;
		}

		public void setManager_comment(String manager_comment) {
			this.manager_comment = manager_comment;
		}

		@Column(name="rejection_reason")
		public String getRejection_reason() {
			return rejection_reason;
		}

		public void setRejection_reason(String rejection_reason) {
			this.rejection_reason = rejection_reason;
		}

		@Column(name="percentage_completed")
		public double getPercentage_completed() {
			return percentage_completed;
		}

		public void setPercentage_completed(double percentage_completed) {
			this.percentage_completed = percentage_completed;
		}

		@Column(name="external_task_name")
		public String getExternal_task_name() {
			return external_task_name;
		}

		public void setExternal_task_name(String external_task_name) {
			this.external_task_name = external_task_name;
		}

		@Column(name="unplanned_task")
		public int getUnplanned_task() {
			return unplanned_task;
		}

		public void setUnplanned_task(int unplanned_task) {
			this.unplanned_task = unplanned_task;
		}

	

		
		
	    
	    
	    


}
