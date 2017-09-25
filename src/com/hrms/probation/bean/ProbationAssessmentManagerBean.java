package com.hrms.probation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="probation_assessment_manager_tbl")
public class ProbationAssessmentManagerBean {
	
	//Probation Assessment Manager Bean for Adding,Updating,Deleting data into table probation_assessment_manager_tbl
	//getter and setter for inserting into probation_assessment_manager_tbl
	private int probation_assessment_manager_id;
	private int reviewing_manager_id;
	private double average;
	private String to_be_confirmed;
	private String to_be_terminated;
	private String to_be_extended;
	private String remarks;
	private String period_to_be_extended;
	private String repoting_manager_approval;
	private String manager_approval;
	private String manager_rejection_remarks;
	private String hr_approval;
	private String hr_rejection_remarks;
	private String top_management_approval;
	private String top_management_rejection_remarks;
	private EmployeeBean employeeBean;
	private boolean show_view;
	private String manager_suggestion; 
	
	public ProbationAssessmentManagerBean() {
		super();
	}
	

	//Probation Assessment Bean for insertion of data into table probation_assessment_manager_tbl for reporting manager's manager
	public ProbationAssessmentManagerBean(int probation_assessment_manager_id, int reviewing_manager_id,
			double average, String to_be_confirmed, String to_be_terminated, String to_be_extended, String remarks,
			String period_to_be_extended, EmployeeBean employeeBean) {
		super();
		this.probation_assessment_manager_id = probation_assessment_manager_id;
		this.reviewing_manager_id = reviewing_manager_id;
		this.average = average;
		this.to_be_confirmed = to_be_confirmed;
		this.to_be_terminated = to_be_terminated;
		this.to_be_extended = to_be_extended;
		this.remarks = remarks;
		this.period_to_be_extended = period_to_be_extended;
		this.employeeBean = employeeBean;
		
	}

	//Probation Assessment Bean for updation of data into table probation_assessment_manager_tbl for reporting manager
	public ProbationAssessmentManagerBean(int reviewing_manager_id, double average, String to_be_confirmed,
			String to_be_terminated, String to_be_extended, String remarks, String period_to_be_extended,
			EmployeeBean employeeBean,String manager_approval,String manager_rejection_remarks,String hr_approval,String hr_rejection_remarks,String top_management_approval,String  top_management_rejection_remarks,String repoting_manager_approval) 
	{		super();
		this.reviewing_manager_id = reviewing_manager_id;
		this.average = average;
		this.to_be_confirmed = to_be_confirmed;
		this.to_be_terminated = to_be_terminated;
		this.to_be_extended = to_be_extended;
		this.remarks = remarks;
		this.period_to_be_extended = period_to_be_extended;
		this.employeeBean = employeeBean;
		this.manager_approval = manager_approval;
		this.manager_rejection_remarks = manager_rejection_remarks;
		this.hr_approval = hr_approval;
		this.hr_rejection_remarks = hr_rejection_remarks;
		this.top_management_approval = top_management_approval;
		this.top_management_rejection_remarks =  top_management_rejection_remarks;
		this.repoting_manager_approval = repoting_manager_approval;
	}

	
	//Probation Assessment Bean for insertion of data into table probation_assessment_manager_tbl for reporting manager
	public ProbationAssessmentManagerBean(int probation_assessment_manager_id, 
			String to_be_confirmed, String to_be_terminated, String to_be_extended, String remarks,
			String period_to_be_extended, String manager_approval, String manager_rejection_remarks, String hr_approval,
			String hr_rejection_remarks, String top_management_approval, String top_management_rejection_remarks,String repoting_manager_approval) {
		super();
		this.probation_assessment_manager_id = probation_assessment_manager_id;
		this.to_be_confirmed = to_be_confirmed;
		this.to_be_terminated = to_be_terminated;
		this.to_be_extended = to_be_extended;
		this.remarks = remarks;
		this.period_to_be_extended = period_to_be_extended;
		this.manager_approval = manager_approval;
		this.manager_rejection_remarks = manager_rejection_remarks;
		this.hr_approval = hr_approval;
		this.hr_rejection_remarks = hr_rejection_remarks;
		this.top_management_approval = top_management_approval;
		this.top_management_rejection_remarks = top_management_rejection_remarks;
		this.repoting_manager_approval = repoting_manager_approval;
	}

	//Probation Assessment Bean for insertion of data into table probation_assessment_manager_tbl for adding hr_approval
	public ProbationAssessmentManagerBean(String hr_approval, String hr_rejection_remarks) {
		super();
		this.hr_approval = hr_approval;
		this.hr_rejection_remarks = hr_rejection_remarks;
	}

	@Id
	@Column(name="probation_assessment_manager_id")
	@GeneratedValue
	//getter and setter method for column probation_assessment_manager_id of probation_assessment_indirect_tbl
	public int getProbation_assessment_manager_id() {
		return probation_assessment_manager_id;
	}

	public void setProbation_assessment_manager_id(int probation_assessment_manager_id) {
		this.probation_assessment_manager_id = probation_assessment_manager_id;
	}
	@Column(name="reviewing_manager_id")
	//getter and setter method for column reviewing_manager_id of probation_assessment_indirect_tbl
	public int getReviewing_manager_id() {
		return reviewing_manager_id;
	}

	public void setReviewing_manager_id(int reviewing_manager_id) {
		this.reviewing_manager_id = reviewing_manager_id;
	}

	@Column(name="average")
	//getter and setter method for column average of probation_assessment_indirect_tbl
	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	@Column(name="to_be_confirmed")
	//getter and setter method for column to_be_confirmed of probation_assessment_indirect_tbl
	public String getTo_be_confirmed() {
		return to_be_confirmed;
	}

	public void setTo_be_confirmed(String to_be_confirmed) {
		this.to_be_confirmed = to_be_confirmed;
	}

	@Column(name="to_be_terminated")
	//getter and setter method for column to_be_confirmed of probation_assessment_indirect_tbl
	public String getTo_be_terminated() {
		return to_be_terminated;
	}

	public void setTo_be_terminated(String to_be_terminated) {
		this.to_be_terminated = to_be_terminated;
	}

	@Column(name="to_be_extended")
	//getter and setter method for column to_be_extended of probation_assessment_indirect_tbl
	public String getTo_be_extended() {
		return to_be_extended;
	}

	public void setTo_be_extended(String to_be_extended) {
		this.to_be_extended = to_be_extended;
	}

	@Column(name="remarks")
	//getter and setter method for column remarks of probation_assessment_indirect_tbl
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name="period_to_be_extended")
	//getter and setter method for column period_to_be_extended of probation_assessment_indirect_tbl
	public String getPeriod_to_be_extended() {
		return period_to_be_extended;
	}

	public void setPeriod_to_be_extended(String period_to_be_extended) {
		this.period_to_be_extended = period_to_be_extended;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	//getter and setter method for column employeeBean of probation_assessment_indirect_tbl
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	@Column(name="manager_approval")
	//getter and setter method for column manager_approval of probation_assessment_indirect_tbl
	public String getManager_approval() {
		return manager_approval;
	}

	
	public void setManager_approval(String manager_approval) {
		this.manager_approval = manager_approval;
	}

	@Column(name="manager_rejection_remarks")
	//getter and setter method for column manager_rejection_remarks of probation_assessment_indirect_tbl
	public String getManager_rejection_remarks() {
		return manager_rejection_remarks;
	}

	public void setManager_rejection_remarks(String manager_rejection_remarks) {
		this.manager_rejection_remarks = manager_rejection_remarks;
	}

	@Column(name="hr_approval")
	//getter and setter method for column hr_approval of probation_assessment_indirect_tbl
	public String getHr_approval() {
		return hr_approval;
	}

	public void setHr_approval(String hr_approval) {
		this.hr_approval = hr_approval;
	}
	@Column(name="hr_rejection_remarks")
	//getter and setter method for column hr_rejection_remarks of probation_assessment_indirect_tbl
	public String getHr_rejection_remarks() {
		return hr_rejection_remarks;
	}

	public void setHr_rejection_remarks(String hr_rejection_remarks) {
		this.hr_rejection_remarks = hr_rejection_remarks;
	}

	@Column(name="top_management_approval")
	//getter and setter method for column top_management_approval of probation_assessment_indirect_tbl
	public String getTop_management_approval() {
		return top_management_approval;
	}

	public void setTop_management_approval(String top_management_approval) {
		this.top_management_approval = top_management_approval;
	}

	@Column(name="top_management_rejection_remarks")
	//getter and setter method for column top_management_rejection_remarks of probation_assessment_indirect_tbl
	public String getTop_management_rejection_remarks() {
		return top_management_rejection_remarks;
	}

	public void setTop_management_rejection_remarks(String top_management_rejection_remarks) {
		this.top_management_rejection_remarks = top_management_rejection_remarks;
	}

	@Column(name="reporting_manager_approval")
	//getter and setter method for column repoting_manager_approval of probation_assessment_indirect_tbl
	public String getRepoting_manager_approval() {
		return repoting_manager_approval;
	}

	public void setRepoting_manager_approval(String repoting_manager_approval) {
		this.repoting_manager_approval = repoting_manager_approval;
	}

	@Column(name="show_view")
	public boolean isShow_view() {
		return show_view;
	}
	
	public void setShow_view(boolean show_view) {
		this.show_view = show_view;
	}
	
	/**
	 * @return the manager_suggestion
	 */
	public String getManager_suggestion() {
		return manager_suggestion;
	}
	/**
	 * @param manager_suggestion the manager_suggestion to set
	 */
	public void setManager_suggestion(String manager_suggestion) {
		this.manager_suggestion = manager_suggestion;
	}
}
