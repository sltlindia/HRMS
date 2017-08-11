package com.hrms.recruitement.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.OfferLetterBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class OfferLetterInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String interview_id = request.getParameter("candidateName");
		int interview_feedback_id = Integer.parseInt(interview_id);
		
		String roleid = request.getParameter("designation");
		int role_id = Integer.parseInt(roleid);
		
		String vacancyid = request.getParameter("titleOfPosition");
		int vacancy_id = Integer.parseInt(vacancyid);
		
		String joblocationid = request.getParameter("jobLocation");
		int job_location_id = Integer.parseInt(joblocationid);
		
		String companylistid = request.getParameter("companyName");
		int company_list_id = Integer.parseInt(companylistid);
		
		String departmentid = request.getParameter("department");
		int department_id = Integer.parseInt(departmentid);
		
		String gross_salary = request.getParameter("grossSalary");
		
		String joining_date = request.getParameter("joiningDate");
		
		String probation_period = request.getParameter("probationPeriod");
		
		InterviewFeedbackBean interviewFeedbackBean = new InterviewFeedbackBean();
		interviewFeedbackBean.setInterview_feedback_id(interview_feedback_id);

		RoleBean roleBean = new RoleBean();
		roleBean.setRole_id(role_id);
		
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartment_id(department_id);
		System.out.println("department_id"+department_id);
		
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		vacancyFormBean.setVacancy_id(vacancy_id);
		
		JobLocationBean jobLocationBean = new JobLocationBean();
		jobLocationBean.setJob_location_id(job_location_id);
		
		CompanyListBean companyListBean = new CompanyListBean();
		companyListBean.setCompany_list_id(company_list_id);
		
		System.out.println(company_list_id);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String submission_date = dateFormat.format(date);
	
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		OfferLetterBean offerLetterBean = new OfferLetterBean(gross_salary, joining_date, probation_period, jobLocationBean,
				interviewFeedbackBean, vacancyFormBean, roleBean, companyListBean,submission_date,departmentBean);
		boolean result = allInsertDAO.offerLetterInsert(offerLetterBean);
		int offerlettr_id = offerLetterBean.getOffer_letter_id();
		int feedback_id = Integer.parseInt(request.getParameter("feedback_id"));
		AllUpdateDAO allUpdateDAO  = new AllUpdateDAO();
		boolean result1 = allUpdateDAO.feedbackUpdate(feedback_id);
		
		request.setAttribute("offerletterid", offerlettr_id);
		request.getRequestDispatcher("automaticOfferLetter.jsp").forward(request, response);
	}

}
