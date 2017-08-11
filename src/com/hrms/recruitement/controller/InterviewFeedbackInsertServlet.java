package com.hrms.recruitement.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.hrms.recruitement.bean.BenefitsBean;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.InterviewQaWithResumeidBean;
import com.hrms.recruitement.bean.InterviewQuestionBean;
import com.hrms.recruitement.bean.InterviewedByBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;
import com.hrms.recruitement.dao.VacancyFormDAO;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.timesheet.bean.TimeSheetBean;

/**
 * Servlet implementation class InterviewFeedbackInsertServlet
 */
public class InterviewFeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String candidate_name = null;
			String interview_date = null;
			String start_time = null;
			String end_time = null;
			String comments = null;
			String technical_professional_knowledge = null;
			String work_experience = null;
			String appearance = null;
			String manners = null;
			String overall = null;
			String decision = null;
			String reject_reason = null;
			String designation = null;
			int role_id = 0;
			String joining_in_days = null;
			int department_id = 0;
			int manager_id = 0;
			String salary = null;
			String probation_period = null;
			int interview_feedback_id = 0;
			int vacancy_id = 0;
			String comment_technical_professional_knowledge = null;
			String comment_appearance = null;
			String comment_manners = null;
			String comment_overall = null;
			String submission_date = null;
			int resume_id = 0;
			int project_master_id = 18;
			int task_master_id = 71;
			int client_master_id = 1;
			int day_id = 0;
			String status = "interview completed";

			RoleBean roleBean = new RoleBean();

			resume_id = Integer.parseInt(request.getParameter("resume_id"));
			System.out.println("resume_id" + resume_id);
			candidate_name = request.getParameter("candidateName");
			System.out.println("Name " + candidate_name);
			manager_id = Integer.parseInt(request.getParameter("interviewedBy"));
			System.out.println("interviewedby " + manager_id);
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
			technical_professional_knowledge = request.getParameter("technicalProfessionalKnowledge");
			System.out.println("technical_professional_knowledge " + technical_professional_knowledge);
			work_experience = request.getParameter("workExperience");
			System.out.println("work_experience " + work_experience);
			appearance = request.getParameter("appearance");
			System.out.println("appearance " + appearance);
			manners = request.getParameter("manners");
			System.out.println("manners " + manners);
			overall = request.getParameter("overall");
			System.out.println("overall " + overall);
			decision = request.getParameter("decision");
			System.out.println("decision " + decision);
			vacancy_id = Integer.parseInt(request.getParameter("titleOfPosition"));
			System.out.println("vacancy_id:" + vacancy_id);
			comment_technical_professional_knowledge = request.getParameter("commentTechnicalProfessionalKnowledge");
			System.out.println("comment_technical_professional_knowledge" + comment_technical_professional_knowledge);
			role_id = Integer.parseInt(request.getParameter("designation"));

			comment_appearance = request.getParameter("commentAppearance");
			System.out.println("comment_appearance" + comment_appearance);

			comment_manners = request.getParameter("commentManners");
			System.out.println("comment_manners" + comment_manners);

			comment_overall = request.getParameter("commentOverall");
			System.out.println("commentOverall:" + comment_overall);

			roleBean.setRole_id(role_id);
			System.out.println("role_id :" + role_id);

			ResumeDataBean resumeDataBean = new ResumeDataBean();
			InterviewQuestionBean interviewQuestionBean = new InterviewQuestionBean();

			resumeDataBean.setResume_data_id(resume_id);

			/*
			 * List<Integer> questionList = new ArrayList<>(); List<String>
			 * answerList = new ArrayList<>(); List<String> ratingList = new
			 * ArrayList<>();
			 * 
			 * String[] question_id = request.getParameterValues("question_id");
			 * String[] answer = request.getParameterValues("answer"); String[]
			 * rating = request.getParameterValues("rating");
			 * 
			 * for(String q_id:question_id){ System.out.println("q_id :"+ q_id);
			 * int qid = Integer.parseInt(q_id); questionList.add(qid); }
			 * 
			 * for(String ans:answer){ System.out.println("answer :"+ans);
			 * answerList.add(ans); } for(String rat:rating){
			 * System.out.println("rating :"+ rat); ratingList.add(rat); }
			 * 
			 * for(int i=0;i<question_id.length;i++){ int qqid =
			 * questionList.get(i);
			 * interviewQuestionBean.setInterview_question_id(qqid); String
			 * answer1 = answerList.get(i); String rating1 = ratingList.get(i);
			 * 
			 * AllInsertDAO allInsertDAO = new AllInsertDAO();
			 * InterviewQaWithResumeidBean interviewQaWithResumeidBean = new
			 * InterviewQaWithResumeidBean(answer1, rating1,
			 * interviewQuestionBean, resumeDataBean); boolean result =
			 * allInsertDAO.interviewQaWithResumeidInsert(
			 * interviewQaWithResumeidBean); }
			 * 
			 * 
			 * 
			 * 
			 * System.out.println("size:"+question_id.length);
			 */

			submission_date = request.getParameter("submission_date");
			System.out.println("submission_date" + submission_date);
			/*
			 * int st = Integer.parseInt("start_time"); int et =
			 * Integer.parseInt("end_time");
			 */
			int employee_master_id = user.getEmployee_master_id();
			String task_time_status = "saved";
			String approval_status = "pending";
			String rejection_reason = null;
			String employee_comment = null;
			String manager_comment = null;
			String external_task_name = null;
			int leave_id = 0;
			int percentage_completed = 100;
			int worked_hours = 0;
			String date = interview_date;
			String dayOfWeek = null;

			System.out.println(date);

			try {

				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);

				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1);

				System.out.println(dayOfWeek);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (dayOfWeek.equalsIgnoreCase("Monday")) {
				day_id = 1;
			} else if (dayOfWeek.equalsIgnoreCase("Tuesday")) {
				day_id = 2;
			} else if (dayOfWeek.equalsIgnoreCase("Wednesday")) {
				day_id = 3;
			} else if (dayOfWeek.equalsIgnoreCase("Thursday")) {
				day_id = 4;
			} else if (dayOfWeek.equalsIgnoreCase("Friday")) {
				day_id = 5;
			} else if (dayOfWeek.equalsIgnoreCase("Saturday")) {
				day_id = 6;
			} else if (dayOfWeek.equalsIgnoreCase("Sunday")) {
				day_id = 7;
			}

			JobLocationBean jobLocationBean = new JobLocationBean();
			jobLocationBean.setJob_location_id(Place);

			ManagerBean managerBean = new ManagerBean();
			managerBean.setManager_id(manager_id);

			InterviewedByBean interviewedByBean = new InterviewedByBean();

			InterviewFeedbackBean interviewFeedbackBean = new InterviewFeedbackBean();

			VacancyFormBean vacancyFormBean = new VacancyFormBean();
			vacancyFormBean.setVacancy_id(vacancy_id);

			AllInsertDAO allInsertDAO = new AllInsertDAO();
			TimeSheetBean timeSheetBean = new TimeSheetBean();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);
			ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			projectMasterBean.setProject_master_id(project_master_id);
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			taskMasterBean.setTask_master_id(task_master_id);
			ClientMasterBean clientMasterBean = new ClientMasterBean();
			clientMasterBean.setClient_master_id(client_master_id);
			DayBean dayBean = new DayBean();
			dayBean.setDay_id(day_id);

			if (decision.equalsIgnoreCase("rejected")) {

				interview_feedback_id = interviewFeedbackBean.getInterview_feedback_id();
				interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				reject_reason = request.getParameter("rejectReason");
				System.out.println("reject_reason " + reject_reason);

				interviewFeedbackBean = new InterviewFeedbackBean(interview_date, start_time, end_time, comments,
						technical_professional_knowledge, work_experience, appearance, manners, overall, decision,
						reject_reason, jobLocationBean, employeeBean, vacancyFormBean,
						comment_technical_professional_knowledge, comment_appearance, comment_manners, comment_overall,
						submission_date, resumeDataBean);
				timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBean, taskMasterBean, clientMasterBean,
						dayBean, date, worked_hours, employee_comment, task_time_status, approval_status,
						percentage_completed, external_task_name);
				boolean result = allInsertDAO.interviewfeedbackInsert(interviewFeedbackBean);
				boolean result1 = allInsertDAO.timeSheetInsert(timeSheetBean);
				if (result == true) {
					AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
					boolean result2 = allUpdateDAO.resumeStatusUpdate(status, resume_id);
					System.out.println("Successful");
				}

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

				interview_feedback_id = interviewFeedbackBean.getInterview_feedback_id();
				interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				interviewFeedbackBean = new InterviewFeedbackBean(interview_date, start_time, end_time, comments,
						technical_professional_knowledge, work_experience, appearance, manners, overall, decision,
						joining_in_days, salary, probation_period, jobLocationBean, departmentBean, employeeBean,
						vacancyFormBean, comment_technical_professional_knowledge, comment_appearance, comment_manners,
						comment_overall, submission_date, resumeDataBean, roleBean);
				timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBean, taskMasterBean, clientMasterBean,
						dayBean, date, worked_hours, employee_comment, task_time_status, approval_status,
						percentage_completed, external_task_name);
				boolean result = allInsertDAO.interviewfeedbackInsert(interviewFeedbackBean);
				boolean result1 = allInsertDAO.timeSheetInsert(timeSheetBean);
				if (result == true) {
					AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
					boolean result2 = allUpdateDAO.resumeStatusUpdate(status, resume_id);
					System.out.println("Successful");
				}
				if (user.getRoleBean().getRole_id() == 12) {
					response.sendRedirect("hrHome.jsp");

				} else {

					response.sendRedirect("managerHome.jsp");

				}
			} else {

				interview_feedback_id = interviewFeedbackBean.getInterview_feedback_id();
				interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);
				System.out.println(interview_feedback_id);

				interviewFeedbackBean = new InterviewFeedbackBean(interview_date, start_time, end_time, comments,
						technical_professional_knowledge, work_experience, appearance, manners, overall, decision,
						jobLocationBean, employeeBean, vacancyFormBean, comment_technical_professional_knowledge,
						comment_appearance, comment_manners, comment_overall, submission_date, resumeDataBean);
				timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBean, taskMasterBean, clientMasterBean,
						dayBean, date, worked_hours, employee_comment, task_time_status, approval_status,
						percentage_completed, external_task_name);
				boolean result = allInsertDAO.interviewfeedbackInsert(interviewFeedbackBean);
				boolean result1 = allInsertDAO.timeSheetInsert(timeSheetBean);
				if (result == true) {
					AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
					boolean result2 = allUpdateDAO.resumeStatusUpdate(status, resume_id);
					System.out.println("Successful");
				}
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