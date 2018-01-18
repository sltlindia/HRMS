package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.HRInterviewFeedbackBean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.InterviewQuestionBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;
public class HrInterviewFeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String interview_date = null;
			String start_time = null;
			String end_time = null;
			String comments = null;
			String relevance_of_education = null;
			String work_experience = null;
			String communication_skills = null;
			String interest_in_position = null;
			String presentation = null;
			String decision = null;
			String proceed_for_next_round = null;
			String reject_reason = null;
			String designation = null;
			int role_id = 0;
			String joining_in_days = null;
			int department_id = 0;
			String salary = null;
			String probation_period = null;
			int interview_feedback_id = 0;
			String comment_relevance_of_education = null;
			String comment_communication_skills = null;
			String comment_interest_in_position = null;
			String comment_presentation = null;
			String problem_solving_skill = null;
			String computer_skill = null;
			String job_stability = null;
			String total = null;
			String comment_problem_solving_skill = null;
			String comment_computer_skill = null;
			String comment_job_stability = null;
			String comment_total = null;
			String submission_date = null;
			int resume_id = 0;
			String status = "interview completed";

			RoleBean roleBean = new RoleBean();

			resume_id = Integer.parseInt(request.getParameter("candidateName"));
			System.out.println("resume_id" + resume_id);
			interview_date = request.getParameter("interviewDate");
			System.out.println("Date " + interview_date);
			int Place = Integer.parseInt(request.getParameter("Place"));
			System.out.println("Place " + Place);
			start_time = request.getParameter("startTime");
			System.out.println("start_time " + start_time);
			end_time = request.getParameter("endTime");
			System.out.println("end_time " + end_time);
			comments = request.getParameter("comments");
			System.out.println("comments " + comments);
			relevance_of_education = request.getParameter("relevanceOfEducationTraining");
			System.out.println("relevance_of_education " + relevance_of_education);
			work_experience = request.getParameter("workExperience");
			System.out.println("work_experience " + work_experience);
			communication_skills = request.getParameter("communicationSkill");
			System.out.println("communication_skills " + communication_skills);
			interest_in_position = request.getParameter("interestInPositionAndDomainKnowledge");
			System.out.println("interest_in_position " + interest_in_position);
			presentation = request.getParameter("presentation");
			System.out.println("presentation " + presentation);
			decision = request.getParameter("decision");
			System.out.println("decision " + decision);
			comment_relevance_of_education = request.getParameter("commentRelevanceOfEducationTraining");
			System.out.println("comment_relevance_of_education" + comment_relevance_of_education);
			role_id = Integer.parseInt(request.getParameter("designation"));

			comment_communication_skills = request.getParameter("commentCommunicationSkill");
			System.out.println("comment_communication_skills" + comment_communication_skills);

			comment_interest_in_position = request.getParameter("commentInterestInPositionAndDomainKnowledge");
			System.out.println("comment_interest_in_position" + comment_interest_in_position);

			comment_presentation = request.getParameter("commentPresentation");
			System.out.println("comment_presentation:" + comment_presentation);
			
			problem_solving_skill = request.getParameter("problemSolvingSkillsDecisionMakingSkills");
			System.out.println("problem_solving_skills:" + problem_solving_skill);
			computer_skill = request.getParameter("computerSkills");
			System.out.println("computer_skills:" + computer_skill);
			job_stability = request.getParameter("jobStabilityJobCommitment");
			System.out.println("job_stability:" + job_stability);
			total = request.getParameter("total");
			System.out.println("total:" + total);
			
			comment_problem_solving_skill = request.getParameter("commentProblemSolvingSkillsDecisionMakingSkills");
			System.out.println("comment_problem_solving_skills:" + comment_problem_solving_skill);
			comment_computer_skill = request.getParameter("commentComputerSkills");
			System.out.println("comment_computer_skills:" + comment_computer_skill);
			comment_job_stability = request.getParameter("commentJobStabilityJobCommitment");
			System.out.println("comment_job_stability:" + comment_job_stability);
			comment_total = request.getParameter("commentTotal");
			System.out.println("comment_total:" + comment_total);
			
			proceed_for_next_round = request.getParameter("nextProceed");
			System.out.println("proceed_for_next_round"+ proceed_for_next_round);

			roleBean.setRole_id(role_id);
			System.out.println("role_id :" + role_id);

			ResumeDataBean resumeDataBean = new ResumeDataBean();

			resumeDataBean.setResume_data_id(resume_id);

			

			submission_date = request.getParameter("submission_date");
			System.out.println("submission_date" + submission_date);
			
			int employee_master_id = user.getEmployee_master_id();
			String date = interview_date;

			System.out.println(date);

			JobLocationBean jobLocationBean = new JobLocationBean();
			jobLocationBean.setJob_location_id(Place);



			HRInterviewFeedbackBean hrInterviewFeedbackBean = new HRInterviewFeedbackBean();


			AllInsertDAO allInsertDAO = new AllInsertDAO();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);

			if (decision.equalsIgnoreCase("rejected")) {

				interview_feedback_id = hrInterviewFeedbackBean.getHr_interview_feedback_id();
				hrInterviewFeedbackBean.setHr_interview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				reject_reason = request.getParameter("rejectReason");
				System.out.println("reject_reason " + reject_reason);

				hrInterviewFeedbackBean = new HRInterviewFeedbackBean(interview_date, start_time, end_time, comments, 
						work_experience, relevance_of_education, communication_skills, interest_in_position, 
						presentation, decision, reject_reason, comment_relevance_of_education, 
						comment_communication_skills, comment_interest_in_position, comment_presentation, 
						submission_date, problem_solving_skill, computer_skill, job_stability, total, 
						comment_problem_solving_skill, comment_computer_skill, comment_job_stability, 
						comment_total, jobLocationBean, resumeDataBean, employeeBean);
						
						
				boolean result = allInsertDAO.hrinterviewfeedbackInsert(hrInterviewFeedbackBean);
				
				if (user.getRoleBean().getRole_id() == 12) {
					response.sendRedirect("hrHome.jsp");

				} else {

					response.sendRedirect("managerHome.jsp");

				}
			} else if (decision.equalsIgnoreCase("selected")) {

				department_id = Integer.parseInt(request.getParameter("hiringDepartment"));
				System.out.println("hiringDepartment " + department_id);
				DepartmentBean departmentBean = new DepartmentBean();
				departmentBean.setDepartment_id(department_id);
				designation = request.getParameter("designation");
				System.out.println("designation " + designation);
				
			
				joining_in_days = request.getParameter("joiningInDays");
				System.out.println("joiningInDays " + joining_in_days);
				salary = request.getParameter("salary");
				System.out.println("salary " + salary);
				probation_period = request.getParameter("probationPeriod");
				System.out.println("probationPeriod " + probation_period);

				interview_feedback_id = hrInterviewFeedbackBean.getHr_interview_feedback_id();
				hrInterviewFeedbackBean.setHr_interview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				hrInterviewFeedbackBean = new HRInterviewFeedbackBean(interview_date, start_time, end_time, comments,
						work_experience, relevance_of_education, communication_skills, interest_in_position, 
						presentation, decision, joining_in_days, salary, probation_period, comment_relevance_of_education, 
						comment_communication_skills, comment_interest_in_position, comment_presentation, submission_date,
						problem_solving_skill, computer_skill, job_stability, total, comment_problem_solving_skill, 
						comment_computer_skill, comment_job_stability, comment_total, roleBean, jobLocationBean, 
						departmentBean, resumeDataBean, employeeBean);
				boolean result = allInsertDAO.hrinterviewfeedbackInsert(hrInterviewFeedbackBean);
				
				if (user.getRoleBean().getRole_id() == 12) {
					response.sendRedirect("hrHome.jsp");

				} else {

					response.sendRedirect("managerHome.jsp");
				}
			}else if (decision.equalsIgnoreCase("proceed for next round")) {

				department_id = Integer.parseInt(request.getParameter("hiringDepartment"));
				System.out.println("hiringDepartment " + department_id);
				DepartmentBean departmentBean = new DepartmentBean();
				departmentBean.setDepartment_id(department_id);
				designation = request.getParameter("designation");
				System.out.println("designation " + designation);
				
			
				joining_in_days = request.getParameter("joiningInDays");
				System.out.println("joiningInDays " + joining_in_days);
				salary = request.getParameter("salary");
				System.out.println("salary " + salary);
				probation_period = request.getParameter("probationPeriod");
				System.out.println("probationPeriod " + probation_period);

				interview_feedback_id = hrInterviewFeedbackBean.getHr_interview_feedback_id();
				hrInterviewFeedbackBean.setHr_interview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				hrInterviewFeedbackBean = new HRInterviewFeedbackBean(interview_date, start_time, end_time, comments, 
						work_experience, relevance_of_education, communication_skills, interest_in_position, presentation,
						decision, proceed_for_next_round, comment_relevance_of_education, comment_communication_skills, 
						comment_interest_in_position, comment_presentation, submission_date, problem_solving_skill, 
						computer_skill, job_stability, total, comment_problem_solving_skill, comment_computer_skill, 
						comment_job_stability, comment_total, resumeDataBean, employeeBean);
				boolean result = allInsertDAO.hrinterviewfeedbackInsert(hrInterviewFeedbackBean);
				
				if (user.getRoleBean().getRole_id() == 12) {
					response.sendRedirect("hrHome.jsp");

				} else {

					response.sendRedirect("managerHome.jsp");

				}
			}
			else if (decision.equalsIgnoreCase("on hold"))
			{
				department_id = Integer.parseInt(request.getParameter("hiringDepartment"));
				System.out.println("hiringDepartment " + department_id);
				DepartmentBean departmentBean = new DepartmentBean();
				departmentBean.setDepartment_id(department_id);
				designation = request.getParameter("designation");
				System.out.println("designation " + designation);
				
				String remark = request.getParameter("OnHold");
				System.out.println("remark" + remark);
				interview_feedback_id = hrInterviewFeedbackBean.getHr_interview_feedback_id();
				hrInterviewFeedbackBean.setHr_interview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				hrInterviewFeedbackBean = new HRInterviewFeedbackBean(interview_date, start_time, end_time, comments, 
						work_experience, relevance_of_education, communication_skills, interest_in_position, presentation,
						decision, proceed_for_next_round, comment_relevance_of_education, comment_communication_skills, 
						comment_interest_in_position, comment_presentation, submission_date, problem_solving_skill, 
						computer_skill, job_stability, total, comment_problem_solving_skill, comment_computer_skill, 
						comment_job_stability, comment_total, remark, resumeDataBean, employeeBean);
				boolean result = allInsertDAO.hrinterviewfeedbackInsert(hrInterviewFeedbackBean);
				
				if (user.getRoleBean().getRole_id() == 12) {
					response.sendRedirect("hrHome.jsp");

				} else {

					response.sendRedirect("managerHome.jsp");

				}
				
				
			}
		else {

				interview_feedback_id = hrInterviewFeedbackBean.getHr_interview_feedback_id();
				hrInterviewFeedbackBean.setHr_interview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				hrInterviewFeedbackBean = new HRInterviewFeedbackBean(interview_date, start_time, end_time, comments, 
						relevance_of_education, work_experience, communication_skills, interest_in_position, 
						presentation, problem_solving_skill, computer_skill, job_stability, total, decision, 
						jobLocationBean, employeeBean, comment_relevance_of_education, 
						comment_communication_skills, comment_interest_in_position, comment_presentation, 
						comment_problem_solving_skill, comment_computer_skill, comment_job_stability, 
						comment_total, submission_date, resumeDataBean);
				boolean result = allInsertDAO.hrinterviewfeedbackInsert(hrInterviewFeedbackBean);
				
				if (user.getRoleBean().getRole_id() == 12) {
					response.sendRedirect("hrHome.jsp");

				} else {

					response.sendRedirect("managerHome.jsp");

				}
			}
		} else {
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
