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
import com.hrms.recruitement.bean.FinalSelectionBean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.OfferLetterBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class OfferLetterInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
		ResumeDataBean resumeDataBean = new ResumeDataBean();
		resumeDataBean.setResume_data_id(resume_data_id);
		System.out.println("resume_data_id"+resume_data_id);
		
		int final_selection_id = Integer.parseInt(request.getParameter("final_selection_id"));
		FinalSelectionBean finalSelectionBean = new FinalSelectionBean();
		finalSelectionBean.setFinal_selection_id(final_selection_id);
		System.out.println("final_selection_id"+final_selection_id);
		
		int role_id = Integer.parseInt(request.getParameter("designation"));
		RoleBean roleBean = new RoleBean();
		roleBean.setRole_id(role_id);
		System.out.println("role_id" + role_id);
		
		int job_location_id = Integer.parseInt(request.getParameter("jobLocation"));
		JobLocationBean jobLocationBean = new JobLocationBean();
		jobLocationBean.setJob_location_id(job_location_id);
		System.out.println("job location id"+ job_location_id);
		
		int company_list_id = Integer.parseInt(request.getParameter("companyName"));
		CompanyListBean companyListBean = new CompanyListBean();
		companyListBean.setCompany_list_id(company_list_id);
		System.out.println("company list id"+company_list_id);
		
		/*int department_id = Integer.parseInt(request.getParameter("department"));
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartment_id(department_id);
		System.out.println("department_id" + department_id);*/
		
		String joining_date = request.getParameter("joiningDate");
		System.out.println("joining_date" + joining_date);
		
		String submission_date = request.getParameter("submission_date");
		System.out.println("submission_date"+submission_date);

		AllInsertDAO allInsertDAO = new AllInsertDAO();
		OfferLetterBean offerLetterBean = new OfferLetterBean(joining_date, submission_date, jobLocationBean, roleBean,
				companyListBean, resumeDataBean, finalSelectionBean);

		boolean result = allInsertDAO.offerLetterInsert(offerLetterBean);
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result1 = allUpdateDAO.feedbackUpdate(final_selection_id);
		boolean result2 = allUpdateDAO.resumeStatusUpdateAtOfferLetter(resume_data_id);
		
		if(result == true && result1 == true && result2 == true){
		response.sendRedirect("hrHome.jsp");
		} else
		{
			response.sendRedirect("offerLetterList.jsp");
		}
		
		}

}
