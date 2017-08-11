package com.hrms.recruitement.bean;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.RoleBean;

import java.io.Serializable;

@Entity
@Table(name = "interview_feedback_tbl")
public class InterviewFeedbackBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int interview_feedback_id;
	private String interview_date;
	
	private String start_time;
	private String end_time;
	private String comments;
	private String technical_professional_knowledge;
	private String work_experience;
	private String appearance;
	private String manners;
	private String overall;
	private String decision;
	private String reject_reason;
	private String joining_in_days;
	private String salary;
	private String probation_period;
	private String comment_technical_professional_knowledge;
	private String comment_appearance;
	private String comment_manners;
	private String comment_overall;
	private String submission_date;
	

	private RoleBean roleBean;
	private JobLocationBean jobLocationBean;
	private DepartmentBean departmentBean;
	private InterviewedByBean interviewedByBean;
	private VacancyFormBean vacancyFormBean;
	private ResumeDataBean resumeDataBean;
	private EmployeeBean employeeBean;
	
	public InterviewFeedbackBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public InterviewFeedbackBean(String interview_date,
			String start_time, String end_time, String comments, String technical_professional_knowledge,
			String work_experience, String appearance, String manners, String overall, String decision,
			JobLocationBean jobLocationBean, EmployeeBean employeeBean,VacancyFormBean vacancyFormBean, String comment_technical_professional_knowledge,
			String comment_appearance,String comment_manners,String comment_overall, String submissoin_date,ResumeDataBean resumeDataBean) {
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.technical_professional_knowledge = technical_professional_knowledge;
		this.work_experience = work_experience;
		this.appearance = appearance;
		this.manners = manners;
		this.overall = overall;
		this.decision = decision;
		this.jobLocationBean = jobLocationBean;
		this.employeeBean = employeeBean;
		this.vacancyFormBean = vacancyFormBean;
		this.comment_technical_professional_knowledge = comment_technical_professional_knowledge;
		this.comment_appearance = comment_appearance;
		this.comment_manners = comment_manners;
		this.comment_overall = comment_overall;
		this.submission_date = submissoin_date;
		this.resumeDataBean = resumeDataBean;
	
	}
	
	
	public InterviewFeedbackBean(String interview_date,
			String start_time, String end_time, String comments, String technical_professional_knowledge,
			String work_experience, String appearance, String manners, String overall, String decision,
			String reject_reason, JobLocationBean jobLocationBean, EmployeeBean employeeBean,VacancyFormBean vacancyFormBean, String comment_technical_professional_knowledge,
			String comment_appearance,String comment_manners,String comment_overall, String submissoin_date,ResumeDataBean resumeDataBean)
	{
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.technical_professional_knowledge = technical_professional_knowledge;
		this.work_experience = work_experience;
		this.appearance = appearance;
		this.manners = manners;
		this.overall = overall;
		this.decision = decision;
		this.reject_reason = reject_reason;
		this.jobLocationBean = jobLocationBean;
		this.employeeBean = employeeBean;
		this.vacancyFormBean = vacancyFormBean;
		this.comment_technical_professional_knowledge = comment_technical_professional_knowledge;
		this.comment_appearance = comment_appearance;
		this.comment_manners = comment_manners;
		this.comment_overall = comment_overall;
		this.submission_date = submissoin_date;
		this.resumeDataBean = resumeDataBean;
	}


	public InterviewFeedbackBean(String interview_date,
			String start_time, String end_time, String comments, String technical_professional_knowledge,
			String work_experience, String appearance, String manners, String overall, String decision,
			String joining_in_days, String salary, String probation_period,
			JobLocationBean jobLocationBean, DepartmentBean departmentBean, EmployeeBean employeeBean,VacancyFormBean vacancyFormBean, 
			String comment_technical_professional_knowledge,
			String comment_appearance,String comment_manners,String comment_overall, String submissoin_date,ResumeDataBean resumeDataBean,RoleBean roleBean) {
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.technical_professional_knowledge = technical_professional_knowledge;
		this.work_experience = work_experience;
		this.appearance = appearance;
		this.manners = manners;
		this.overall = overall;
		this.decision = decision;
		this.joining_in_days = joining_in_days;
		this.salary = salary;
		this.probation_period = probation_period;
		this.jobLocationBean = jobLocationBean;
		this.departmentBean = departmentBean;
		this.employeeBean = employeeBean;
		this.vacancyFormBean = vacancyFormBean;
		this.comment_technical_professional_knowledge = comment_technical_professional_knowledge;
		this.comment_appearance = comment_appearance;
		this.comment_manners = comment_manners;
		this.comment_overall = comment_overall;
		this.submission_date = submissoin_date;
		this.resumeDataBean = resumeDataBean;
		this.roleBean = roleBean;
		
	}

	@Id
	@Column(name = "interview_feedback_id")
	@GeneratedValue
	public int getInterview_feedback_id() {
		return interview_feedback_id;
	}
	
	public void setInterview_feedback_id(int interview_feedback_id) {
		this.interview_feedback_id = interview_feedback_id;
	}
	
	
	
	public String getInterview_date() {
		return interview_date;
	}
	
	public void setInterview_date(String interview_date) {
		this.interview_date = interview_date;
	}
	
	public String getStart_time() {
		return start_time;
	}
	
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	public String getEnd_time() {
		return end_time;
	}
	
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getTechnical_professional_knowledge() {
		return technical_professional_knowledge;
	}
	
	public void setTechnical_professional_knowledge(String technical_professional_knowledge) {
		this.technical_professional_knowledge = technical_professional_knowledge;
	}
	
	public String getWork_experience() {
		return work_experience;
	}
	
	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
	}
	
	public String getAppearance() {
		return appearance;
	}
	
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}
	
	public String getManners() {
		return manners;
	}
	
	public void setManners(String manners) {
		this.manners = manners;
	}
	
	public String getOverall() {
		return overall;
	}
	
	public void setOverall(String overall) {
		this.overall = overall;
	}
	
	public String getDecision() {
		return decision;
	}
	
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	public String getReject_reason() {
		return reject_reason;
	}
	
	public void setReject_reason(String reject_reason) {
		this.reject_reason = reject_reason;
	}
	
	
	public String getJoining_in_days() {
		return joining_in_days;
	}
	
	public void setJoining_in_days(String joining_in_days) {
		this.joining_in_days = joining_in_days;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getProbation_period() {
		return probation_period;
	}

	public void setProbation_period(String probation_period) {
		this.probation_period = probation_period;
	}


	
	

	public String getComment_technical_professional_knowledge() {
		return comment_technical_professional_knowledge;
	}




	public void setComment_technical_professional_knowledge(String comment_technical_professional_knowledge) {
		this.comment_technical_professional_knowledge = comment_technical_professional_knowledge;
	}




	public String getComment_appearance() {
		return comment_appearance;
	}




	public void setComment_appearance(String comment_appearance) {
		this.comment_appearance = comment_appearance;
	}




	public String getComment_manners() {
		return comment_manners;
	}




	public void setComment_manners(String comment_manners) {
		this.comment_manners = comment_manners;
	}




	public String getComment_overall() {
		return comment_overall;
	}




	public void setComment_overall(String comment_overall) {
		this.comment_overall = comment_overall;
	}




	public String getSubmission_date() {
		return submission_date;
	}




	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}




	@ManyToOne
	@JoinColumn(name = "job_location_id")
	public JobLocationBean getJobLocationBean() {
		return jobLocationBean;
	}
	
	public void setJobLocationBean(JobLocationBean jobLocationBean) {
		this.jobLocationBean = jobLocationBean;
	}
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
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
	@JoinColumn(name = "vacancy_id")
	public VacancyFormBean getVacancyFormBean() {
		return vacancyFormBean;
	}




	public void setVacancyFormBean(VacancyFormBean vacancyFormBean) {
		this.vacancyFormBean = vacancyFormBean;
	}



	@ManyToOne
	@JoinColumn(name = "resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}




	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}



	@ManyToOne
	@JoinColumn(name = "role_id")
	public RoleBean getRoleBean() {
		return roleBean;
	}




	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}
	
	
	
	
	
}
