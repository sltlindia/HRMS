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
	private String work_experience;
	private String relevance_of_education;
	private String communication_skills;
	private String interest_in_position;
	private String presentation;
	private String decision;
	private String proceed_for_next_round;
	private String reject_reason;
	private String joining_in_days;
	private String salary;
	private String probation_period;
	private String comment_relevance_of_education;
	private String comment_communication_skills;
	private String comment_interest_in_position;
	private String comment_presentation;
	private String submission_date;
	private String problem_solving_skills;
	private String computer_skills;
	private String job_stability;
	private String total;
	private String comment_problem_solving_skills;
	private String comment_computer_skills;
	private String comment_job_stability;
	private String comment_total;
	private String remakforshortandhold;
	private RoleBean roleBean;
	private JobLocationBean jobLocationBean;
	private DepartmentBean departmentBean;
	private VacancyFormBean vacancyFormBean;
	private ResumeDataBean resumeDataBean;
	private EmployeeBean employeeBean;
	
	public InterviewFeedbackBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public InterviewFeedbackBean(String interview_date,
			String start_time, String end_time, String comments, String relevance_of_education,
			String work_experience, String communication_skills, String interest_in_position, String presentation, String problem_solving_skills,
			String computer_skills, String job_stability, String total, String decision,
			JobLocationBean jobLocationBean, EmployeeBean employeeBean,VacancyFormBean vacancyFormBean, String comment_relevance_of_education,
			String comment_communication_skills,String comment_interest_in_position, String comment_presentation, String comment_problem_solving_skills,
			String comment_computer_skills, String comment_job_stability, String comment_total, String submissoin_date,ResumeDataBean resumeDataBean) {
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.relevance_of_education = relevance_of_education;
		this.work_experience = work_experience;
		this.communication_skills = communication_skills;
		this.interest_in_position = interest_in_position;
		this.presentation = presentation;
		this.problem_solving_skills = problem_solving_skills;
		this.computer_skills = computer_skills;
		this.job_stability = job_stability;
		this.total = total;
		this.decision = decision;
		this.jobLocationBean = jobLocationBean;
		this.employeeBean = employeeBean;
		this.vacancyFormBean = vacancyFormBean;
		this.comment_relevance_of_education = comment_relevance_of_education;
		this.comment_communication_skills = comment_communication_skills;
		this.comment_interest_in_position = comment_interest_in_position;
		this.comment_presentation = comment_presentation;
		this.comment_problem_solving_skills = comment_problem_solving_skills;
		this.comment_computer_skills = comment_computer_skills;
		this.comment_job_stability = comment_job_stability;
		this.comment_total = comment_total;
		this.submission_date = submissoin_date;
		this.resumeDataBean = resumeDataBean;
	
	}
	
	public InterviewFeedbackBean(String interview_date,
			String start_time, String end_time, String comments, String relevance_of_education,
			String work_experience, String communication_skills, String interest_in_position, String presentation, String problem_solving_skills,
			String computer_skills, String job_stability, String total, String decision,
			JobLocationBean jobLocationBean, EmployeeBean employeeBean,VacancyFormBean vacancyFormBean, String comment_relevance_of_education,
			String comment_communication_skills,String comment_interest_in_position, String comment_presentation, String comment_problem_solving_skills,
			String comment_computer_skills, String comment_job_stability, String comment_total, String submissoin_date,String remakforshortandhold , ResumeDataBean resumeDataBean) {
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.relevance_of_education = relevance_of_education;
		this.work_experience = work_experience;
		this.communication_skills = communication_skills;
		this.interest_in_position = interest_in_position;
		this.presentation = presentation;
		this.problem_solving_skills = problem_solving_skills;
		this.computer_skills = computer_skills;
		this.job_stability = job_stability;
		this.total = total;
		this.decision = decision;
		this.jobLocationBean = jobLocationBean;
		this.employeeBean = employeeBean;
		this.vacancyFormBean = vacancyFormBean;
		this.comment_relevance_of_education = comment_relevance_of_education;
		this.comment_communication_skills = comment_communication_skills;
		this.comment_interest_in_position = comment_interest_in_position;
		this.comment_presentation = comment_presentation;
		this.comment_problem_solving_skills = comment_problem_solving_skills;
		this.comment_computer_skills = comment_computer_skills;
		this.comment_job_stability = comment_job_stability;
		this.comment_total = comment_total;
		this.submission_date = submissoin_date;
		this.remakforshortandhold = remakforshortandhold;
		this.resumeDataBean = resumeDataBean;
	
	}
	
	

	public InterviewFeedbackBean(String interview_date, String start_time, String end_time, String comments,
			String work_experience, String relevance_of_education, String communication_skills,
			String interest_in_position, String presentation, String decision, String reject_reason,
			String comment_relevance_of_education, String comment_communication_skills,
			String comment_interest_in_position, String comment_presentation, String submission_date,
			String problem_solving_skills, String computer_skills, String job_stability, String total,
			String comment_problem_solving_skills, String comment_computer_skills, String comment_job_stability,
			String comment_total, JobLocationBean jobLocationBean, VacancyFormBean vacancyFormBean,
			ResumeDataBean resumeDataBean, EmployeeBean employeeBean) {
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.work_experience = work_experience;
		this.relevance_of_education = relevance_of_education;
		this.communication_skills = communication_skills;
		this.interest_in_position = interest_in_position;
		this.presentation = presentation;
		this.decision = decision;
		this.reject_reason = reject_reason;
		this.comment_relevance_of_education = comment_relevance_of_education;
		this.comment_communication_skills = comment_communication_skills;
		this.comment_interest_in_position = comment_interest_in_position;
		this.comment_presentation = comment_presentation;
		this.submission_date = submission_date;
		this.problem_solving_skills = problem_solving_skills;
		this.computer_skills = computer_skills;
		this.job_stability = job_stability;
		this.total = total;
		this.comment_problem_solving_skills = comment_problem_solving_skills;
		this.comment_computer_skills = comment_computer_skills;
		this.comment_job_stability = comment_job_stability;
		this.comment_total = comment_total;
		this.jobLocationBean = jobLocationBean;
		this.vacancyFormBean = vacancyFormBean;
		this.resumeDataBean = resumeDataBean;
		this.employeeBean = employeeBean;
	}




	public InterviewFeedbackBean(String interview_date, String start_time, String end_time, String comments,
			String work_experience, String relevance_of_education, String communication_skills,
			String interest_in_position, String presentation, String decision, String joining_in_days, String salary,
			String probation_period, String comment_relevance_of_education, String comment_communication_skills,
			String comment_interest_in_position, String comment_presentation, String submission_date,
			String problem_solving_skills, String computer_skills, String job_stability, String total,
			String comment_problem_solving_skills, String comment_computer_skills, String comment_job_stability,
			String comment_total, RoleBean roleBean, JobLocationBean jobLocationBean, DepartmentBean departmentBean,
			ResumeDataBean resumeDataBean, EmployeeBean employeeBean, VacancyFormBean vacancyFormBean) {
		
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.work_experience = work_experience;
		this.relevance_of_education = relevance_of_education;
		this.communication_skills = communication_skills;
		this.interest_in_position = interest_in_position;
		this.presentation = presentation;
		this.decision = decision;
		this.joining_in_days = joining_in_days;
		this.salary = salary;
		this.probation_period = probation_period;
		this.comment_relevance_of_education = comment_relevance_of_education;
		this.comment_communication_skills = comment_communication_skills;
		this.comment_interest_in_position = comment_interest_in_position;
		this.comment_presentation = comment_presentation;
		this.submission_date = submission_date;
		this.problem_solving_skills = problem_solving_skills;
		this.computer_skills = computer_skills;
		this.job_stability = job_stability;
		this.total = total;
		this.comment_problem_solving_skills = comment_problem_solving_skills;
		this.comment_computer_skills = comment_computer_skills;
		this.comment_job_stability = comment_job_stability;
		this.comment_total = comment_total;
		this.roleBean = roleBean;
		this.jobLocationBean = jobLocationBean;
		this.departmentBean = departmentBean;
		this.resumeDataBean = resumeDataBean;
		this.employeeBean = employeeBean;
		this.vacancyFormBean = vacancyFormBean;
	}




	public InterviewFeedbackBean(String interview_date, String start_time, String end_time, String comments,
			String work_experience, String relevance_of_education, String communication_skills,
			String interest_in_position, String presentation, String decision,String proceed_for_next_round, String comment_relevance_of_education,
			String comment_communication_skills, String comment_interest_in_position, String comment_presentation,
			String submission_date, String problem_solving_skills, String computer_skills, String job_stability,
			String total, String comment_problem_solving_skills, String comment_computer_skills,
			String comment_job_stability, String comment_total, VacancyFormBean vacancyFormBean,
			ResumeDataBean resumeDataBean, EmployeeBean employeeBean) {
		super();
		this.interview_date = interview_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.work_experience = work_experience;
		this.relevance_of_education = relevance_of_education;
		this.communication_skills = communication_skills;
		this.interest_in_position = interest_in_position;
		this.presentation = presentation;
		this.decision = decision;
		this.proceed_for_next_round = proceed_for_next_round;
		this.comment_relevance_of_education = comment_relevance_of_education;
		this.comment_communication_skills = comment_communication_skills;
		this.comment_interest_in_position = comment_interest_in_position;
		this.comment_presentation = comment_presentation;
		this.submission_date = submission_date;
		this.problem_solving_skills = problem_solving_skills;
		this.computer_skills = computer_skills;
		this.job_stability = job_stability;
		this.total = total;
		this.comment_problem_solving_skills = comment_problem_solving_skills;
		this.comment_computer_skills = comment_computer_skills;
		this.comment_job_stability = comment_job_stability;
		this.comment_total = comment_total;
		this.vacancyFormBean = vacancyFormBean;
		this.resumeDataBean = resumeDataBean;
		this.employeeBean = employeeBean;
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
	
	
	
	public String getWork_experience() {
		return work_experience;
	}
	
	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
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


	
	

	




	public String getRelevance_of_education() {
		return relevance_of_education;
	}




	public void setRelevance_of_education(String relevance_of_education) {
		this.relevance_of_education = relevance_of_education;
	}




	public String getCommunication_skills() {
		return communication_skills;
	}




	public void setCommunication_skills(String communication_skills) {
		this.communication_skills = communication_skills;
	}




	public String getInterest_in_position() {
		return interest_in_position;
	}




	public void setInterest_in_position(String interest_in_position) {
		this.interest_in_position = interest_in_position;
	}




	public String getPresentation() {
		return presentation;
	}




	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}




	public String getComment_relevance_of_education() {
		return comment_relevance_of_education;
	}




	public void setComment_relevance_of_education(String comment_relevance_of_education) {
		this.comment_relevance_of_education = comment_relevance_of_education;
	}




	public String getComment_communication_skills() {
		return comment_communication_skills;
	}




	public void setComment_communication_skills(String comment_communication_skills) {
		this.comment_communication_skills = comment_communication_skills;
	}




	public String getComment_interest_in_position() {
		return comment_interest_in_position;
	}




	public void setComment_interest_in_position(String comment_interest_in_position) {
		this.comment_interest_in_position = comment_interest_in_position;
	}




	public String getComment_presentation() {
		return comment_presentation;
	}




	public void setComment_presentation(String comment_presentation) {
		this.comment_presentation = comment_presentation;
	}




	public String getProblem_solving_skills() {
		return problem_solving_skills;
	}




	public void setProblem_solving_skills(String problem_solving_skills) {
		this.problem_solving_skills = problem_solving_skills;
	}




	public String getComputer_skills() {
		return computer_skills;
	}




	public void setComputer_skills(String computer_skills) {
		this.computer_skills = computer_skills;
	}




	public String getJob_stability() {
		return job_stability;
	}




	public void setJob_stability(String job_stability) {
		this.job_stability = job_stability;
	}




	public String getTotal() {
		return total;
	}




	public void setTotal(String total) {
		this.total = total;
	}




	public String getComment_problem_solving_skills() {
		return comment_problem_solving_skills;
	}




	public void setComment_problem_solving_skills(String comment_problem_solving_skills) {
		this.comment_problem_solving_skills = comment_problem_solving_skills;
	}




	public String getComment_computer_skills() {
		return comment_computer_skills;
	}




	public void setComment_computer_skills(String comment_computer_skills) {
		this.comment_computer_skills = comment_computer_skills;
	}




	public String getComment_job_stability() {
		return comment_job_stability;
	}




	public void setComment_job_stability(String comment_job_stability) {
		this.comment_job_stability = comment_job_stability;
	}




	public String getComment_total() {
		return comment_total;
	}




	public void setComment_total(String comment_total) {
		this.comment_total = comment_total;
	}



	public String getSubmission_date() {
		return submission_date;
	}




	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}




	public String getProceed_for_next_round() {
		return proceed_for_next_round;
	}




	public void setProceed_for_next_round(String proceed_for_next_round) {
		this.proceed_for_next_round = proceed_for_next_round;
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




	public String getRemakforshortandhold() {
		return remakforshortandhold;
	}




	public void setRemakforshortandhold(String remakforshortandhold) {
		this.remakforshortandhold = remakforshortandhold;
	}
	
	
	
	
	
}
